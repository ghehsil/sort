package test;

/**
 * 位图 布隆过滤器
 * 用数组代替hash表
 * 优点是节省空间
 * long用6位二进制存值
 * 每一位都代表一个true or false 代替java boolean 5位
 * 节省4/5
 */
public class BitMap {
    int bit;
    long[] array;

    //capacity是数组大小 bit是装载因子
    public BitMap(int capacity, int bit) {
        array = new long[capacity];
        this.bit = bit;
    }

    public void set(int n) {
        array[n % array.length * bit / bit] |= 1 << n % bit;
    }

    public boolean get(int n) {
        return (array[n % array.length * bit / bit] & 1 << n % bit) != 0;
    }

    public static void main(String[] args) {
        //不能大于11*6个数
        BitMap bitMap1 = new BitMap(11, 6);
        //不能大于11*5个数
        BitMap bitMap2 = new BitMap(11, 5);
        //以11*5为界
        //1和56为例 两个位图都放进去1 避免56和1冲突
        bitMap1.set(0);
        bitMap2.set(0);
        //放进去的值不能是两个最大数值的公约数
        //如果是 就要挑另一个装载因子
        System.out.println(bitMap1.get(66*55) & bitMap2.get(66*55));
    }
}
