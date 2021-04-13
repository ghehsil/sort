package sortExam.four.minCreateTree;

import java.util.*;

/**
 * Created by EDZ on 2019/6/4.
 */

/*
 4
 5
 1
 1 2 2
 1 3 4
 2 3 3
 1 4 5
 3 4 6
*/
// 找最小生成树的最大边
public class minCreateTree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();  //接收m条边和其权值的列表
        // 节点数
        int n = input.nextInt();
        // 边数
        int m = input.nextInt();
        // 无用
        int root = input.nextInt();
        // 保存找到的最小路径,下标为起始点，数值为终点
        // 用于判断是不是组成一个环
        int[] parent = new int[m];
        int ans = 0;

        // 输入的前两个参数是从小到大的，就可以用有向处理
        for (int i = 0; i < m; i++) {
            int[] edge = new int[3];
            edge[0] = input.nextInt();
            edge[1] = input.nextInt();
            edge[2] = input.nextInt();
            edges.add(edge);
        }

        // long startTime = System.currentTimeMillis();
        // 按权值排序 贪心算法
        edges.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[2] > b[2]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int[] edge : edges) {
            int start = find(parent, edge[0]);
            int end = find(parent, edge[1]);
            // 判断是否形成回路
            if (start != end) {
                parent[start] = end;
                if (edge[2] > ans) {
                    ans = edge[2];
                }
            }
            // 形成一个环就跳过这条边
        }

        System.out.println(ans);
        // long endTime = System.currentTimeMillis();
        // long Time = endTime - startTime;
        // System.out.println(Time + "ms");
        input.close();
    }

    public static int find(int[] parent, int index) {
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }

}

