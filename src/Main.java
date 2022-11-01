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
//        list.add(21);
//        System.out.println(list.size());

//        System.out.println(list.clone());
        System.out.println(list);
        list.add(1,123);
        System.out.println(list);
        list.add(0,123);
        System.out.println(list);
        System.out.println(list.size());
        list.add(-1,0);
        System.out.println(list);

//    list.add(1);
//    list.add(5);
//    list.add(3);
//    list.add(4);
//        System.out.println(list);
//        list.add(2,8);
//        System.out.println(list);
//    list.remove(2);
//        System.out.println(list);
//        System.out.println(list.get(0));
//        list.set(1,8);
//        System.out.println(list);
//        list.sort();
//        System.out.println(list);
//
//
//        MyStack<Integer> stck = new MyStack<>(5,4,7);
//        stck.push(5);
//        System.out.println(stck.empty());
//        stck.push(4);
//        stck.push(3);
//        System.out.println(stck.pop());
//        System.out.println(stck);
    }
}
