package mysort;

import java.util.Arrays;

public class day7 {

    public static void main(String[] args) {
//        String[] stickers = {"with", "example", "science"};
//        String target = "thehat";
        String[] stickers = {"a", "b", "c", "d", "e"};
        String target = "abcde";
        System.out.println(new day7().minStickers(stickers, target));
    }

    private int minStickers(String[] ss, String t) {
        int mask = 1 << t.length();
        int INF = 20;
        int[] f = new int[1 << 15];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int s = 0; s < mask; s++) {
            if (f[s] == INF) {
                continue;
            }
            for (String str : ss) {
                int ns = s;
                for (int i = 0; i < str.length(); i++) {
                    int c = str.charAt(i) - 'a';
                    for (int j = 0; j < t.length(); j++) {
                        if (t.charAt(j) - 'a' == c && ((ns >> j) & 1) == 0) {
                            ns |= (1 << j);
                            break;
                        }
                    }
                }
                f[ns] = Math.min(f[ns], f[s] + 1);
            }
        }
        return f[mask - 1] == INF ? -1 : f[mask - 1];
    }


}
