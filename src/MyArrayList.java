// ArrayList in Java has a get(int index) method. int is a signed 32 bit value,
// with a maximum value of 2,147,483,647. that is 2 ^ 31
// That is the largest possible value that can be accessed in an ArrayList
// Our Array list max size is 2 ^ 24` , because of:
// 1. Requested array size exceeds VM limit
// 2. Java heap space

public class MyArrayList<T extends Object> implements MyList {

    private final int actualSize = 8;
    private int size;
    private int temp;
    private T[] arr, container;


    MyArrayList(T... el) {
        size = 0;
        temp = -1;
        this.arr = (T[]) new Object[actualSize];
        for (T x : el) {
            add((T) x);
        }
    }

    private void newSpace() {

        container = (T[]) new Object[size];
        for (int i = 0; i < container.length; i++) {
            container[i] = arr[i];
        }
        this.arr = (T[]) new Object[actualSize * 2];
        for (int i = 0; i <= arr.length; i++) {
            this.arr[i] = this.container[i];
        }
        container = null;
    }


    public String toString() {
        try {
            String str = "[" + arr[0];
            for (int i = 1; i < this.size; i++) {
                str += ", " + arr[i];
            }
            str += "]";
            return str;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "List is empty" + "\u001B[0m");
        }
        System.exit(-1);
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(Object el) {
        if (actualSize - size == 1) {
            newSpace();
        }
        size++;
        arr[++temp] = (T) el;
        return true;
    }

    @Override
    public void add(int index, Object el) {
        if (index < 0 || index >= size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        } else {
            this.container = (T[]) new Object[++size];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    this.container[i] = (T) el;
                    i++;
                }
                container[i] = arr[j];
            }
            this.arr = (T[]) new Object[size];
            this.temp++;
            for (int i = 0; i < size; i++) {
                arr[i] = container[i];
            }
        }
        this.container = null;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        } else {
            this.container = (T[]) new Object[--size];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    j++;
                }
                container[i] = arr[j];
            }
            this.arr = (T[]) new Object[size];
            this.temp--;
            for (int i = 0; i < size; i++) {
                arr[i] = container[i];
            }
        }
        this.container = null;
    }

    @Override
    public T get(int index) {
            if (index < 0 || index > temp) {
                System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
                System.exit(-1);
            }
            return arr[index];
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
        this.arr = (T[]) new Object[actualSize];
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
        if (index < 0 || index >= size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        } else {
            arr[index] = (T) el;
        }
    }

    @Override
    public Object subList(int fromIndex, int toIndex) {
        MyArrayList<T> subList = new MyArrayList();
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return null;
        } else {
            for (int i = 0; i <= toIndex - fromIndex; i++) {
                subList.add(arr[i]);
            }
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
