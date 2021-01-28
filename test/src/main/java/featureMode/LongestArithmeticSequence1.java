package featureMode;

/**
 * Created by admin on 2020/4/17.
 */

import java.util.Arrays;

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
public class LongestArithmeticSequence1 {
    public static int calArithmeticSequence(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int[][] dp = new int[A.length][20001];
        int max = 0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                int distance = A[i] - A[j] + 10000;
                if(dp[j][distance] > 0){
                    dp[i][distance] = (dp[i][distance] > dp[j][distance]+1) ? dp[i][distance] : dp[j][distance]+1;
                }
                else{
                    dp[i][distance] = 2;
                }
                max = max > dp[i][distance] ? max : dp[i][distance];
            }
        }
        return max;
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