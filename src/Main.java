import MyList.MyArrayList;
import MyList.MyList;
import MyMap.MyHashMap;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        MyList<Integer> list1 = new MyArrayList<>();
        MyHashMap<Integer,Integer> map1 = new MyHashMap<Integer, Integer>();
        map1.put(1,10);
        map1.put(2,20);
        map1.put(2,20);
        map1.put(3,30);
        System.out.println(map1);
        System.out.println(map1.size());




    }
}
