package test;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ToPoSort {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.topoSortByKahn();
        System.out.println();
        g.topoSortByDFS();
    }

    static class Graph {
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表
        private LinkedList<Integer> inverseAdj[]; // 逆邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            inverseAdj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
                inverseAdj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s先于t，边s->t
            adj[s].add(t);
            inverseAdj[t].add(s);
        }

        //Kahn算法
        public void topoSortByKahn() {
            int[] inDegree = new int[v]; // 统计每个顶点的入度
            for (int i = 0; i < v; ++i) {
                for (int j = 0; j < adj[i].size(); ++j) {
                    int w = adj[i].get(j); // i->w
                    inDegree[w]++;
                }
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; ++i) {
                if (inDegree[i] == 0) queue.add(i);
            }
            while (!queue.isEmpty()) {
                int i = queue.remove();
                System.out.print("->" + i);
                for (int j = 0; j < adj[i].size(); ++j) {
                    int k = adj[i].get(j);
                    inDegree[k]--;
                    if (inDegree[k] == 0) queue.add(k);
                }
            }
        }

        //深度优先
        //构建逆邻接表 反向递归（深度优先）
        public void topoSortByDFS() {
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; ++i) { // 深度优先遍历图
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, visited);
                }
            }
        }

        private void dfs(int vertex, boolean[] visited) {
            for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
                int w = inverseAdj[vertex].get(i);
                if (visited[w]) {
                    continue;
                }
                visited[w] = true;
                dfs(w, visited);
            } // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
            System.out.print("->" + vertex);
        }

    }
}
