public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(51);
        list.add(13);
        list.add(4);
        list.add(8);
        list.add(7);
        list.add(21);
        list.add(21);
        System.out.println(list);
        System.out.println(list.size());
        list.removeRange(1,5);
        System.out.println(list);
    }
}
