package sortExam.four.chess;

import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/6.
 */
public class chess {
    public static int array[][] = new int[3][3];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    array[j][k] = input.nextInt();
                }
            }
            int score = dfs(1);
            System.out.println(score);
        }
    }

    public static int dfs(int index) {
        int space = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    space++;
                }
            }
        }
        if (index == 1 && judge(2)) {
            System.out.println("2赢:" + space);
            return -1 * (space + 1);
        }
        if (index == 2 && judge(1)) {
            System.out.println("1赢:" + space);
            return (space + 1);
        }
        if (space == 0) {
            System.out.println("平局:" + space);
            return 0;
        }
        int max = -10000;
        int min = 10000;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = index;
                    if (index == 1) {
                        max = Math.max(max, dfs(2));
                    }
                    if (index == 2) {
                        min = Math.min(min, dfs(1));
                    }
                    array[i][j] = 0;
                }
            }
        }

        if (index == 1) {
            return max;
        } else {
            return min;
        }
    }

    public static boolean judge(int index) {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == array[i][1] && array[i][1] == array[i][2] && array[i][2] == index) {
                return true;
            }
            if (array[0][i] == array[1][i] && array[1][i] == array[2][i] && array[2][i] == index) {
                return true;
            }
        }
        if (array[0][0] == array[1][1] && array[1][1] == array[2][2] && array[2][2] == index) {
            return true;
        }
        if (array[2][0] == array[1][1] && array[1][1] == array[0][2] && array[0][2] == index) {
            return true;
        }
        return false;
    }

}
