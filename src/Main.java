import MyList.MyList;
import MyList.MyArrayList;
import MyList.MyVector;
import MyList.MyStack;
import MyString.MyString;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        MyList<Integer> list1 = new MyArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
        list1.add(3);
        list1.add(5);
        MyList<Character> list2 = new MyArrayList<>();
        list2.add('a');
        list2.add('n');
        list2.add('d');
        list2.add('c');
        list2.add('b');
        list2.add('v');
        MyList<Double> list3 = new MyArrayList<>();
        list3.add(2.2);
        list3.add(1.4);
        list3.add(2.1);
        list3.add(3.2);


        System.out.println("list: " + list);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);
        System.out.println("_____________________________");
        list.sort();
        list1.sort();
        list2.sort();
        list3.sort();
        System.out.println("list:" + list);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);

        char[] chrArray = {'H', 'e', 'l', 'l', 'o'};
        MyString str = new MyString(chrArray);
        System.out.println(str);
        String a = "abc";

    }
}
