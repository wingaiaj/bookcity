package day5;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName collectionTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/17 11:42
 * @Version 1.0
 */
public class collectionTest {
    @Test
    public void ct1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"11");
        map.put(2,"12");
        map.put(3,"13");

//1
//        Set<Integer> integers = map.keySet();
//        for (Integer integer : integers) {
//            String s = map.get(integer);
//            System.out.println(s);
//        }

//2
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, String> next = iterator.next();
//            System.out.println(next);
//        }


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
//1
//
//        for (String s : list) {
//            System.out.println(s);
//        }
//2
//        Object[] objects = list.toArray();
//
//        Arrays.toString(objects);
//




        Set<String> set = new HashSet<>();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
