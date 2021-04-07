package test;

import com.google.common.collect.Sets;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

class test {
    public static void main(String[] args) {
        /*//LinkedHashMap<Integer, String> m = new (10, 0.75F, true);
        Map<Integer, String> m = Maps.newConcurrentMap();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        m.put(4, "d");
        System.out.println(JSONUtils.valueToString(m));
        *//*m.get(2);
        m.get(1);
        System.out.println(JSONUtils.valueToString(m));*//*

        MapIterator mapIterator = new AbstractHashedMap.HashMapIterator(new AbstractHashedMap(m));
        while (mapIterator.hasNext()) {
            Integer key = (Integer) mapIterator.next();
            System.out.print(key);
            String value = (String) mapIterator.getValue();
            System.out.println(value);
        }*/
        /*int i=0;
        for (;i<5;i++){
            System.out.println(i);
        }
        System.out.println(i);*/

        /*Map<Character, Set<Integer>> m = new HashMap();
        int flag = 0;

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ',') {
                flag++;
                continue;
            }
            Set<Integer> s = m.get(c);
            if (s == null || s.size() == 0) {
                Set<Integer> set = Sets.newHashSet();
                set.add(flag);
                m.put(c, set);
            } else {
                s.add(flag);
                m.put(c, s);
            }
        }
        System.out.println(m.get('i'));

        int max = 0;
        int max2 = 0;
        Loop:
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            Integer len = s.length();
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                if (m.get(c).size() > 1) {
                    continue Loop;
                }
            }
            if (max <= len) {
                max = len;
            } else {
                if (max2 < len) {
                    max2 = len;
                }
            }
        }

        System.out.println(max * max2);*/
        System.out.println(5&1);
    }

}
