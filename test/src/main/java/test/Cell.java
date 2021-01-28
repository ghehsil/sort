package test;

public class Cell {

    public static void main(String[] args) {
        System.out.println(cell(30));
    }

    private static double cell(int hours) {
        if (hours < 1) {
            return 1;
        }
        return cell(hours - 1) + Math.pow(2D, Double.parseDouble(hours + ""));

    }
}
