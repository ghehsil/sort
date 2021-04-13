package sortExam.four.interestingNumber;

import java.util.Scanner;

public class interestingNumber {
    static int length;
    static int num = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        int[] list = new int[length];
        list[0] = 2;
        int[] boo = new int[4];
        boo[2] = 1;
        int[] zero = new int[length];
        int[] one = new int[length];
        int[] two = new int[length];
        int[] three = new int[length];
        two[0] = 1;
        sort(1, list, boo, zero, one, two, three, 0, 0, 1, 0);
        System.out.println(num % 1000000007);
    }

    static void sort(int times, int[] list, int[] boo, int[] zero, int[] one, int[] two, int[] three, int zeroNum, int oneNum, int twoNum, int threeNum) {
        if (times == length) {
            /*if (judge(boo, zero, sortExam.one, sortExam.one.two, sortExam.one.three)) {
                for (int i = 0; i < length; i++) {
                    System.out.print(list[i]);
                }
                System.out.println();
                num++;
            }*/
            return;
        }
        times++;
        for (int i = 0; i < 4; i++) {
            int[] zero1 = zero.clone();
            int[] one1 = one.clone();
            int[] two1 = two.clone();
            int[] three1 = three.clone();
            int zeroNum1 = zeroNum;
            int oneNum1 = oneNum;
            int twoNum1 = twoNum;
            int threeNum1 = threeNum;
            if (i == 0) {
                zero1[zeroNum] = times;
                zeroNum1++;
            } else if (i == 1) {
                one1[oneNum] = times;
                oneNum1++;
            } else if (i == 2) {
                two1[twoNum] = times;
                twoNum1++;
            } else if (i == 3) {
                three1[threeNum] = times;
                threeNum1++;
            }
            list[times - 1] = i;
            int[] boo1 = boo.clone();
            boo1[i] = 1;
            sort(times, list, boo1, zero1, one1, two1, three1, zeroNum1, oneNum1, twoNum1, threeNum1);
        }
    }

    static boolean judge(int[] boo, int[] zero, int[] one, int[] two, int[] three) {
        //是否都使用到了
        for (int i = 0; i < 4; i++) {
            if (boo[i] == 0) {
                return false;
            }
        }
        int i = length - 1;
        int j = length - 1;
        while (zero[i] == 0) {
            i--;
        }
        if (zero[i] > one[0]) {
            return false;
        }
        while (two[j] == 0) {
            j--;
        }
        if (two[j] > three[0]) {
            return false;
        }
        return true;
    }
}