package test;

import java.util.HashMap;
import java.util.Map;

public class sameString {
    public static void main(String[] args) {
        String str1 = "strirng";
        String str2 = "gnirrts";
        System.out.println(judge(str1, str2));
    }

    private static boolean judge(String str1, String str2) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (map.containsKey(c)) {
                Integer value = Integer.valueOf(map.get(c).toString());
                map.put(c, ++value);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                if (--value < 0) {
                    return false;
                }
                map.put(c, value);
            } else {
                return false;
            }
        }
        return true;
    }
}
