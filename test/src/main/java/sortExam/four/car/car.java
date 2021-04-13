package sortExam.four.car;

/**
 * Created by EDZ on 2019/6/11.
 */

import java.util.*;

/*
* 递归
* */
public class car {
    static List<road> roads;
    static int point;
    static int min = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        point = sc.nextInt();
        roads = new ArrayList<road>();
        int side = sc.nextInt();
        for (int i = 0; i < side; i++) {
            roads.add(new road(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        //用空节点出发
        sort(new road(0, 0, 0, 0), 0, 0, 0);
        //输出
        System.out.println(min);
    }

    public static void sort(road road, int type, int sum1, int sum) {
        for (road r : roads) {
            //第一个点，触发后面的点
            if (r.from == 1 && road.from == 0) {
                if (r.type == 1) {
                    sum1 = 0;
                    type = r.type;
                    sum1 += r.value;
                } else {
                    sum = 0;
                    sum += r.value;
                }
                //遍历后面的点
                sort(r, r.type, sum1, sum);
                //后面的遍历舍弃
                continue;
            }
            if (road.to == r.from) {
                //两个节点连上，加上权重
                if (type != r.type) {
                    if (r.type == 1) {
                        type = r.type;
                        sum1 = 0;
                        sum1 += r.value;
                    } else {
                        type = r.type;
                        sum += sum1 * sum1 + r.value;
                        sum1 = 0;
                    }
                } else {
                    if (r.type == 1) {
                        sum1 += r.value;
                    } else {
                        sum += r.value;
                    }
                }
                //到终点停止
                if (r.to == point) {
                    if (r.type == 1) {
                        sum += sum1 * sum1;
                    }
                    if (min > sum) {
                        min = sum;
                    }
                    return;
                }
                //到下一层
                sort(r, r.type, sum1, sum);
            }
        }
    }
}

class road {
    int type;
    int from;
    int to;
    int value;

    public road(int type, int from, int to, int value) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.value = value;
    }
}