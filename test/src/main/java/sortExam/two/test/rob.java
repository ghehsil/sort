package sortExam.two.test;

import java.sql.Time;
import java.util.Date;

/**
 * Created by EDZ on 2019/8/14.
 */
//动态规划 f(i) = max(f(i-1), f(i-2) + num[i])
public class rob {
    public static void main(String[] args) {
        rob();
    }

    public static void rob(){
        try {
            Date d=new Date();
            try {
                Thread.sleep(5000); //1000 毫秒，也就是1秒.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Date d1=new Date();
            Time t=new Time(d.getTime());
            Time t1=new Time(d1.getTime());
            System.out.println(d.before(t1));
            System.out.println(d);
            System.out.println(t1);
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }

    }
}
