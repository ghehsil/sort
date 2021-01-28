package time;

import java.sql.Time;
import java.util.*;

/**
 * Created by EDZ on 2019/7/29.
 */
public class returnTime {
    public static void main(String[] args) {
        List<store> stores = new ArrayList<store>();
        List weeks = new ArrayList();
        weeks.add(1);
        weeks.add(3);
        weeks.add(5);
        weeks.add(6);
        stores.add(new store(new Time(7, 00, 00), new Time(8, 00, 00), weeks));
        weeks = new ArrayList();
        weeks.add(1);
        weeks.add(3);
        weeks.add(5);
        stores.add(new store(new Time(7, 00, 00), new Time(9, 00, 00), weeks));
        weeks = new ArrayList();
        weeks.add(1);
        weeks.add(2);
        weeks.add(6);
        stores.add(new store(new Time(7, 00, 00), new Time(9, 00, 00), weeks));

        Collections.sort(stores, new Comparator<store>() {
            public int compare(store o1, store o2) {
                Integer num1 = o1.getStartTime().compareTo(o2.getStartTime());
                Integer num2 = o1.getEndTime().compareTo(o2.getEndTime());
                Integer num3 = o1.getWeeks().size() == o2.getWeeks().size() ? 0 : o1.getWeeks().size() > o2.getWeeks().size() ? 1 : -1;
                return num1 != 0 ? num1 : num2 != 0 ? num2 : num3 != 0 ? num3 : comp(o1, o2);
            }
        });

        //输出
        for (store s:stores) {
            System.out.println(s.getWeeks().toString());
            System.out.println(s.getStartTime().toString());
            System.out.println(s.getEndTime().toString());
            System.out.println();
        }
    }

    public static Integer comp(store o1, store o2) {
        List list1 = o1.getWeeks();
        List list2 = o2.getWeeks();
        for (int i = 0; i < list1.size(); i++) {
            Integer i1 = Integer.parseInt(list1.get(i).toString());
            Integer i2 = Integer.parseInt(list2.get(i).toString());
            if (i1 == i2) {
                continue;
            }
            return i1 > i2 ? 1 : -1;
        }
        return 0;
    }
}
