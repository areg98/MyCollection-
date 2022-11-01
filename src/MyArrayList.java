// ArrayList in Java has a get(int index) method. int is a signed 32 bit value,
// with a maximum value of 2,147,483,647. that is 2 ^ 31
// That is the largest possible value that can be accessed in an ArrayList
// Our Array list max size is 2 ^ 26 , because of:
// 1. Requested array size exceeds VM limit
// 2. Java heap space

public class MyArrayList<T> implements MyList {

    private int capacity = 8;
    private int size;
    private int temp;
    private T[] arr, container;
    private static final int MAX_ARRAY_SIZE = 67108864;


    MyArrayList(T... el) {
        size = 0;
        temp = -1;
        this.arr = (T[]) new Object[capacity];
        for (T x : el) {
            add((T) x);
        }
    }

    private void newSpace() {

        container = (T[]) new Object[size];
        for (int i = 0; i < container.length; i++) {
            container[i] = arr[i];
        }
        this.arr = (T[]) new Object[capacity * 2];
        for (int i = 0; i < container.length; i++) {
            this.arr[i] = this.container[i];
        }
        container = null;
        capacity *= 2;
    }

    public String toString() {
        try {
            if (arr[0] == null) {
                throw new NullPointerException();
            }
            String str = "[" + arr[0];
            for (int i = 1; i < this.size; i++) {
                str += ", " + arr[i];
            }
            str += "]";
            return str;
        } catch (Exception e) {
            System.out.println("\u001B[31m" + "Can't cast to String" + "\u001B[0m");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(Object el) {
        if (size >= MAX_ARRAY_SIZE) {
            System.out.println("\u001B[31m" + "Array list size cannot be more than " + MAX_ARRAY_SIZE + "\u001B[0m");
        } else if (capacity - size == 1) {
            newSpace();
        }
        size++;
        arr[++temp] = (T) el;
        return true;
    }

    @Override
    public void add(int index, Object el) {
        try {
            if (index >= size) throw new ArrayIndexOutOfBoundsException();
            T ob;
            add(el);
            for (int i = size - 2; i >= index; i--) {
                ob = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = (T) ob;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
    }

    @Override
    public void remove(int index) {
        try {
            arr[index] = null;
            size--;
            T ob;
            for (int i = index; i <= size; i++) {
                ob = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = (T) ob;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        try {
            if (fromIndex >= toIndex || toIndex > size) throw new ArrayIndexOutOfBoundsException();
            T ob;
            size -= toIndex - fromIndex;
            for (int i = 0; i <= toIndex - fromIndex; i++) {
                ob = arr[fromIndex+i];
                arr[fromIndex+i] = arr[toIndex+i];
                arr[toIndex+i] = (T) ob;
                arr[toIndex+i] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array fromIndex can't be greater than toIndex" + "\u001B[0m");
            System.exit(-1);
        }

    }

    @Override
    public T get(int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public boolean contains(Object el) {
        for (Object i : arr) {
            if (i == el) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        temp = -1;
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int indexOf(Object el) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == el) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object el) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == el) return i;
        }
        return -1;
    }

    @Override
    public void set(int index, Object el) {
        try {
            arr[index] = (T) el;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
    }

    @Override
    public Object subList(int fromIndex, int toIndex) {
        MyArrayList<T> subList = new MyArrayList();
        try {
            for (int i = 0; i <= toIndex - fromIndex; i++) {
                subList.add(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
        return subList;
    }

    @Override
    public Object clone() {
        MyArrayList clone = new MyArrayList();
        for (int i = 0; i < size; i++) {
            clone.add(arr[i]);
        }
        return clone;
    }

    @Override
    public void sort() {
        if (this.arr == null) {
            System.out.println("\u001B[31m" + "Not Possible to sort, because given is null " + "\u001B[0m");
            return;
        }
        Object ob;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if ((int) arr[i] < (int) arr[j]) {
                    ob = arr[i];
                    arr[i] = arr[j];
                    arr[j] = (T) ob;
                }
            }
        }
    }
}
