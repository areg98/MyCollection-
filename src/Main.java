import MyList.MyArrayList;
import MyList.MyLinkedList;
import MyList.MyVector;
import MyList.MyStack;
import MyString.MyString;

import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
//        list.add(1,0);
//        System.out.println(list.size());
        System.out.println(list);
//        System.out.println(list);
        MyLinkedList list2 = new MyLinkedList();
        list2.add(5);
        list2.add(5);
        list2.add(5);
        list2.add(5);
        list.addAll(list2);
        System.out.println(list);
        System.out.println(list.size());
//        System.out.println(list.size());
//        System.out.println(list.get(6));
//        System.out.println(list.indexOf(2));
//        System.out.println(list.lastIndexOf(2));
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.add(2);
//        list1.add(2);
//        list1.add(2);
//        list1.add(2);
//        list1.clear();
//        list1.get(0);
//        System.out.println(list1);
//        System.out.println(list1.indexOf(6));
//
        list.printNextPrev();

    }
}
