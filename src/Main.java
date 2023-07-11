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
        MyList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list);

    }
}
