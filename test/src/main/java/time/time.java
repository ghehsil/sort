package time;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class time {
    public static void main(String[] args) {
        List<store> stores = new ArrayList<store>();
        List weeks = new ArrayList();
        weeks.add(1);
        weeks.add(3);
        weeks.add(5);
        stores.add(new store(new Time(7, 00, 00), new Time(8, 00, 00), weeks));
        weeks = new ArrayList();
        weeks.add(1);
        weeks.add(3);
        weeks.add(5);
        stores.add(new store(new Time(8, 00, 00), new Time(9, 00, 00), weeks));
        weeks = new ArrayList();
        weeks.add(2);
        weeks.add(4);
        weeks.add(6);
        stores.add(new store(new Time(8, 00, 00), new Time(9, 00, 00), weeks));

        Map<Integer, Map<String, List<Time>>> map = convert(stores);
        map = sort(map);
        List<Map<String, Object>> map1 = compare(map, new Date(), 0, 7);

        //输出
        for (int j = 0; j < map1.size(); j++) {
            Map map2 = map1.get(j);
            System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(map2.get("date")).toString() + "  ");
            switch(Integer.parseInt(map2.get("week").toString())){
                case 1:
                    System.out.print("周一");
                    break;
                case 2:
                    System.out.print("周二");
                    break;
                case 3:
                    System.out.print("周三");
                    break;
                case 4:
                    System.out.print("周四");
                    break;
                case 5:
                    System.out.print("周五");
                    break;
                case 6:
                    System.out.print("周六");
                    break;
                case 7:
                    System.out.print("周日");
                    break;
            }
            if (Integer.parseInt(map2.get("today").toString()) == 1) {
                System.out.print("(今日)" + "  ");
            }
            System.out.println();
            List<Time> start = (List<Time>) map2.get("startTime");
            List<Time> end = (List<Time>) map2.get("endTime");
            List<Integer> gray = (List<Integer>) map2.get("gray");
            for (int i = 0; i < start.size(); i++) {
                System.out.print("startTime:" + start.get(i).toString() + "  ");
                System.out.print("endTime:" + end.get(i).toString() + "  ");
                System.out.println("gray:" + gray.get(i).toString());
            }
            System.out.println();
        }
    }

    public static Map<Integer, Map<String, List<Time>>> convert(List<store> stores) {
        Map<Integer, Map<String, List<Time>>> map = new HashMap<Integer, Map<String, List<Time>>>();
        for (store s : stores) {
            for (int i = 0; i < s.getWeeks().size(); i++) {
                Integer week = Integer.parseInt(s.getWeeks().get(i).toString());
                if (null == map.get(week)) {
                    Map<String, List<Time>> time = new HashMap<String, List<Time>>();
                    List<Time> start = new ArrayList<Time>();
                    List<Time> end = new ArrayList<Time>();
                    start.add(s.getStartTime());
                    end.add(s.getEndTime());
                    time.put("startTime", start);
                    time.put("endTime", end);
                    map.put(week, time);
                } else {
                    Map<String, List<Time>> time = map.get(week);
                    List<Time> start = time.get("startTime");
                    List<Time> end = time.get("endTime");
                    start.add(s.getStartTime());
                    end.add(s.getEndTime());
                    time.put("startTime", start);
                    time.put("endTime", end);
                    map.put(week, time);
                }
            }
        }
        return map;
    }

    public static Map<Integer, Map<String, List<Time>>> sort(Map<Integer, Map<String, List<Time>>> map) {
        for (int j = 1; j <= 7; j++) {
            Map<String, List<Time>> m = map.get(j);
            if (null == m) {
                continue;
            }
            List<Time> start = m.get("startTime");
            List<Time> end = m.get("endTime");
            //冒泡排序
            for (int i = 0; i < start.size() - 1; i++) {
                for (int i1 = 0; i1 < start.size() - i - 1; i1++) {
                    if (start.get(i1).compareTo(start.get(i1 + 1)) > 0) {
                        Collections.swap(start, i1, i1 + 1);
                        Collections.swap(end, i1, i1 + 1);
                    }
                }
            }
            //合并
            for (int i = 0; i < start.size() - 1; i++) {
                if (start.get(i).compareTo(start.get(i + 1)) == 0) {
                    if (end.get(i).compareTo(end.get(i + 1)) >= 0) {
                        start.remove(i + 1);
                        end.remove(i + 1);
                        i--;
                    } else {
                        start.remove(i);
                        end.remove(i);
                        i--;
                    }
                } else {
                    if (end.get(i).compareTo(end.get(i + 1)) >= 0) {
                        start.remove(i + 1);
                        end.remove(i + 1);
                        i--;
                    } else {
                        if (end.get(i).compareTo(start.get(i + 1)) >= 0) {
                            Collections.swap(end, i, i + 1);
                            start.remove(i + 1);
                            end.remove(i + 1);
                            i--;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return map;
    }

    public static List<Map<String, Object>> compare(Map<Integer, Map<String, List<Time>>> map, Date now, int page, int limit) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Date time = getFormatDate(now, "HH:mm:ss");
        Date n = getFormatDate(new Date(), "yyyy-MM-dd");
        while (list.size() < limit) {
            Date day = getDateAftXDays(now, page);
            int week = getWeekOfDateInt(day);
            Date d = getFormatDate(day, "yyyy-MM-dd");
            Map<String, List<Time>> m = map.get(week);
            Map<String, Object> m1 = new HashMap<String, Object>();
            if (null == m) {
                page++;
                continue;
            }
            List<Time> start = m.get("startTime");
            List<Time> end = m.get("endTime");
            List<Integer> gray = new ArrayList<Integer>();
            for (int i = 0; i < start.size(); i++) {
                if (n.compareTo(d) == 0 && time.compareTo(end.get(i)) > 0) {
                    gray.add(1);
                } else {
                    gray.add(0);
                }
            }
            if (n.compareTo(d) == 0) {
                m1.put("today", 1);
            } else {
                m1.put("today", 0);
            }
            m1.put("date", d);
            m1.put("week", week);
            m1.put("startTime", start);
            m1.put("endTime", end);
            m1.put("gray", gray);
            list.add(m1);
            page++;
        }
        return list;
    }

    public static int getWeekOfDateInt(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7) - 1;
        if (w <= 0) {
            w = 7;
        }

        return w;
    }

    public static Date getDateAftXDays(Date d, int num) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(5, now.get(5) + num);
        return now.getTime();
    }

    public static Date getFormatDate(Date date, String format) {
        Date currentTime = null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            String e = formatter.format(date);
            currentTime = formatter.parse(e);
            return currentTime;
        } catch (ParseException var5) {
            return null;
        }
    }
}

class store {
    private Time startTime;
    private Time endTime;
    private List weeks;

    public store(Time startTime, Time endTime, List weeks) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public List getWeeks() {
        return weeks;
    }

    public void setWeeks(List weeks) {
        this.weeks = weeks;
    }
}