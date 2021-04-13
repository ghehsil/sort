package sortExam.three.urlMapping;

import java.util.*;

/**
 * Created by EDZ on 2019/6/5.
 */
public class urlMapping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String[]> tempMap = new HashMap<String, String[]>();
        //匹配到的字符串数组集合
        List<String> list = new ArrayList<String>();
        String string;
        //输出字符串集合
        List<String> listPrint = new ArrayList<String>();
        int temp = input.nextInt();
        int target = input.nextInt();
        //跳过一个换行符
        input.nextLine();
        //放入比对字符串Map
        for (int i = 0; i < temp; i++) {
            String str = input.nextLine();
            String[] strs = str.split(" ");
            tempMap.put(strs[1], strs[0].split("/"));
        }
        //重输入一个字符串
        Loop1:
        for (int i = 0; i < target; i++) {
            String str = input.nextLine();
            String[] strs = str.split("/");
            //重试一个匹配串
            Loop:
            for (Map.Entry<String, String[]> map : tempMap.entrySet()) {
                String[] value = map.getValue();
                //数组转回字符串才能判断有没有包含path
                String strings = "";
                for (String string1 : value) {
                    strings += string1;
                }
                //长度不等不包含path跳过
                if (value.length != strs.length) {
                    if (!strings.contains("<path>")) {
                        continue Loop;
                    }
                }
                //长度相等包含path跳过
                else {
                    if (strings.contains("<path>")) {
                        continue Loop;
                    }
                }
                for (int j = 1; j < strs.length; j++) {
                    if (!value[j].equals(strs[j])) {
                        if (!value[j].contains("<")) {
                            list.clear();
                            continue Loop;
                        } else if ("<int>".equals(value[j])) {
                            if (!strs[j].matches("^[0-9]+$")) {
                                list.clear();
                                continue Loop;
                            } else {
                                //去掉前置0
                                int i1 = 0;
                                while (strs[j].charAt(i1) == '0') {
                                    i1++;
                                }
                                list.add(strs[j].substring(i1, strs[j].length()));
                            }
                        } else if ("<str>".equals(value[j])) {
                            if (!strs[j].matches("^[a-z0-9A-Z]+$")) {
                                list.clear();
                                continue Loop;
                            } else {
                                list.add(strs[j]);
                            }
                        } else if ("<path>".equals(value[j])) {
                            String strTemp = "";
                            for (int k = j; k < strs.length; k++) {
                                strTemp += strs[k] + "/";
                            }
                            //去掉最后的"/"
                            strTemp = strTemp.substring(0, strTemp.length() - 1);
                            if (strTemp.matches("^[a-z0-9A-Z-_.]+$")) {
                                list.add(strTemp);
                                break;
                            } else {
                                continue Loop;
                            }
                        }
                    }
                }
                //比对成功
                string = map.getKey();
                for (String Str : list) {
                    string += " " + Str;
                }
                listPrint.add(string);
                list.clear();
                continue Loop1;
            }
            //比对失败
            listPrint.add("404");
        }
        for (String str : listPrint) {
            System.out.println(str);
        }
    }
}
