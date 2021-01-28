package three.jsonMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/20.
 */

/*
10 5
{
"firstName":"John",
"lastName":"Smith",
"address":{
"streetAddress":"2ndStreet",
"city":"NewYord",
"state":"NY"
},
"esc\\aped":"\"hello\""
}
firstName
address
address.city
address.postal
esc\aped
* */

/*
 12
{
"a":"a",
"b":{
"aa":"aa",
"bb":{
"bbb":"bbb",
"ccc":"ccc"
},
"cc":"cc"
},
"c":"c"
}
*/
public class jsonMapping {
    static Scanner input = new Scanner(System.in);
    static int i = 0;
    static int mapped = 0;


    public static void main(String[] args) {
        mapped = input.nextInt();
        int mapping = input.nextInt();
        Map<String, Object> map = new HashMap<String, Object>();
        sort(map);

        Loop:
        for (int j = 0; j < mapping; j++) {
            int tmp = 0;
            String strr = "";
            String[] strs = input.next().split("\\.");
            Map<String, Object> m = map;
            for (String str : strs) {
                if (m.get(str) == null) {
                    System.out.println("Not Exit");
                    continue Loop;
                } else if (m.get(str).toString().contains("{")) {
                    m = (Map<String, Object>) m.get(str);
                } else if (!m.get(str).toString().contains("{")) {
                    strr = m.get(str).toString();
                    tmp++;
                }
            }
            if (tmp == 1) {
                System.out.println("String " + strr);
                continue Loop;
            } else if (tmp > 1) {
                System.out.println("Not Exit");
                continue Loop;
            }
            System.out.println("Object");
        }
    }


    public static void sort(Map<String, Object> mapTmp) {
        for (; i < mapped; i++) {
            String in = input.next();

            if (in.equals("{") || in.equals("}")) {
                continue;
            }
            if (in.equals("},")) {
                return;
            }

            String[] ins = in.split(":");
            ins[0] = ins[0].substring(1, ins[0].length() - 1);
            String key = ins[0].replace("\\\"", "\"").replace("\\\\", "\\");

            if (ins[1].equals("{")) {
                i++;
                //先关联一个空的
                mapTmp.put(key, new HashMap<String, Object>());
                sort((Map<String, Object>) mapTmp.get(key));
                continue;
            }

            if (ins[1].contains("\",")) {
                ins[1] = ins[1].substring(1, ins[1].length() - 2);
            } else {
                ins[1] = ins[1].substring(1, ins[1].length() - 1);
            }
            String value = ins[1].replace("\\\"", "\"").replace("\\\\", "\\");

            mapTmp.put(key, value);
        }
    }
}