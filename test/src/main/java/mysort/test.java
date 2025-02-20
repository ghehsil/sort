package mysort;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
//        test t = new test();
//        List<String> errorMsgs = Lists.newArrayList(
//                "第44行，1",
//                "第2222行，22222222",
//                "第333行，1",
//                "第5行，33333333333333333",
//                "第5行，2222",
//                "第11111行，1");
//        System.out.println(JSON.toJSONString(t.sortErrorMsgs(errorMsgs)));
//        String a="阿斯顿a12";
//        System.out.println(a.substring(0,6));

        System.out.println((Long) null);
    }

    private List<String> sortErrorMsgs(List<String> errorMsgs) {
        Map<Integer, List<String>> errorMsgMap = Maps.newHashMap();
        for (String errorMsg : errorMsgs) {
            boolean isNum = false;
            StringBuilder numStr = new StringBuilder();
            for (int i = 0; i < errorMsg.length(); i++) {
                char c = errorMsg.charAt(i);
                if (c >= '0' && c <= '9') {
                    numStr.append(c);
                    isNum = true;
                } else {
                    if (isNum) {
                        break;
                    }
                }
            }
            Integer num = Integer.parseInt(numStr.toString());
            List<String> errorMsgList = errorMsgMap.get(num) == null ? Lists.newArrayList() : errorMsgMap.get(num);
            errorMsgList.add(errorMsg);
            errorMsgMap.put(num, errorMsgList);
        }
        Map<Integer, List<String>> sortMap = new LinkedHashMap<>();
        // key排序
        errorMsgMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(msg -> sortMap.put(msg.getKey(), msg.getValue()));
        List<String> result = Lists.newArrayList();
        for (Map.Entry<Integer, List<String>> entry : sortMap.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    private Long a() {
        Map<String, Object> extConfigMap = Maps.newHashMap();
        extConfigMap.put("123", 1);
        return Long.parseLong(extConfigMap.getOrDefault("123", 0).toString());
    }

}
