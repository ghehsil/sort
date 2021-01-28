package time;

import net.sf.json.util.JSONUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class dateConvert {

    public static void main(String[] args) throws Exception {
        Date date = DateUtils.parseDate("2020-12-24 00:00:00", "yyyy-MM-dd HH:mm:ss");
        long l = DateUtils.getFragmentInDays(date, Calendar.DATE);
        System.out.println(l);


        /*String[] array = {"1","2","3","4","5"};
        List<String> list = Arrays.asList(array);
        list = new ArrayList(list);
        list.add("6");
        System.out.println(JSONUtils.valueToString(list));*/

    }
}
