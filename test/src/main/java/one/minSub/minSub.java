package one.minSub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by EDZ on 2019/6/10.
 */
public class minSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int num = 10000;
        List list = new ArrayList();
        for (int i = 0; i < length; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for (int i = 0; i < length - 1; i++) {
            int n = Math.abs(Integer.parseInt(list.get(i).toString()) - Integer.parseInt(list.get(i + 1).toString()));
            if (n < num) {
                num = n;
            }
        }
        System.out.println(num);
    }
}
