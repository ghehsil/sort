package mysort;

import com.google.common.collect.Lists;

import java.util.List;

public class day2 {

    public static void main(String[] args) {
        day2 d = new day2();
        List<String> list = Lists.newArrayList();
        System.out.println(list.size());
        d.set(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    private void set(List<String> list) {
        list.add("111");
    }

}
