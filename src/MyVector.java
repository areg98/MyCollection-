public class MyVector <T> implements MyList {

    private final int fullSize = 20000000;
    private int size;
    private int temp;
    private Object[] arr, arr1;

    MyVector() {
        size = 0;
        temp = -1;
        this.arr1 = new Object[fullSize];
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
        if (index < 0 || index >= size){
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return;
        }else {
            arr1[index] = el;
            arr[index] = el;
        }
    }



    @Override
    public MyVector clone() {
        MyVector clone = new MyVector();
        for (int i = 0; i < size; i++) {
            clone.add(arr[i]);
        }
        return clone;
    }

    public Object subList(int fromIndex, int toIndex) {
        MyVector<T> subList = new MyVector();
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex ){
            System.out.println("\u001B[31m" + "Array Index Out Of Bounds Exception" + "\u001B[0m");
            return null;
        } else {
            for (int i = 0; i < toIndex - fromIndex; i++) {
                subList.add(arr[i]);
            }
        }
        return subList;
    }

    @Override
    public void sort(){
        Object ob;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if ((int)arr[i] > (int) arr[j]) {
                    ob = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ob;
                }
            }
        }

    }


    public Object firstElement() {
        return (this.arr != null)?arr[0]:null;
    }

    public Object lastElement() {
        return (this.arr != null)?arr[size-1]:null;
    }





}
