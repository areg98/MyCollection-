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
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(1, 8);
        System.out.println(list);
        list.sort();
        System.out.println(list);
        list.removeRange(1, 3);
        System.out.println(list);


        MyStack<Integer> stck = new MyStack<>(5, 4, 7);
        stck.push(5);
        System.out.println(stck.empty());
        stck.push(4);
        stck.push(3);
        System.out.println(stck.pop());
        System.out.println(stck);
    }
}
