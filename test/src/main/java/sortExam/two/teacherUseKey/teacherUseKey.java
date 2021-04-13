package sortExam.two.teacherUseKey;

import java.util.*;

/**
 * Created by EDZ on 2019/6/14.
 */
public class teacherUseKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int total = sc.nextInt();
        int min = 0;
        List<Integer> keys = new ArrayList<Integer>();
        List<teacher> teachers = new ArrayList<teacher>();
        Collections.sort(teachers, new Comparator<teacher>() {
            public int compare(teacher o1, teacher o2) {
                return o1.getKeyNum() > o2.getKeyNum() ? 1 : -1;
            }
        });
        for (int i = 1; i <= nums; i++) {
            keys.add(i);
        }
        for (int i = 0; i < total; i++) {
            teachers.add(new teacher(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        while (true) {
            min++;
            Loop:
            for (int j = 0; j < teachers.size(); j++) {
                //还钥匙
                if (teachers.get(j).getStart() + teachers.get(j).getLast() == min) {
                    for (int i = 0; i < nums; i++) {
                        if (keys.get(i) == 0) {
                            keys.set(i, teachers.get(j).getKeyNum());
                            teachers.remove(j);
                            j--;
                            if (teachers.size() == 0) {
                                System.out.println(keys);
                                return;
                            }
                            continue Loop;
                        }
                    }
                }
                //取钥匙
                if (teachers.get(j).getStart() == min) {
                    for (int i = 0; i < nums; i++) {
                        if (keys.get(i) == teachers.get(j).getKeyNum()) {
                            keys.set(i, 0);
                        }
                    }
                }
            }
        }

    }
}

class teacher {
    private int keyNum;
    private int start;
    private int last;

    public teacher(int keyNum, int start, int last) {
        this.keyNum = keyNum;
        this.start = start;
        this.last = last;
    }

    public int getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(int keyNum) {
        this.keyNum = keyNum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
