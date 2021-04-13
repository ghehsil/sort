package sortExam.four.subway;

import java.util.*;

//最小生成树
/*
6 14
1 2 4
2 3 4
3 6 7
1 4 2
4 5 5
5 6 6
1 6 5
1 2 4
2 3 4
3 6 7
1 4 2
4 5 5
5 6 6
1 6 5
*/
public class subwayShorter {
    static int point;
    static int maxTmp = 0;
    static int max = 10000;
    static Map<Integer, List<way>> map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        point = input.nextInt();
        int edge = input.nextInt();
        map = new HashMap<Integer, List<way>>();
        List<way> list;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < edge; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int days = input.nextInt();
            if (map.get(start) == null) {
                list = new ArrayList<way>();
                list.add(new way(start, end, days));
                map.put(start, list);
            } else {
                list = map.get(start);
                list.add(new way(start, end, days));
                map.put(start, list);
            }
        }
        sort(1);
        System.out.println(max);
        long endTime = System.currentTimeMillis();
        System.out.println(-startTime+endTime);
    }

    static void sort(int start) {
        if (start == point) {
            if (max > maxTmp) {
                max = maxTmp;
            }
            return;
        }
        for (int i = 0; i < map.get(start).size(); i++) {
            if (start == 1) {
                maxTmp = 0;
            }
            if (map.get(start).get(i).getDays() > maxTmp) {
                maxTmp = map.get(start).get(i).getDays();
            }
            sort(map.get(start).get(i).getEnd());
        }
    }
}
