public class MyVector<T> implements MyList {

    private final int capacity = 8;
    private int size;
    private int temp;
    private T[] arr, container;
    private static final int MAX_ARRAY_SIZE = 67108864;


    MyVector(T... el) {
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
        for (int i = 0; i <= arr.length; i++) {
            this.arr[i] = this.container[i];
        }
        container = null;
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
            System.out.println("\u001B[31m" + "Can't cast to String " + "\u001B[0m");
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
        if (size > MAX_ARRAY_SIZE) {
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
            this.container = (T[]) new Object[++size];
            for (int i = 0; i < index; i++) {
                this.container[i] = arr[i];
            }
            this.container[index] = (T) el;
            for (int i = index + 1; i < size; i++) {
                this.container[i] = arr[i - 1];
            }
            this.arr = (T[]) new Object[size];
            this.temp++;
            for (int i = 0; i < size; i++) {
                arr[i] = container[i];
            }
            this.container = null;
        } catch (Exception e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
    }

    @Override
    public void remove(int index) {
        try {
            this.container = (T[]) new Object[--size];
            for (int i = 0; i < index; i++) {
                this.container[i] = arr[i];
            }
            for (int i = index + 1; i < arr.length - 1; i++) {
                this.container[i - 1] = arr[i];
            }
            this.arr = (T[]) new Object[size];
            this.temp--;
            for (int i = 0; i < size; i++) {
                arr[i] = container[i];
            }
            this.container = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            System.exit(-1);
        }
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        try {
            this.container = (T[]) new Object[size = size - (toIndex - fromIndex)];
            for (int i = 0; i < fromIndex; i++) {
                container[i] = arr[i];
            }
            for (int i = toIndex; i < size + (toIndex - fromIndex); i++) {
                container[i - (toIndex - fromIndex)] = arr[i];
            }
            this.arr = (T[]) new Object[size];
            temp = temp - (toIndex - fromIndex);
            for (int i = 0; i < size; i++) {
                arr[i] = container[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array fromIndex can't be greater than toIndex" + "\u001B[0m");
            System.exit(-1);
        } catch (NegativeArraySizeException e) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception55" + "\u001B[0m");
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


    public Object firstElement() {
        return (this.arr != null) ? arr[0] : null;
    }

    public Object lastElement() {
        return (this.arr != null) ? arr[size - 1] : null;
    }
}
