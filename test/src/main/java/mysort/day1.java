package mysort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class day1 {
    /**
     * 207. 课程表
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     *
     *
     * 提示：
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */

    /**
     * 拓扑排序
     * 为了方便，我们记 numCourses 为 n，prerequisites 为 g。
     * <p>
     * 若课程 a 存在前置课程 b 的话，我们添加一条从 b 到 a 的有向边，同时统计所有点的入度。
     * <p>
     * 当处理完所有的 g[i]g[i]g[i] 后，将所有的入度为 000 的课程（含义为没有前置课程要求的科目）进行入队操作，跑一遍「拓扑排序」，若所有课程都能顺利出队，说明所有课程都能使完成。
     * <p>
     * 代码：
     * <p>
     * Java
     * class Solution {
     * int N = 100010, M = 5010;
     * int[] in = new int[N], he = new int[N], e = new int[M], ne = new int[M];
     * int idx;
     * void add(int a, int b) {
     * e[idx] = b;
     * ne[idx] = he[a];
     * he[a] = idx++;
     * in[b]++;
     * }
     * public boolean canFinish(int n, int[][] g) {
     * Arrays.fill(he, -1);
     * for (int[] info : g) add(info[1], info[0]);
     * int ans = 0;
     * Deque<Integer> d = new ArrayDeque<>();
     * for (int i = 0; i < n; i++) {
     * if (in[i] == 0) d.addLast(i);
     * }
     * while (!d.isEmpty()) {
     * int t = d.pollFirst();
     * ans++;
     * for (int i = he[t]; i != -1; i = ne[i]) {
     * int j = e[i];
     * if (--in[j] == 0) d.addLast(j);
     * }
     * }
     * return ans == n;
     * }
     * }
     * <p>
     * 时间复杂度：O(n+m)O(n + m)O(n+m)
     * 空间复杂度：O(n+m)O(n + m)O(n+m)
     */


    public static void main(String[] args) {
        day1 d = new day1();
        int n = 4;
        int[][] g = new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 1}, {3, 1}, {3, 2}};
//        int[][] g = new int[][]{{0, 1}, {2, 0}, {3, 0}, {2, 1}, {3, 1}, {3, 2}};
        System.out.println(d.canFinish(n, g));
    }

    // 0->1->3
    // 1->2
    // 0->2->3
    int N = 4, M = 6;
    int[] in = new int[N], he = new int[N], e = new int[M], ne = new int[M];
    int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        in[b]++;
    }

    public boolean canFinish(int n, int[][] g) {
        Arrays.fill(he, -1);
        for (int[] info : g) {
            add(info[1], info[0]);
        }
        int ans = 0;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                d.addLast(i);
            }
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            ans++;
            for (int i = he[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) {
                    d.addLast(j);
                }
            }
        }
        return ans == n;
    }

    /**
     * 解析：
     * 0 123
     * 1 23
     * 2 3
     *
     * in
     * [ 0, 1, 2, 3 ]                入度
     * he
     * [ 2, 4, 5, -1 ]               节点出度递增 从0开始
     * e
     * [ 1, 2, 3, 2, 3, 3 ]          每条边对应的出节点
     * ne
     * [ -1, 0, 1, -1, 3, -1 ]
     *
     * 遍历演示：
     * t = 0
     * i = 2
     * j = 3      in[3] = 2
     * i = 1
     * j = 2      in[2] = 1
     * i = 0
     * j = 1      in[1] = 0    add 1
     * i = -1
     *
     * t = 1
     * i = 4
     * j = 3      in[3] = 1
     * i = 3
     * j = 2      in[2] = 0     add 2
     * i = -1
     *
     * t = 2
     * i = 5
     * j = 3      in[3] = 0   add 3
     * i = -1
     *
     * t = 3
     * i = -1
     * finish
     *
     * t是开始节点
     * i表示第几条边
     * j表示i条边对应的出节点
     *
     * ne[idx] = he[a];
     * ne[0] = he[0]
     * ne[1] = he[0]
     * ne[2] = he[0]
     * ne[3] = he[1]
     * ne[4] = he[1]
     * ne[5] = he[2]
     * 0 0 0              1 1             2
     * -1 0 1 2          -1 3 4          -1 5
     */

}
