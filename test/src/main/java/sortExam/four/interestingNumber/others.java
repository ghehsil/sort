package sortExam.four.interestingNumber;

import java.util.Scanner;

public class others {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long a[][] = new long[N][6];
        int j;
        long mod = 1000000007;
        a[0][0] = 1;
        for (int i = 1; i < N; i++) {
            j = i - 1;
            a[i][0] = (a[j][0] * 1) % mod;
            a[i][1] = (a[j][0] * 1 + a[j][1] * 2) % mod;
            a[i][2] = (a[j][0] * 1 + a[j][2] * 1) % mod;
            a[i][3] = (a[j][1] * 1 + a[j][3] * 2) % mod;
            a[i][4] = (a[j][1] * 1 + a[j][2] * 1 + a[j][4] * 2) % mod;
            a[i][5] = (a[j][3] * 1 + a[j][4] * 1 + a[j][5] * 2) % mod;
        }
        System.out.println(a[N - 1][5]);
    }
}
