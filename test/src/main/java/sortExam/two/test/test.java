package sortExam.two.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static sortExam.two.test.test.add;

public class test {
    static Integer i = 0;

    /*@de("de")*/
    public static void main(String[] args) throws NoSuchMethodException {
        /*Class c = test.class;
        Method m = c.getMethod("main", String[].class);
        de d = m.getAnnotation(de.class);*/
        /*System.out.println("【郑州人民医院】\n" +
                "\n" +
                "网络视频门诊通知：");*///111 011
        /*for (int i = 0; i < 1000; i++) {
            new Thread(new r()).start();
        }
        System.out.println(i);*/


       /* TplParams m2 = new TplParams();
        m2.put("a","【郑州人民医院】\n");
        Map<String, ?> m1 = m2;
        System.out.println(m1.get("a"));
        System.out.println(m2.get("a"));*/
        String s="1:1|2:2";
        s.split("\\|");
        System.out.println(s.split("\\|").length);
    }

    public static int lengthOfLongestSubstring(String s) {
        List<String> l = new ArrayList<String>();
        String s1;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            s1 = String.valueOf(s.charAt(i));
            if (l.contains(s1)) {
                if (max < l.size()) {
                    max = l.size();
                }
                for (int j = 0; j <= l.indexOf(s1); j++) {
                    l.remove(j);
                    j--;
                }
                l.add(s1);
            } else {
                l.add(s1);
                max = l.size();
            }
        }
        return max;
    }

    public static void add() {
        i++;
    }
}

class TplParams extends HashMap<String, Object>{

}

class r implements Runnable {
    @Override
    public void run() {
        add();
    }
}