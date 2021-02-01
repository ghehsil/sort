package test;

/**
 * 动态规划求不同字符串的不同
 * 当前的已经计算完，计算后面的
 * 搜索引擎纠错功能
 *
 * array1[i] != array2[j]
 * min[i][j] = min(min[i][j-1] + 1, min[i-1][j] + 1, min[i-1][j-1] + 1)
 *
 * array1[i] == array2[j]
 * min[i][j] = min(min[i][j-1] + 1, min[i-1][j] + 1, min[i-1][j-1])
 */
public class StringDifferent {

    static char[] array1 = "miqtcms".toCharArray();
    static char[] array2 = "ltadcnu".toCharArray();
    static int n = array1.length;
    static int m = array2.length;

    public static void main(String[] args) {
        myMethod();
        lwstDP(array1, n, array2, m);
    }

    private static void myMethod() {
        int[][] values = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            //初始第一行
            if (i == 0) {
                if (array1[0] != array2[i]) {
                    values[0][i] = 1;
                }
                continue;
            } else {
                values[0][i] = values[0][i - 1] + 1;
            }
            //初始第一列
            values[i][0] = values[i - 1][0] + 1;
        }
        //求每一层的最小变化
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (array1[i] == array2[j]) {
                    values[i][j] = Math.min(Math.min(values[i][j - 1] + 1, values[i - 1][j] + 1), values[i - 1][j - 1]);
                } else {
                    values[i][j] = Math.min(Math.min(values[i][j - 1] + 1, values[i - 1][j] + 1), values[i - 1][j - 1] + 1);
                }
            }
        }
        print(values);
    }

    private static void lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j])
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        print(minDist);
    }

    //求最小值
    private static int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

    //打印
    private static void print(int[][] values) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(values[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
