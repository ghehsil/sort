package four.depth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/26.
 */
public class others {
    public Scanner fin;    // 标准输入

    public int n, m;    // 点的个数和路径的个数

    public int visited[]; // 标记每次深度搜索是否遍历过目标节点 防止无限递归

    public List<Integer>[] line;    // 第i个列表存i能到达的所有节点编号

    public int[][] graph;    // 二维表i j  标记i和j之间有通路

    public int root;     // 记录每次遍历的根节点

    public int count = 0;    // 最终结果哦

    public static void main(String[] args) {
        new others().run();
    }

    public void run() {
        init();
        // 输入每条路
        for (int i = 1; i <= m; i++) {
            int a = fin.nextInt();
            int b = fin.nextInt();
            line[a].add(b);    // a节点能到达b节点
        }
        // 对每一个节点 进行深度优先遍历，更新二维表graph  将i 和j 两个节点之间有路的 二维表相应位置设为1
        for (int i = 1; i <= n; i++) {
            // 对每次从根节点遍历子节点进行初始化visited数组
            visited = new int[n + 1];
            root = i;
            dfs(i);
        }
        // 统计能够知道所有其他节点的节点个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 0) {
                    break;
                }
                if (j == n) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public void dfs(int cur) {
        // 根节点和当前子节点能够通路
        graph[root][cur] = 1;
        graph[cur][root] = 1;
        visited[cur] = 1;
        // 对cur节点能到达的节点列表遍历
        for (int i = 0; i < line[cur].size(); i++) {
            if (visited[line[cur].get(i)] == 0) {        // 如果当前子节点还没有被访问过
                dfs(line[cur].get(i));
            }
        }
    }

    public void init() {
        fin = new Scanner(System.in);
        n = fin.nextInt();
        m = fin.nextInt();
        visited = new int[n + 1];
        line = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            line[i] = new ArrayList<Integer>();
        }
        graph = new int[n + 1][n + 1];
    }
}
