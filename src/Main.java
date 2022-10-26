import java.util.*;

public class Main {
    public static void main(String[] args) {

//        MyList<Character> list = new MyArrayList();
//
//        for (char i = 'a'; i < 'z'; i++) {
//            list.add(i);
//        }
//
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//
        MyList<Integer> list1 = new MyArrayList();
//        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list1.add(i);
        }
        System.out.println(list1);
        list1.sort();
        System.out.println(list1);


//        System.out.println(compareTo(list1.get(0), list1.get(1)));

//        System.out.println(list1);
//        System.out.println(list1.size());
//
//        list1.set(9,0);
//        System.out.println(list1);


//        System.out.println("\n" + list1);

//        MyVector<Integer> vector = new MyVector<>();
//        Vector<Integer> vector = new Vector<>();
//        vector.add(5);
//        vector.add(5);
//        vector.add(2);
//        vector.add(3);
//        System.out.println(vector);
//        vector.sort();

//
//        System.out.println(vector.lastElement());
//        System.out.println(vector.firstElement());
//        MyList<Integer> list = new MyVector();
//
//
//        for (int i = 0; i < vector.size(); i++) {
//            System.out.print(vector.get(i) + " ");
//        }
//        System.out.println("\n" + vector);
//        System.out.println();

    }
}
