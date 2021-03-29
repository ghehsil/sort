package leetCode;

public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
    }

    private static int uniquePaths(int m, int n) {
        int size = m + n - 2;
        int[][][] steps = new int[size][m][n];

        if (n == 1 && m == 1) {
            return 1;
        }

        //初始化
        if (n > 1) {
            steps[0][0][1] = 1;
        }
        if (m > 1) {
            steps[0][1][0] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (steps[i - 1][j][k] > 0) {
                        if (j + 1 < m) {
                            steps[i][j + 1][k] += steps[i - 1][j][k];
                        }
                        if (k + 1 < n) {
                            steps[i][j][k + 1] += steps[i - 1][j][k];
                        }
                    }
                }
            }
        }

        return steps[size - 1][m - 1][n - 1];
    }

}
