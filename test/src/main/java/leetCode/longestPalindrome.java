package leetCode;

/*
* 寻找最大回文串
* */
public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccccc"));
    }

    private static String longestPalindrome(String s) {
        int length = s.length();
        int size = 2 * length - 1;
        int[][] integers = new int[size][size];

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    integers[2 * i][2 * j] = 1;
                    integers[2 * j][2 * i] = 1;
                }
            }
        }

        int max = 0, index = 0, m = 0, n = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i - j < 0 || i + j > size - 1) {
                    break;
                }
                if (i % 2 == 1) {
                    if (j == 0) {
                        index = 0;
                    } else if (j % 2 == 0) {
                        continue;
                    } else {
                        if (integers[i - j][i + j] == 1) {
                            index += 2;
                            if (max < index) {
                                max = index;
                                m = i - j;
                                n = i + j;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    if (j == 0) {
                        index = 1;
                        if (max < index) {
                            max = index;
                            m = i - j;
                            n = i + j;
                        }
                    } else if (j % 2 == 1) {
                        continue;
                    } else {
                        if (integers[i - j][i + j] == 1) {
                            index += 2;
                            if (max < index) {
                                max = index;
                                m = i - j;
                                n = i + j;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return s.substring(m / 2, (n / 2) + 1);
    }

}
