package featureMode;

/**
 * Created by admin on 2020/4/17.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 求最长等差数列的长度
 * 运用动态规划
 * 1.首先对数组array进行排序
 * 2.数组长度为length = array.length - 1，然后差最大为最大值减去最小值为diff
 * 3.进行dp[length][diff + 1]
 * 则dp[i][diff] 表示 第i个数 等差为 diff的个数
 * 显然有 dp[i][diff] = dp[j][diff] + 1,其中j < i
 *
 * @author special
 * @date 2017年9月20日 下午9:32:35
 */
public class LongestArithmeticSequence {
    public static int calArithmeticSequence(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        /**
         * 最大等差
         */
        int diffMax = nums[length - 1] - nums[0];
        /**
         * dp数组保存每次遍历的结果
         */
        int[][] dp = new int[length][diffMax + 1];
        /**
         * 因为任何单个数，等差无论多少，长度初始化都为1
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= diffMax; j++) {
                dp[i][j] = 1;
            }
        }
        int longestLength = 1;
        for (int i = 1; i < length; i++) {
            /**
             * 依次考察i之前的数，对于每个j与i的差值temp
             * 都要对dp[i][temp] = dp[j][temp] + 1
             * 然后在看看当前的长度是否大于max,若大于max,则更新max值。
             */
            for (int j = i - 1; j >= 0; j--) {
                int temp = nums[i] - nums[j];
                dp[i][temp] = dp[j][temp] + 1;
                longestLength = Math.max(longestLength, dp[i][temp]);
                System.out.println((i + 1) + " " + (temp + 1) + "       " + (j + 1) + " " + (temp + 1));
            }
        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return longestLength;
    }

    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        *//**
         * 随机生成你想要多少个数
         *//*
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(10);
        }*/
        int[] nums = {3,6,9,6,9,15,12};
        int length = calArithmeticSequence(nums);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
        System.out.println(length);
    }

}