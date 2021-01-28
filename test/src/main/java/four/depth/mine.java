package four.depth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/26.
 */
/*
4 4
1 2
1 3
2 4
3 4
* */
/*
4 5
1 2
2 3
3 1
1 4
4 3
* */
//深度优先
public class mine {
    //输入函数
    static Scanner input;
    //点个数
    static Integer point;
    //边条数
    static Integer edge;
    //存数据结构
    static List<Integer>[] list;
    //节点是否已被访问
    static boolean[] boo;
    //判断是否互通
    static int[][] graph;
    //方便存入graph
    static int j = 1;
    //结果
    static int result = 0;

    public static void main(String[] args) {
        //赋值
        init();
        //深度优先遍历
        for (j = 1; j <= point; j++) {
            sort(j);
            boo = new boolean[point + 1];
        }
        //用图判断
        for (int i = 1; i <= point; i++) {
            for (int j = 1; j <= point; j++) {
                if (graph[i][j] == 0) {
                    break;
                }
                if (j == point) {
                    result++;
                }
            }
        }
        //输出
        System.out.println(result);
    }

    static void sort(Integer p) {
        if (list[p] == null || list[p].size() < 1 || boo[p]) {
            graph[j][p] = 1;
            graph[p][j] = 1;
            return;
        }
        for (int i = 0; i < list[p].size(); i++) {
            graph[j][p] = 1;
            graph[p][j] = 1;
            boo[p] = true;
            sort(list[p].get(i));
        }
    }

    static void init() {
        input = new Scanner(System.in);
        point = input.nextInt();
        edge = input.nextInt();
        list = new List[point + 1];
        boo = new boolean[point + 1];
        graph = new int[point + 1][point + 1];
        //存值
        for (int i = 0; i < edge; i++) {
            Integer start = input.nextInt();
            Integer end = input.nextInt();
            if (list[start] == null) {
                list[start] = new ArrayList<Integer>();
            }
            list[start].add(end);
        }
    }
}
