package one.jumpAndJump;

import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/5. 11136ms
 */
public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        int count = 0;
        int n = sc.nextInt();

        while (n != 0) {
            if (n == 1) {
                count = 0;
                score += 1;
            }
            if (n == 2) {
                count++;
                score += 2 * count;
            }
            n = sc.nextInt();

        }
        System.out.print(score + " ");
        sc.close();
    }
}
