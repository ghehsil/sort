package mysort;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class day8 {

    // 本来想使用如下逻辑将「所有可能用到的状态」打表，实现 O(1) 查询某个状态有多少个字符，但是被卡了
    // static int N = 26, M = (1 << N);
    // static int[] cnt = new int[M];
    // static {
    //     for (int i = 0; i < M; i++) {
    //         for (int j = 0; j < 26; j++) {
    //             if (((i >> j) & 1) == 1) cnt[i]++;
    //         }
    //     }
    // }


    private int n;
    private int ans = Integer.MIN_VALUE;
    private int[] hash;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "bc", "hd");
        System.out.println(new day8().maxLength(list));
    }

    private int maxLength(List<String> list) {
        HashSet<Integer> set = new HashSet<>();

        // 放入二进制数组
        for (String s : list) {
            int val = 0;

            for (char c : s.toCharArray()) {
                int t = c - 'a';
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t);
            }

            if (val != -1) {
                set.add(val);
            }
        }

        n = set.size();

        if (n == 0) {
            return 0;
        }

        hash = new int[n];

        int idx = 0;
        // 所有叠加
        int total = 0;

        for (Integer i : set) {
            hash[idx++] = i;
            total |= i;
        }

        dfs(0, 0, total);

        return ans;
    }

    // u：深度
    // cur：往前加
    // total：往后减
    private void dfs(int u, int cur, int total) {
        // 剪枝：如果加上所有还不够，就退出
        if (get(cur | total) <= ans) {
            return;
        }

        ans = Math.max(ans, get(cur));

        if (u == n) {
            return;
        }

        // 在原有基础上，选择该数字（如果可以）
        if ((hash[u] & cur) == 0) {
            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
        }

        // 不选择该数字
        dfs(u + 1, cur, total);
    }

    private int get(int cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }

        int ans = 0;

        // 二进制有多少个1
        for (int i = cur; i > 0; i -= lowbit(i)) {
            ans++;
        }

        map.put(cur, ans);

        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }

}
