package mysort;

public class day3 {

    // 相邻不能相同的最小之和
    public static void main(String[] args) {
        day3 d = new day3();
        // 每行只有三个数，只能再另外两个数之间去最小值，min函数解决
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(d.minCost(costs));
        // 每行多个数，另写函数取上一行中除同一列元素外的最小值
        int[][] costsCopy = {{17, 3, 2, 17}, {16, 4, 16, 5}, {14, 3, 5, 19}};
        System.out.println(d.minCostPro(costsCopy));
    }

    private int minCost(int[][] cs) {
        int n = cs.length;
        int a = cs[0][0], b = cs[0][1], c = cs[0][2];
        for (int i = 1; i < n; i++) {
            int d = Math.min(b, c) + cs[i][0];
            int e = Math.min(a, c) + cs[i][1];
            int f = Math.min(a, b) + cs[i][2];
            a = d;
            b = e;
            c = f;
        }
        return Math.min(a, Math.min(b, c));
    }

    private int minCostPro(int[][] cs) {
        int m = cs.length, n = cs[0].length;
        int[][] csCopy = new int[m][n];
        // 第一行赋值
        System.arraycopy(cs[0], 0, csCopy[0], 0, n);
        // 其它行计算最小值
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                csCopy[i][j] = cs[i][j] + calculateMin(csCopy[i - 1], j);
            }
        }
        // 取最后一行的最小值
        return calculateMin(csCopy[m - 1], -1);
    }

    // cs数组除第j个元素外的最小值
    private int calculateMin(int[] cs, int j) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cs.length; i++) {
            if (i == j) {
                continue;
            }
            min = Math.min(min, cs[i]);
        }
        return min;
    }

}
