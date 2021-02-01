package test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.sf.json.util.JSONUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 构建顺序
 */
public class BuildOrder {
    private final static String str1 = "ehealth-parent\n" +
            "\n" +
            "ehealth-basic-dto\n" +
            "\n" +
            "ehealth-entity\n" +
            "\n" +
            "ehealth-utils\n" +
            "\n" +
            "ehealth-base-api\n" +
            "\n" +
            "ehealth-basic-api\n" +
            "\n" +
            "ehealth-his-server-api";

    private final static String str2 = "easy-pay-entity\n" +
            "\n" +
            "ngari-rtm\n" +
            "\n" +
            "ehealth-es-api\n" +
            "\n" +
            "ehealth-meetclinic-api\n" +
            "\n" +
            "ehealth-consult-api\n" +
            "\n" +
            "ehealth-gift-api\n" +
            "\n" +
            "ehealth-livecourse-api\n" +
            "\n" +
            "ehealth-nursing-api\n" +
            "\n" +
            "ehealth-follow-up-api\n" +
            "\n" +
            "ehealth-recipe-api\n" +
            "\n" +
            "ehealth-appointsource-api\n" +
            "\n" +
            "ehealth-appoint-api\n" +
            "\n" +
            "ehealth-transfer-api\n" +
            "\n" +
            "ehealth-evaluation-api\n" +
            "\n" +
            "ehealth-reportpayment-api\n" +
            "\n" +
            "ehealth-opbase-api\n" +
            "\n" +
            "ehealth-regulation-api\n" +
            "\n" +
            "ehealth-miscellany-api\n" +
            "\n" +
            "ali-applets-api\n" +
            "\n" +
            "ehealth-openapi-api\n" +
            "\n" +
            "ehealth-business-statistics-api\n" +
            "\n" +
            "ehealth-voucher-api\n" +
            "\n" +
            "ehealth-billcheck-api\n" +
            "\n" +
            "ehealth-core (from basic)\n" +
            "\n" +
            "ehealth-valueadded-api\n" +
            "\n" +
            "ehealth-networkclinic-api\n" +
            "\n" +
            "ehealth-bodycheck-api\n" +
            "\n" +
            "ehealth-micro-api\n" +
            "\n" +
            "ehealth-cdr-modules-api\n" +
            "\n" +
            "weixin-service-module-api\n" +
            "\n" +
            "ehealth-account-api\n" +
            "\n" +
            "ehealth-insurance-api\n" +
            "\n" +
            "ehealth-video-api\n" +
            "\n" +
            "ehealth-message-api\n" +
            "\n" +
            "ehealth-recipeaudit-api\n" +
            "\n" +
            "ehealth-pc-back-api\n" +
            "\n" +
            "ehealth-revisit-api\n" +
            "\n" +
            "ehealth-pc-base\n" +
            "\n" +
            "ehealth-op-report-entity\n" +
            "\n" +
            "ehealth-infra-api\n" +
            "\n" +
            "ehealth-familycare-api\n" +
            "\n" +
            "ehealth-pc-base-new\n" +
            "\n" +
            "ehealth-pc-new\n" +
            "\n" +
            "ehealth-pc\n" +
            "\n" +
            "ehealth-hisopen-api\n" +
            "\n" +
            "ehealth-sourceschedule-api";

    private final static String str3 = "ehealth-broadcast\n" +
            "\n" +
            "ngari-monitor\n" +
            "\n" +
            "ehealth-configure";

