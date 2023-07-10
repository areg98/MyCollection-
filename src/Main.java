import MyList.MyArrayList;
import MyList.MyList;
import MyMap.MyHashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        MyList<Integer[]> list1 = new MyArrayList<>();
//        Integer[] a = new Integer[2];
//                a[0] = 1;
//                a[1] = 2;
//        list1.add(a);
//        System.out.println(list1.get(0)[0] + " = " + list1.get(0)[1] );
//        MyList[] arr = new MyList[2];
//        arr[0] = new MyArrayList();
//        arr[0].add(1);
//        System.out.println(arr[0].get(0));
        MyHashMap<Integer,String> map1 = new MyHashMap<Integer, String>();
//        map1.put(1,"Java");
//        map1.put(2,"Python");
//        map1.put(3,"JavaScript");
//        map1.put(2,"C++");
//        map1.put(4,"C++");
//        map1.put(2231,"Rudy");
//        map1.put(2230,"C#");
//        map1.put(2230,"C*");

        System.out.println(java.time.LocalDateTime.now());

        for (int i = 0, j = 0; i <= 10; i++, j++) {
            map1.put(i,j);
        }

//        map1.remove(1);
        System.out.println(map1);
        System.out.println(java.time.LocalDateTime.now());
        System.out.println();
//        System.out.println(java.time.LocalTime.now());
//        System.out.println(map1.get(1));
        System.out.println(java.time.LocalTime.now());




//
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i <= 10; i++, j++) {
            map.put(i,j);
        }
//        map.remove(0);
        System.out.println(map);
        System.out.println(java.time.LocalTime.now());
//        System.out.println(map.get(0));
//        System.out.println(java.time.LocalTime.now());



//        System.out.println("size: " + map1.size());
//        Integer i = 555;
//        String j = "aaa";
//
//        System.out.println(map1);
//        System.out.println();
//        System.out.println(map1.get(1));
//        System.out.println(map1.get(2));
//        System.out.println(map1.get(3));
//        System.out.println(map1.get(4));
//        System.out.println(map1.get(2231));
//        System.out.println(map1.get(2230));
        HashMap<Integer, Integer> m = new HashMap<>();
//        m.put(1, 25);
//        m.put(2, 26);
//        m.put(8787, 26);
//        m.put(12554, 26);
//        m.put(8548, 26);
//        System.out.println(m.get(1));
//        System.out.println(m);



    }
}
