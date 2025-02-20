package mysort;

public class day4 {

    int[] nums;
    int n;

    // 相邻不能相同的最小之和
    public static void main(String[] args) {
        day4 d = new day4();
        int[] nums = new int[]{1, 3, 2, 2, 3, 1};
        d.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    int qselect(int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(l, j, k);
        else return qselect(j + 1, r, k - cnt);
    }

    void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public void wiggleSort(int[] _nums) {
        nums = _nums;
        n = nums.length;
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        while (loc <= r) {
            if (nums[loc] < x) swap(loc++, l++);
            else if (nums[loc] > x) swap(loc, r--);
            else loc++;
        }
        int[] clone = nums.clone();
        int idx = 1;
        loc = n - 1;
        while (idx < n) {
            nums[idx] = clone[loc--];
            idx += 2;
        }
        idx = 0;
        while (idx < n) {
            nums[idx] = clone[loc--];
            idx += 2;
        }
    }


}
