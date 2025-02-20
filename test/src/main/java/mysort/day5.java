package mysort;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class day5 {

    public static void main(String[] args) {
        day5 d = new day5();
        System.out.println(d.nthUglyNumber(120));
        System.out.println(d.nthUglyNumberNew(120));
    }

    public int nthUglyNumber(int n) {
        int[] nums = new int[]{2, 3, 5};
        // 小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int temp = queue.poll();
            if (i == n) {
                return temp;
            }
            for (int num : nums) {
                int x = num * temp;
                if (set.contains(x)) {
                    continue;
                }
                queue.add(x);
                set.add(x);
            }
        }
        return -1;
    }

    // 三指针
    public int nthUglyNumberNew(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1, i2 = 0, i3 = 0, i5 = 0; i < n; i++) {
            int a = 2 * nums[i2], b = 3 * nums[i3], c = 5 * nums[i5], min = Math.min(a, Math.min(b, c));
            if (a == min) {
                i2++;
            }
            if (b == min) {
                i3++;
            }
            if (c == min) {
                i5++;
            }
            nums[i] = min;
        }
        return nums[n - 1];
    }

}
