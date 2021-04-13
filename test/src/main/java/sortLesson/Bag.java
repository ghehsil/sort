package sortLesson;

/**
 * 动态规划（0-1背包）
 */
public class Bag {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 4, 6, 3};
        int[] value = new int[]{3, 4, 8, 9, 6};
        int n = 5;
        int totalWeight = 9;
        Package(weight, value, n, totalWeight);
        System.out.println(knapsack3(weight, value, n, totalWeight));
    }

    private static void Package(int[] weight, int[] value, int n, int totalWeight) {
        int[][] state = new int[n][totalWeight + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= totalWeight; ++j) {
                state[i][j] = -1;
            }
        }
        state[0][0] = 0;
        if (weight[0] <= totalWeight) {
            state[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= totalWeight; ++j) {
                if (state[i - 1][j] >= 0) {
                    state[i][j] = state[i - 1][j];
                }
            }
            for (int j = 0; j <= totalWeight; ++j) {
                if (state[i - 1][j] >= 0) {
                    if (j + weight[i] <= totalWeight) {
                        if (state[i][j + weight[i]] == -1) {
                            state[i][j + weight[i]] = state[i][j] + value[i];
                        } else if (state[i][j] + value[i] > state[i][j + weight[i]]) {
                            state[i][j + weight[i]] = state[i][j] + value[i];
                        }
                    }
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= totalWeight; ++i) {
            if (maxValue < state[n - 1][i]) {
                maxValue = state[n - 1][i];
            }
        }
        System.out.println(maxValue);
    }

    private static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        } // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }
}
