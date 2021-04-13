package sortLesson;

import java.util.Arrays;

/**
 * 动态规划找到两个数组相同的数字
 */
public class sameNumber {
    static int[] int1 = new int[]{3, 3, 3, 2, 2, 1};
    static int[] int2 = new int[]{1, 2, 3, 3, 3, 4};

    public static void main(String[] args) {
        Arrays.sort(int1);
        Arrays.sort(int2);
        sort1(int2.length, int1.length);
    }

    private static void sort1(int m, int n) {
        //从下一个开始比较，节省时间
        int index = 0;
        int[][] integer = new int[m][n];
        //初始化第一层
        for (int i = 0; i < n; i++) {
            if (int2[0] == int1[i]) {
                integer[0][i] = 1;
                index = ++i;
                break;
            }
        }
        //从下一个开始比较，相等就跳出循环
        for (int i = 1; i < m; i++) {
            for (int j = index; j < n; j++) {
                if (int1[j] == int2[i]) {
                    integer[i][j] = 1;
                    index = ++j;
                    break;
                }
            }
        }
        //找到相等的数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (integer[i][j] == 1) {
                    System.out.print(int1[j] + "  ");
                    break;
                }
            }
        }
    }
}
