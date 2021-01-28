package three.IPMerge;

import java.util.*;

/**
 * Created by EDZ on 2019/4/24.
 */
class IP {
    private String IP;
    private Integer length;

    public IP(String IP, Integer length) {
        this.IP = IP;
        this.length = length;
    }

    public String getIP() {
        return IP;
    }

    public Integer getLength() {
        return length;
    }

}

class IPComparator implements Comparator<IP> {
    public int compare(IP o1, IP o2) {
        Long a = Long.parseLong(o1.getIP(), 2) - Long.parseLong(o2.getIP(), 2);
        if (a == 0) {
            if(o1.getLength() == o2.getLength()){
                System.out.println("Error!");
                return 0;
            }
            return o1.getLength() > o2.getLength() ? 1 : -1;
        }
        return a > 0 ? 1 : -1;
    }
}

public class IPMerge {
    static List IPList;

    public static void putList(String IP) {
        Integer dotNum = 0;
        Boolean barFlag = false;
        String num = "";
        String number = "";
        Integer length;
        Integer nums;
        for (int i = 0; i < IP.length(); i++) {
            char ch = IP.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num += ch;
            }
            if (ch == '.') {
                number += String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(num))));
                num = "";
                dotNum++;
                continue;
            }
            if (ch == '/') {
                number += String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(num))));
                num = "";
                barFlag = true;
                break;
            }
        }
        if (!barFlag) {
            number += String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(num))));
            length = number.length();
        } else {
            length = Integer.parseInt(IP.substring(IP.indexOf('/') + 1));
        }
        //补足不够的0
        nums = 32 - (dotNum + 1) * 8;
        for (int i = 0; i < nums; i++) {
            number += "0";
        }
        //判断IP是否正确
        if (!isIP(new IP(number, length))) {
            System.out.println("Error!");
            return;
        }
        IPList.add(new IP(number, length));
    }

    //IP合并
    public static void combine() {
        Loop:
        for (int i = 0; i < IPList.size() - 1; i++) {
            boolean flag = true;
            IP ip1 = (IP) IPList.get(i);
            IP ip2 = (IP) IPList.get(i + 1);
            //ip1的位数比ip2大，但是ip2数字比ip1多一位，所以不可能子集关系
            if (ip1.getLength() > ip2.getLength()) {
                continue;
            }
            //合并位数相同的
            else if (ip1.getLength() == ip2.getLength()) {
                //最后一个数字为0，舍去也罢
                IP tempIP = new IP(ip1.getIP(), ip1.getLength() - 1);
                if (ip1.getLength() == ip2.getLength()) {
                    for (int j = 0; j < tempIP.getLength(); j++) {
                        if (ip1.getIP().charAt(j) != ip2.getIP().charAt(j)) {
                            continue Loop;
                        }
                    }
                    IPList.set(i, tempIP);
                    IPList.remove(i + 1);
                    i--;
                }
            }
            //合并位数不同的
            else {
                for (int j = 0; j < ip1.getLength(); j++) {
                    if (ip1.getIP().charAt(j) != ip2.getIP().charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    IPList.remove(i + 1);
                    i--;
                }
            }
        }
    }

    //判断IP是否正确
    public static boolean isIP(IP IP) {
        for (int i = IP.getLength(); i < IP.getIP().length(); i++) {
            if (IP.getIP().charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        String tempStr = "";
        String printStr;
        for (int i = 0; i < IPList.size(); i++) {
            printStr = "";
            String IP = ((IP) IPList.get(i)).getIP();
            Integer length = ((IP) IPList.get(i)).getLength();
            for (int j = 0; j < IP.length(); j++) {
                tempStr += IP.charAt(j);
                if (j % 8 == 7 && j != 31) {
                    //转回十进制
                    printStr += Integer.parseInt(tempStr, 2);
                    printStr += '.';
                    tempStr = "";
                }
            }
            printStr += Integer.parseInt(tempStr, 2);
            printStr += '/';
            printStr += length;
            System.out.println(printStr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IPList = new ArrayList<IP>();
        for (int i = 0; i < n; i++) {
            putList(scanner.next());
        }
        Collections.sort(IPList, new IPComparator());
        combine();
        print();
    }

}
