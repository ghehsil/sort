package testCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConcurrentTest {
    private static LoadingCache<String, String> stringCache;

    public static void main(String[] args) {
        A a=new A();
        a.setB(2);
        a.setC(3);
        B b=new B();
        b.setA(1);
        BeanUtils.copyProperties(a,b);
        System.out.println(b.getA());
    }

    @Getter
    @Setter
    static class A{
        Integer a;
        Integer b;
        Integer c;
    }

    @Getter
    @Setter
    static class B{
        Integer a;
        Integer b;
        Integer d;
    }

    public static Date getDateAftMinute(Date d, int num) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.add(Calendar.MINUTE, num);
        return now.getTime();
    }

    public static Date getDateAftHour(Date d, int num) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.add(Calendar.HOUR_OF_DAY, num);
        return now.getTime();
    }

    public static Date getDateAftXDays(Date d, int num) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + num);
        return now.getTime();
    }

    public static LoadingCache<String, String> getPushTypeCache() {
        if (stringCache == null) {
            stringCache = createPushTypeCache();
        }
        return stringCache;
    }

    private static LoadingCache<String, String> createPushTypeCache() {
        return CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String name) throws Exception {
                return "aa";
            }
        });
    }
}
