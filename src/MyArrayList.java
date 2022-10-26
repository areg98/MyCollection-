public class MyArrayList<T> implements MyList {

    private final int fullSize = 20000000;
    private int size;
    private int temp;
    private Object[] arr, arr1;

    MyArrayList() {
        size = 0;
        temp = -1;
        this.arr1 = new Object[fullSize];
    }

    MyArrayList(T... el) {
        MyArrayList<T> list = new MyArrayList();
        for (T x : el) {
            list.add(el);
        }
    }

    public String toString() {
        String str = "[" + arr[0];
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
        this.arr = new Object[++size];
        arr1[++temp] = el;
        for (int i = 0; i < size; i++) {
            arr[i] = arr1[i];
        }
        return true;
    }

    @Override
    public void add(int index, Object el) {
        if (index < 0 || index >= size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        } else {
            this.arr = new Object[++size];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    this.arr[i] = el;
                    i++;
                }
                arr[i] = arr1[j];
            }
            this.arr1 = new Object[fullSize];
            this.temp++;
            for (int i = 0; i < size; i++) {
                arr1[i] = arr[i];
            }
        }


    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        } else {
            this.arr = new Object[--size];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    j++;
                }
                arr[i] = arr1[j];
            }
            this.arr1 = new Object[fullSize];
            this.temp--;
            for (int i = 0; i < size; i++) {
                arr1[i] = arr[i];
            }
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size) {
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return null;
        } else {
            return arr[index];
        }
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
        this.arr = new Object[size];
        this.arr1 = new Object[fullSize];
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
            arr1[index] = el;
            arr[index] = el;
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
    public void sort(){
        if (this.arr == null) {
            System.out.println("\u001B[31m" + "Not Possible to sort, because given is null " + "\u001B[0m");
            return;
        }
        Object ob;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if ((int)arr[i] < (int) arr[j]) {
                   ob = arr[i];
                   arr[i] = arr[j];
                   arr[j] = ob;
                }
            }
        }

    }

}
