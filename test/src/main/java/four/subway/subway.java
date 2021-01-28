package four.subway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
public class subway {
    static int point;
    static List<way> ways;
    static int maxTmp = 0;
    static int max = 10000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        point = input.nextInt();
        int edge = input.nextInt();
        ways = new ArrayList<way>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < edge; i++) {
            ways.add(new way(input.nextInt(), input.nextInt(), input.nextInt()));
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
        for (int i = 0; i < ways.size(); i++) {
            if (start == 1) {
                maxTmp = 0;
            }
            if (start == ways.get(i).getStart()) {
                if (ways.get(i).getDays() > maxTmp) {
                    maxTmp = ways.get(i).getDays();
                }
                sort(ways.get(i).getEnd());
            }
        }
    }
}

class way {
    private Integer start;
    private Integer end;
    private Integer days;

    public way(Integer start, Integer end, Integer days) {
        this.start = start;
        this.end = end;
        this.days = days;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
