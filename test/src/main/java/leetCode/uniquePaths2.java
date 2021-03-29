package leetCode;

public class uniquePaths2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int size = m + n - 2;
        int[][][] steps = new int[size][m][n];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (n == 1 && m == 1 && obstacleGrid[0][0] == 0) {
            return 1;
        }

        //初始化
        if (n > 1 && obstacleGrid[0][1] == 0) {
            steps[0][0][1] = 1;
        }
        if (m > 1 && obstacleGrid[1][0] == 0) {
            steps[0][1][0] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (steps[i - 1][j][k] > 0) {
                        if (j + 1 < m && obstacleGrid[j + 1][k] == 0) {
                            steps[i][j + 1][k] += steps[i - 1][j][k];
                        }
                        if (k + 1 < n && obstacleGrid[j][k + 1] == 0) {
                            steps[i][j][k + 1] += steps[i - 1][j][k];
                        }
                    }
                }
            }
        }

        return steps[size - 1][m - 1][n - 1];
    }

}
