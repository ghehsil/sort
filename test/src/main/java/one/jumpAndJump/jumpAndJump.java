package one.jumpAndJump;

import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/5. 13980ms
 */
public class jumpAndJump {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int score = 0;
        int pre = 0;
        int now;
        while ((now = input.nextInt()) != 0) {
            if (now == 1) {
                score = 1;
                total += score;
            } else if (now == 2) {
                if (pre == 0 || score == 1) {
                    score = 2;
                    total += score;
                } else {
                    score += 2;
                    total += score;
                }
            }
            pre = now;
        }
        System.out.println("score = " + total);
        input.close();
    }
}
