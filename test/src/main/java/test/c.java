package test;

import com.google.common.collect.Maps;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.MapIterator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class c {
    public static void main(String[] args) {
        /*//LinkedHashMap<Integer, String> m = new LinkedHashMap(10, 0.75F, true);
        Map<Integer, String> m = Maps.newConcurrentMap();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        m.put(4, "d");
        System.out.println(JSONUtils.valueToString(m));
        *//*m.get(2);
        m.get(1);
        System.out.println(JSONUtils.valueToString(m));*//*

        MapIterator mapIterator = new AbstractHashedMap.HashMapIterator(new AbstractHashedMap(m));
        while (mapIterator.hasNext()) {
            Integer key = (Integer) mapIterator.next();
            System.out.print(key);
            String value = (String) mapIterator.getValue();
            System.out.println(value);
        }*/
        int i=0;
        for (;i<5;i++){
            System.out.println(i);
        }
        System.out.println(i);
    }

}
