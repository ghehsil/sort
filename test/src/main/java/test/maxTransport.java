package test;

/**
 * 仓库配送问题
 */
public class maxTransport {

    public static void main(String[] args) {
        //int[] s = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] s = new int[]{10, 9, 8, 7, 6, 1, 2, 3, 4, 5};
        int lenth = 5;
        int tmp = s[s.length - 1];
        int index1 = s.length - 1;
        int index2 = s.length - 1;
        int value;
        while (true) {
            value = sort(s, lenth, tmp);
            if (value == 0) {
                System.out.println("result:" + tmp);
                return;
            } else if (value > 0) {
                tmp = s[index2 = --index1];
            } else {
                tmp = tmp + s[--index2];
            }
        }
    }

    static int sort(int[] s, int times, int tmp) {
        System.out.println(tmp);
        int length = s.length;
        //+1防止边缘报数组越界
        int[][] ss = new int[times][length + 1];
        int tmpJ = length - 1;
        for (int i = 0; i < times; i++) {
            for (int j = tmpJ; j >= 0; j--) {
                if (s[j] + ss[i][j + 1] > tmp) {
                    tmpJ = j;
                    break;
                } else {
                    ss[i][j] = s[j] + ss[i][j + 1];
                }
            }
        }
        //1表示值太大要重新赋值，-1表示值太小要加上前一个值
        //System.out.println(ss);
        return ss[times - 2][0] > 0 ? 1 : ss[times - 1][0] == 0 ? -1 : 0;
    }
}
