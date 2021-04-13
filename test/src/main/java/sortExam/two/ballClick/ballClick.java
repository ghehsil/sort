package sortExam.two.ballClick;

import java.util.*;

/**
 * Created by EDZ on 2019/6/5.
 */
//重点在于把球封装成一个对象 Id和方向是精髓
class ball {
    int id;
    int place;
    int direct;

    public ball(int id, int place, int direct) {
        this.id = id;
        this.place = place;
        this.direct = direct;
    }
}

//按照位置大小排序，便于排序
class ballComparator implements Comparator<ball> {
    public int compare(ball o1, ball o2) {
        return o1.place > o2.place ? -1 : 1;
    }
}

//按照原来的顺序变回去
class ballComparator1 implements Comparator<ball> {
    public int compare(ball o1, ball o2) {
        return o1.id > o2.id ? 1 : -1;
    }
}

public class ballClick {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ballNum = input.nextInt();
        int length = input.nextInt();
        int time = input.nextInt();
        List<ball> balls = new ArrayList<ball>();
        for (int i = 0; i < ballNum; i++) {
            balls.add(new ball(i, input.nextInt(), 1));
        }
        Collections.sort(balls, new ballComparator());
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < balls.size(); j++) {
                if (j == 0) {
                    if (balls.get(j).place == length || balls.get(j).place == balls.get(j + 1).place) {
                        balls.get(j).direct *= -1;
                    }
                    continue;
                }
                if (j == balls.size() - 1) {
                    if (balls.get(j).place == 0 || balls.get(j).place == balls.get(j - 1).place) {
                        balls.get(j).direct *= -1;
                    }
                    continue;
                }
                if (balls.get(j).place == balls.get(j + 1).place || balls.get(j).place == balls.get(j - 1).place) {
                    balls.get(j).direct *= -1;
                }
            }
            for (int j = 0; j < balls.size(); j++) {
                balls.get(j).place += balls.get(j).direct;
            }
        }
        Collections.sort(balls, new ballComparator1());
        for (int i = 0; i < balls.size(); i++) {
            System.out.print(balls.get(i).place + " ");
        }
    }
}