    private final static String str4 = "ehealth-app\n" +
            "\n" +
            "easy-pay\n" +
            "\n" +
            "ehealth-account\n" +
            "\n" +
            "ehealth-fileserver\n" +
            "\n" +
            "ehealth-basic\n" +
            "\n" +
            "ehealth-es-base\n" +
            "\n" +
            "ehealth-livecourse\n" +
            "\n" +
            "ehealth-emergency\n" +
            "\n" +
            "ehealth-scheduler\n" +
            "\n" +
            "ehealth-esign\n" +
            "\n" +
            "ehealth-recipe\n" +
            "\n" +
            "ehealth-nursing\n" +
            "\n" +
            "ehealth-follow-up\n" +
            "\n" +
            "ehealth-meetclinic\n" +
            "\n" +
            "ehealth-consult\n" +
            "\n" +
            "ehealth-transfer\n" +
            "\n" +
            "ehealth-appointsource\n" +
            "\n" +
            "ehealth-appoint\n" +
            "\n" +
            "ehealth-gift\n" +
            "\n" +
            "ehealth-evaluation\n" +
            "\n" +
            "ehealth-his-server\n" +
            "\n" +
            "ehealth-his-manage\n" +
            "\n" +
            "ehealth-hiscenter-test\n" +
            "\n" +
            "ehealth-reportpayment\n" +
            "\n" +
            "ali-applets\n" +
            "\n" +
            "ehealth-openapi\n" +
            "\n" +
            "ehealth-voucher\n" +
            "\n" +
            "ehealth-valueadded\n" +
            "\n" +
            "ehealth-networkclinic\n" +
            "\n" +
            "ehealth-bodycheck\n" +
            "\n" +
            "ehealth-cdr-modules\n" +
            "\n" +
            "ehealth-weixin-service\n" +
            "\n" +
            "ehealth-insurance\n" +
            "\n" +
            "ehealth-video\n" +
            "\n" +
            "ehealth-message\n" +
            "\n" +
            "ehealth-recipeaudit\n" +
            "\n" +
            "ehealth-pc-back\n" +
            "\n" +
            "ehealth-revisit\n" +
            "\n" +
            "ehealth-op-dataprocess\n" +
            "\n" +
            "ehealth-op-report\n" +
            "\n" +
            "ehealth-op-query\n" +
            "\n" +
            "ehealth-miscellany\n" +
            "\n" +
            "healthWeb-base\n" +
            "\n" +
            "healthSer-base\n" +
            "\n" +
            "ehealth-opexport\n" +
            "\n" +
            "ehealth-shadow\n" +
            "\n" +
            "ehealth-micro\n" +
            "\n" +
            "ehealth-billcheck\n" +
            "\n" +
            "ehealth-recipecheck\n" +
            "\n" +
            "ehealth-sms\n" +
            "\n" +
            "ehealth-business-statistics \n" +
            "\n" +
            "ehealth-opbase\n" +
            "\n" +
            "ehealth-regulation\n" +
            "\n" +
            "ehealth-infra-service\n" +
            "\n" +
            "ehealth-familycare\n" +
            "\n" +
            "ehealth-cloudimage\n" +
            "\n" +
            "ehealth-sourceschedule";

    private final static String str5 = "ehealth-base\n" +
            "\n" +
            "ehealth-weixin";

    private final static String str6 = "ehealth-micro-web\n" +
            "\n" +
            "fujian-provincial-web\n" +
            "\n" +
            "openapi-client\n" +
            "\n" +
            "yypt\n" +
            "\n" +
            "ehealth-regulation-manager\n" +
            "\n" +
            "ehealth-regulation\n" +
            "\n" +
            "ehealth-infra-service\n" +
            "\n" +
            "ehealth-familycare\n" +
            "\n" +
            "\n" +
            "ehealth-cleaning\n" +
            "\n" +
            "ehealth-hisopen";

    private final static String str7 = "ehealth-micro-web\n" +
            "\n" +
            "fujian-provincial-web\n" +
            "\n" +
            "openapi-client\n" +
            "\n" +
            "yypt\n" +
            "\n" +
            "ehealth-regulation-manager\n" +
            "\n" +
            "ehealth-web-followup\n" +
            "\n" +
            "ehealth-thirdplatform\n" +
            "\n" +
            "ngari-logstash\n" +
            "\n" +
            "ehealth-cleaning\n" +
            "\n" +
            "ehealth-hisopen\n" +
            "\n" +
            "ehealth-entity\n" +
            "\n" +
            "ehealth-utils";

    public static void main(String[] args) {
        Map<String, List<String>> map = Maps.newLinkedHashMap();
        List<String> strs = Lists.newArrayList();
        String[] mapKeyName = new String[]{
                "按顺序构建（API）", "独立构建的项目（API）",
                "核心（API之后）", "独立构建的项目（configure之后）（业务模块）",
                "核心（模块之后）", "独立的项目（在base之后）(node)(非业务模块)"
        };
        strs.add(str1);
        strs.add(str2);
        strs.add(str3);
        strs.add(str4);
        strs.add(str5);
        strs.add(str6);
        //放入数据
        for (int i = 0; i < strs.size(); i++) {
            String[] s = strs.get(i).split("\\n\\n");
            map.put(mapKeyName[i], Arrays.asList(s));
        }

        //造数据
        List<String> in = Arrays.asList(str7.split("\\n\\n"));
        Map<String, List<String>> outMap = Maps.newLinkedHashMap();

        //匹配数据
        map.forEach((k, v) -> {
            List<String> outList = Lists.newArrayList();
            v.forEach(str -> {
                if (in.contains(str)) {
                    outList.add(str);
                }
            });
            outMap.put(k, outList);
        });

        System.out.println(JSONUtils.valueToString(outMap));

    }
}
