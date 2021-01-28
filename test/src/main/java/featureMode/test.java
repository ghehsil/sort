package featureMode;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2020/4/17.
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        /*Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(call().toString());
        System.out.println("总耗时:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));*/
        System.out.println('Z'>>1);
    }

    private static Integer call() {
        for (int i = 0; i < 100000000; i++) {
            if (i == 99999999) {
                return 1;
            }
        }
        return 0;
    }
}
