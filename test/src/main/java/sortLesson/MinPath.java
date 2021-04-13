package sortLesson;

import java.util.LinkedList;

/**
 * 最短路径
 */
public class MinPath {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 5);
        g.addEdge(1, 4, 4);
        g.addEdge(4, 2, 5);
        g.addEdge(2, 5, 6);
        g.addEdge(5, 3, 7);
        g.addEdge(4, 3, 2);
        g.dijkstra(0, 3);
        System.out.println();
        System.out.print(g.length);
    }

    public static class Graph { // 有向有权图的邻接表表示
        private final LinkedList<Edge>[] adj; // 邻接表
        private final int v; // 顶点个数
        private int length = 0; // 最小总长度

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) { // 添加一条边
            this.adj[s].add(new Edge(s, t, w));
        }

        private static class Edge {
            public int sid; // 边的起始顶点编号
            public int tid; // 边的终止顶点编号
            public int w; // 权重

            public Edge(int sid, int tid, int w) {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }

        // 下面这个类是为了dijkstra实现用的
        private static class Vertex {
            public int id; // 顶点编号ID
            public int dist; // 从起始顶点到这个顶点的距离

            public Vertex(int id, int dist) {
                this.id = id;
                this.dist = dist;
            }
        }

        // 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
        private static class PriorityQueue { // 根据vertex.dist构建小顶堆
            private final LinkedList<Vertex> nodes;

            public PriorityQueue() {
                this.nodes = new LinkedList<>();
            }

            public Vertex poll() {
                return nodes.poll();
            }

            public void add(Vertex vertex) {
                nodes.add(vertex);
                nodes.sort((o1, o2) -> Integer.compare(o2.dist - o1.dist, 0));
            }

            // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
            public void update(Vertex vertex) {
                nodes.forEach(n -> {
                    if (n.id == vertex.id) {
                        n.dist = vertex.dist;
                    }
                });
                nodes.sort((o1, o2) -> Integer.compare(o2.dist - o1.dist, 0));
            }

            public boolean isEmpty() {
                return nodes.getFirst() == null;
            }
        }

        public void dijkstra(int s, int t) { // 从顶点s到顶点t的最短路径
            int[] predecessor = new int[this.v]; // 用来还原最短路径
            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < this.v; ++i) {
                vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
            }
            PriorityQueue queue = new PriorityQueue();// 小顶堆
            boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
            vertexes[s].dist = 0;
            queue.add(vertexes[s]);
            inqueue[s] = true;
            while (!queue.isEmpty()) {
                Vertex minVertex = queue.poll(); // 取堆顶元素并删除
                if (minVertex.id == t) { // 最短路径产生了
                    break;
                }
                for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                    Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
                    Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                    if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist
                        nextVertex.dist = minVertex.dist + e.w;
                        predecessor[nextVertex.id] = minVertex.id;
                        if (inqueue[nextVertex.id]) {
                            queue.update(nextVertex); // 更新队列中的dist值
                        } else {
                            queue.add(nextVertex);
                            inqueue[nextVertex.id] = true;
                        }
                    }
                }
            }
            // 输出最短路径
            System.out.print(s);
            print(s, t, predecessor);
        }

        private void print(int s, int t, int[] predecessor) {
            if (s == t) {
                return;
            }
            this.adj[s].forEach(e -> {
                if (e.sid == s && e.tid == t) {
                    length += e.w;
                }
            });
            print(s, predecessor[t], predecessor);
            System.out.print("->" + t);
        }
    }
}


