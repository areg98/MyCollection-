public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
//        list.add("apple");
//        list.add("banana");
//        list.add("apple");
        MyList<Integer> list1 = new MyArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
        list1.add(3);
        list1.add(5);
//        System.out.println("list: " + list);
        System.out.println("list1:" + list1);
        System.out.println("_____________________________");
        list.sort();
        list1.sort();
        System.out.println("list:" + list);
        System.out.println("list1: " + list1);


    }
}
