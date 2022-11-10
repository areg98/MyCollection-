import MyList.MyArrayList;
import MyList.MyLinkedList;
import MyList.MyVector;
import MyList.MyStack;
import MyString.MyString;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(5);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
    }
}
