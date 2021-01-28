package two.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/10.
 */

public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int num = sc.nextInt();
        int index = 0;
        List<Integer> number = new LinkedList<Integer>();
        for (int i = 0; i < nums; i++) {
            number.add(i + 1);
        }
        while (number.size() > 1) {
            for (int i = 0; i < number.size(); i++) {
                index++;
                if (index % num == 0 || index % 10 == num) {
                    number.remove(i);
                    i--;
                }
            }
        }
        System.out.println(number.get(0));
    }
}