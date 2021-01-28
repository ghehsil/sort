package test;

/**
 * 平方根 开方
 */
public class suqar {

    private static final double num = 100;
    private static double high = num;
    private static double low = 0;
    private static int times = 0;

    public static void main(String[] args) {
        System.out.println(sqrt(num));
        System.out.println(times);
        //System.out.println(Math.sqrt(num));
    }

    private static double sqrt(double d) {
        double fix = 0.000001;
        double mid = low + (high - low) / 2;
        double pow = Math.pow(mid, 2);

        if (Math.abs(pow - num) <= fix || times > 100) {
            return mid;
        }

        if (pow < num) {
            low = mid;
        } else {
            high = mid;
        }

        times++;

        return sqrt(mid);
    }
}
