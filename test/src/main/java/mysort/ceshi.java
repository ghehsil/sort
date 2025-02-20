package mysort;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ceshi {

    private static String getLiveProperty(String title) {
        if (StringUtils.isEmpty(title)) {
            return "";
        }
        Matcher matcher1 = Pattern.compile("\\d+((\\-|\\.)+)?\\d+").matcher(title);
        if (!matcher1.find()) {
            return "";
        }
        StringBuilder result3 = new StringBuilder();
        String result1 = matcher1.group();
        Matcher matcher2 = Pattern.compile("\\d+").matcher(result1);
        int temp = 0;
        while (matcher2.find()) {
            String result2 = matcher2.group();
            // 去掉前缀0
            if (temp++ == 0) {
                char[] chars = result2.toCharArray();
                int i = 0;
                for (; i < chars.length; i++) {
                    if (chars[i] > '0') {
                        break;
                    }
                }
                if (i == chars.length) {
                    result2 = "0";
                } else {
                    result2 = result2.substring(i);
                }
            }
            result3.append(result2).append(".");
        }
        return result3.deleteCharAt(result3.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println("匹配结果3：" + getLiveProperty("0200.010"));
    }

}
