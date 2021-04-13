package sortLesson;

/**
 * 回溯
 */
public class BackUp {

    static int n = 3;
    static int minValue = Integer.MAX_VALUE;
    static int[][] values = new int[][]{{1, 3, 5, 9}, {2, 10, 3, 4}, {5, 10, 6, 7}, {6, 8, 4, 3}};

    static int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量

    public static void main(String[] args) {
        back(0, 0, 0);
        System.out.println(minValue);

        minDistBT(0, 0, 0, values, n);
        System.out.println(minDist);
    }

    private static void back(int i, int j, int value) {
        if (i == n && j == n) {
            if (value < minValue) {
                minValue = value;
            }
            return;
        }
        if (i > n || j > n) {
            return;
        }
        back(i + 1, j, value + values[i][j]);
        back(i, j + 1, value + values[i][j]);
    }

    public static void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了n-1, n-1这个位置了，这里看着有点奇怪哈，你自己举个例子看下
        if (i == n && j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }
        if (i < n) { // 往下走，更新i=i+1, j=j
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        if (j < n) { // 往右走，更新i=i, j=j+1
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }
}
