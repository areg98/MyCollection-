package MyList;

public class MyLinkedList<T> implements MyList{
    Node<T> first;
    Node<T> last;
    int size = 0;


    private static class Node<T>{
        Node<T> next;
        Node<T> prev;
        T el;

        private Node(Node<T> prev, T el, Node<T> next){
            this.next = next;
            this.prev = prev;
            this.el = el;
        }
    }

    private void linkLast(T el){
        Node<T> last = this.last;
        Node<T> newEl = new Node<>(last, el, null);
        this.last = newEl;
        if (last == null){
            this.first = newEl;
        }
        else {
            last.next = newEl;
        }
        this.size++;
    }

    public String toString(){
        try {
            if (this.size == 0) {
                throw new NullPointerException();
            }
            String str = "[" + this.first.el ;
            Node<T> element = this.first.next;
            while (element.next != null){
                str += ", " + element.el;
                element = element.next;
            }
            str += ", " + this.last.el +  "]";
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        Node<T> element = this.first;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.el;
    }

    @Override
    public boolean contains(Object el) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return (this.first == null);
    }

    @Override
    public int indexOf(Object el) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object el) {
        return 0;
    }

    @Override
    public void set(int index, Object el) {

    }

    @Override
    public MyList subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public MyList clone() {
        return null;
    }

    @Override
    public void sort() {

    }

    public boolean add(Object el){
        linkLast((T)el);
        return true;
    }

    @Override
    public void add(int index, Object el) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {

    }

    @Override
    public void addAll(MyList list) {
    }

}

