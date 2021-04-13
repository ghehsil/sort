package test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射获取hashmap的私有属性
 */
public class getMapField {
    public static void main(String[] args) {
        Map map = new HashMap(1, 100000F);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        // 利用反射,获取内部字段 "table"
        Class clsHashMap = null;
        Class clsHashMap$Node = null;
        Field[] f = null;
        Field t = null, fNode = null;
        try {
            clsHashMap = Class.forName("java.util.HashMap");
            clsHashMap$Node = Class.forName("java.util.HashMap$Node");
            f = clsHashMap.getDeclaredFields();
            AccessibleObject.setAccessible(f, true);
            for (Field field : f) {
                System.out.println(field.getName() + ":" + field.get(map));
                if (field.getName() == "table") {
                    t = field;
                }
            }
            Object[] O = ((Object[]) t.get(map));
            //table长度
            System.out.println("table.size=" + O.length);
            for (Object o : O) {
                if (o != null) {
                    System.out.println(o);
                    // Object e = clsHashMap$Node..newInstance();
                    fNode = clsHashMap$Node.getDeclaredField("next");
                    fNode.setAccessible(true);
                    while ((o = fNode.get(o)) != null) {
                        System.out.println(o);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // System.out.println(f.getName());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
