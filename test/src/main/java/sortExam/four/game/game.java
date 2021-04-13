package sortExam.four.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/10.
 */
public class game {
    static boolean vis[][][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        vis = new boolean[n + 1][m + 1][10000];
        int r, c, a, b;
        for (int i = 0; i < t; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                vis[r][c][j] = true;
            }
        }
        int ans = bfs(n, m);
        System.out.println(ans);
    }

    private static int bfs(int n, int m) {
        Node s, temp, temp2;
        s = new Node(1, 1, 0);
        Queue<Node> q = new LinkedList<Node>();
        q.add(s);
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.row == n && temp.column == m) return temp.spend;
            for (int i = 0; i < dir.length; i++) {
                temp2 = new Node();
//				temp2 = temp;	//这样是不对的
//				temp2.row += dir[i][0];
//				temp2.column +=  dir[i][1];
//				temp2.spend ++;
//				System.out.println(temp2.column);
                temp2.row = temp.row + dir[i][0];
                temp2.column = temp.column + dir[i][1];
                temp2.spend = temp.spend + 1;
                int r = temp2.row;
                int c = temp2.column;
                int t = temp2.spend;
                if (r < 1 || c < 1 || r > n || c > m) continue;
                if (vis[r][c][t]) continue;
                vis[r][c][t] = true;
                q.add(temp2);
            }
        }
        return 0;
    }
}

class Node {
    int row, column, spend;

    Node(int row, int column, int spend) {
        this.row = row;
        this.column = column;
        this.spend = spend;
    }

    public Node() {
    }
}
