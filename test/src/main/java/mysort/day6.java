package mysort;

import java.util.Arrays;

public class day6 {

    private static int M = 1 << 20, INF = 50;
    private static int[] f = new int[M];
    private static String[] ss;
    private static String t;

    public static void main(String[] args) {
//        String[] stickers = {"with", "example", "science"};
//        String target = "thehat";
        String[] stickers = {"a", "b", "c", "d"};
        String target = "abcd";
        System.out.println(new day6().minStickers(stickers, target));
    }

    private int minStickers(String[] stickers, String target) {
        ss = stickers;
        t = target;
        Arrays.fill(f, -1);
        int ans = dfs(0);
        return ans == INF ? -1 : ans;
    }

    private int dfs(int state) {
        int n = t.length();
        if (state == ((1 << n) - 1)) {
            return 0;
        }
        if (f[state] != -1) {
            return f[state];
        }
        int ans = INF;
        for (String s : ss) {
            int nstate = state;
            out:
            for (char c : s.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    if (t.charAt(i) == c && ((nstate >> i) & 1) == 0) {
                        nstate |= (1 << i);
                        continue out;
                    }
                }
            }
            if (nstate != state) {
                ans = Math.min(ans, dfs(nstate) + 1);
            }
        }
        return f[state] = ans;
    }


}
