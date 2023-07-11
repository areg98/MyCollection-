// ArrayList in Java has a get(int index) method. int is a signed 32 bit value,
// with a maximum value of 2,147,483,647. that is 2 ^ 31
// That is the largest possible value that can be accessed in an ArrayList
// Our Array list max size is 2 ^ 26 , because of:
// 1. Requested array size exceeds VM limit
// 2. Java heap space

package MyList;

public class MyArrayList<T> implements MyList {

    private int capacity = 8;
    private int size;
    private int temp;
    private T[] arr;
    private static final int MAX_ARRAY_SIZE = 67108864;


    public MyArrayList(T... el) {
        size = 0;
        temp = -1;
        this.arr = (T[]) new Object[capacity];
        for (T x : el) {
            add((T) x);
        }
    }

    private void newSpace() {

        capacity*=2;
        T[] container = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            container[i] = arr[i];
        }
        arr = container;
    }

    public String toString() {
            String str = "[";
            if(arr[0] != null){
                str+=arr[0];
            }
            for (int i = 1; i < this.size; i++) {
                str += ", " + arr[i];
            }
            str += "]";
            return str;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(Object el) {
        try {
            if (size == MAX_ARRAY_SIZE) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (capacity - size == 1) {
                newSpace();
            }
            size++;
            arr[++temp] = (T) el;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array list size cannot be more than " + MAX_ARRAY_SIZE + "\u001B[0m");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void add(int index, Object el) {
        try {
            if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
            T ob;
            add(el);
            for (int i = size - 2; i >= index; i--) {
                ob = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = (T) ob;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void addAll(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    @Override
    public void remove(int index) {
        try {
            arr[index] = null;
            size--;
            temp--;
            T ob;
            for (int i = index; i <= size; i++) {
                ob = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = (T) ob;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void removeRange(int fromIndex, int toIndex) {
        try {
            if (fromIndex >= toIndex || toIndex > size) throw new ArrayIndexOutOfBoundsException();
            T ob;
            size -= toIndex - fromIndex;
            temp -= toIndex - fromIndex;
            for (int i = 0; i <= toIndex - fromIndex; i++) {
                ob = arr[fromIndex + i];
                arr[fromIndex + i] = arr[toIndex + i];
                arr[toIndex + i] = (T) ob;
                arr[toIndex + i] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        try {
            if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
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
        capacity = 8;
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
            e.printStackTrace();
        }
    }

    @Override
    public MyList subList(int fromIndex, int toIndex) {
        MyList<T> subList = new MyArrayList();
        try {
            if (fromIndex < 0 || toIndex >= size){
                throw new ArrayIndexOutOfBoundsException();
            }
            for (int i = 0; i <= toIndex - fromIndex; i++) {
                subList.add(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return subList;
    }

    @Override
    public MyList clone() {
        MyList<T> clone = new MyArrayList();
        for (int i = 0; i < size; i++) {
            clone.add(arr[i]);
        }
        return clone;
    }

    @Override
    public void sort() {
        try {
            if (this.arr == null) {
               throw new ArrayIndexOutOfBoundsException();
            }
            T ob;
            for (int i = 0; i < this.size(); i++) {
                for (int j = 0; j < this.size(); j++) {
                    if (arr[i].toString().compareTo(arr[j].toString()) < 0) {
                        ob = arr[i];
                        arr[i] = arr[j];
                        arr[j] = ob;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("\u001B[31m" + "Not Possible to sort, because given is null " + "\u001B[0m");
        }
    }
}
