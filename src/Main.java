import MyList.MyList;
import MyList.MyArrayList;
import MyList.MyVector;
import MyList.MyStack;
import MyString.MyString;


public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyVector<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1,5);
        System.out.println(list);
        list.removeRange(0,2);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.contains(1));
        System.out.println(list.isEmpty());
        System.out.println(list.indexOf(1));

        list.add(1,2);
        System.out.println(list);
        list.set(1,5);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.lastIndexOf(1));

        MyList list1;
        list1 = list.subList(0,2);
        System.out.println(list1);
        MyList clone;
        clone = list1.clone();
        System.out.println(clone);
        clone.sort();
        System.out.println(clone);

    }
}
