package test;

import java.util.LinkedList;
import java.util.Queue;


//图的广度优先和深度优先
public class Graph {

    public static void main(String[] args) {
        //构建图
        graph g = new graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        g.bfs(0, 7);
        System.out.println();
        g.dfs(0, 7);
    }

    public static class graph {
        // 顶点的个数
        private int v;
        private LinkedList adj[];

        // 邻接表
        public graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }

        //构建邻接表
        public void addEdge(int s, int t) {
            // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        //广度优先遍历
        //核心思想：遍历节点的子节点，再遍历子节点的子节点，以此类推。用for循环来实现一层层遍历，不会像深度优先一样，取最深的。
        public void bfs(int s, int t) {
            if (s == t) {
                return;
            }
            //该节点有没有被访问 防止重复遍历
            boolean[] visited = new boolean[v];
            visited[s] = true;
            //队列放要访问的节点
            Queue queue = new LinkedList<>();
            queue.add(s);
            //访问该节点的节点
            int[] prev = new int[v];
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            while (queue.size() != 0) {
                int w = (int) queue.poll();
                //遍历该节点连结的节点
                for (int i = 0; i < adj[w].size(); ++i) {
                    int q = (int) adj[w].get(i);
                    //遍历过的不会再放进先序数组里，由于是一层层遍历，也就不会深入
                    if (!visited[q]) {
                        prev[q] = w;
                        if (q == t) {
                            print(prev, s, t);
                            return;
                        }
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        //节省时间
        boolean found = false;

        //深度优先
        //核心思想：不重复地遍历每一个节点，把这些节点连起来，找一个最长的。用递归来实现，找到最深的节点才停止。
        public void dfs(int s, int t) {
            found = false;
            //该节点有没有被访问
            boolean[] visited = new boolean[v];
            //前一个节点 用于打印
            int[] prev = new int[v];
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            recurDfs(s, t, visited, prev);
            print(prev, s, t);
        }

        private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
            //找到后，for循环中的别的分支不用找了
            if (found) {
                return;
            }
            visited[w] = true;
            if (w == t) {
                found = true;
                return;
            }
            //遍历该节点连结的节点
            for (int i = 0; i < adj[w].size(); ++i) {
                if (found) {
                    return;
                }
                int q = (int) adj[w].get(i);
                //当前节点遍历过 不再刷新前一个节点
                if (!visited[q]) {
                    prev[q] = w;
                    recurDfs(q, t, visited, prev);
                }
            }
        }

        //打印 递归到最小的集合 再打印
        private void print(int[] prev, int s, int t) {
            // 递归打印s->t的路径
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }
    }

}
