package MyList;

public class MyLinkedList<T> implements MyList {
    Node<T> first;
    Node<T> last;
    int size = 0;


    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T el;

        private Node(Node<T> prev, T el, Node<T> next) {
            this.next = next;
            this.prev = prev;
            this.el = el;
        }
    }

    private void linkLast(T el) {
        Node<T> last = this.last;
        Node<T> newEl = new Node<>(last, el, null);
        this.last = newEl;
        if (last == null) {
            this.first = newEl;
        } else {
            last.next = newEl;
        }
        this.size++;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(this.size);
        }
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        String str = "[" + this.first.el;
        Node<T> element = this.first.next;
        while (element.next != null) {
            str += ", " + element.el;
            element = element.next;
        }
        str += ", " + this.last.el + "]";
        return str;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object el) {
        linkLast((T) el);
        return true;
    }

    @Override
    public void add(int index, Object el) {
        Node<T> element = this.first;
        for (int i = 0; i < index ; i++) {
            element = element.next;
        }
        Node<T> node = new Node(element.prev, el, element);
        element.prev.next = node;
        element.prev = node;

    }

    @Override
    public void addAll(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }


    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> element = this.first;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.el;
    }

    @Override
    public boolean contains(Object el) {
        Node<T> element = this.first;
        while (element.next != null) {
            if (element.el == el) return true;
            element = element.next;
        }
        return false;
    }

    @Override
    public void clear() {

        for (Node<T> element = this.first; element != null; element = element.next) {
            element.el = null;
            element.next = null;
            element.prev = null;
            size = 0;
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.first.el == null);
    }

    @Override
    public int indexOf(Object el) {
        Node<T> element = this.first;
        for (int i = 0; i < this.size; i++) {
            if (element.el == el) return i;
            element = element.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object el) {
        Node<T> element = this.last;
        for (int i = size - 1; i >= 0; i--) {
            if (element.el == el) return i;
            element = element.prev;
        }
        return -1;
    }

    @Override
    public void set(int index, Object el) {
        checkIndex(index);
        Node<T> element = this.first;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        element.el = (T) el;
    }

    @Override
    public MyList subList(int fromIndex, int toIndex) {
        MyLinkedList<T> clone = new MyLinkedList();
        Node<T> element = this.first;
        for (int i = fromIndex; i < toIndex; i++) {
            if (i >= fromIndex && i < toIndex){
                clone.add(element.el);
            }
            element = element.next;
        }
        return clone;
    }

    @Override
    public MyList clone() {
       MyLinkedList<T> clone = new MyLinkedList();
       Node<T> element = this.first;
       while (element.next != null){
           clone.add(element.el);
           element = element.next;
       }
       return clone;
    }

    @Override
    public void sort() {

    }


    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            this.first.next.prev = null;
            this.first = this.first.next;
            size--;
            return;
        } else if (index == size - 1) {
            this.last.prev.next = null;
            this.last = this.last.prev;
            size--;
            return;
        } else {
            Node<T> element = this.first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            element.next.prev = element.prev;
            element.prev.next = element.next;
            element.el = null;
            size--;
        }

    }


    public void printNextPrev() {
        Node<T> element = this.first;
        int i = 0;
        while (i < size) {
            try {
                System.out.print("prev: " + element.prev.el + " ");
                System.out.print("el: " + element.el + " ");
            } catch (Exception e) {
                System.out.print("prev: " + element.prev + " ");
                System.out.print("el: " + element.el + " ");
            }
            try {
                System.out.print("next: " + element.next.el + " ");
            } catch (Exception e) {
                System.out.print("next: " + element.next + " ");
            }

            System.out.println();
            i++;
            element = element.next;
        }
    }


}

