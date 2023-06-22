package MyMap;

import MyList.MyArrayList;
import MyList.MyList;

public class MyHashMap<K, V> implements MyMap {

    private int capacity = 8;
    private int size;
    private MyList[] arr, container;
    private static final int MAX_MAP_SIZE = 67108864;

    public MyHashMap() {
        this.size = 0;
        this.arr = new MyList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.arr[i] = new MyArrayList();
        }
    }

    private int getHashCode(Object key) {
        String k = String.valueOf(key);
        int hash = 0;
        for (int i = 0; i < k.length(); i++) {
            hash *= 127;
            hash += k.charAt(i);
        }
        int index = hash % capacity;


        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(Object key, Object value) {
        try {
            if (size >= MAX_MAP_SIZE) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (capacity - size == 1) {
                newSpace();
            }
            Object[] temp = new Object[2];
            temp[0] = key;
            temp[1] = value;

            size++;
            if (checkUniqueKey(key, value)) {
                arr[getHashCode(key)].add(temp);
                /**
                 if (arr[getHashCode(key)].size() == 3) {
                 newSpace();
                 }
                 */

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array list size cannot be more than " + MAX_MAP_SIZE + "\u001B[0m");
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Object key) {
        if (arr[getHashCode(key)].size() > 0) {
            for (int i = 0; i < arr[getHashCode(key)].size(); i++) {
                Object[] el = (Object[]) arr[getHashCode(key)].get(i);
                if (el[0].equals(key)) {
                    arr[getHashCode(key)].remove(i);
                }
            }
        } else {
            arr[getHashCode(key)].remove(0);
        }
        size--;
    }

    @Override
    public Object get(Object key) {
        if (arr[getHashCode(key)].size() > 0) {
            for (int i = 0; i < arr[getHashCode(key)].size(); i++) {
                Object[] el = (Object[]) arr[getHashCode(key)].get(i);
                if (el[0].equals(key)) {
                    return el[1];
                }
            }
        } else if (arr[getHashCode(key)].size() == 1) {
            Object[] el = (Object[]) arr[getHashCode(key)].get(0);
            return el[1];
        }
        return null;
    }

    @Override
    public Object getByValue(Object value) {
        return null;
    }

    private void newSpace() {

        container = new MyList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.container[i] = new MyArrayList();
        }
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                Object[] t = (Object[]) arr[i].get(j);
                container[getHashCode(t[0])].add(t);
            }
        }
        capacity *= 2;
        this.arr = new MyList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.arr[i] = new MyArrayList();
        }
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[i].size(); j++) {
                Object[] t = (Object[]) container[i].get(j);
                arr[getHashCode(t[0])].add(t);
            }
        }
        container = null;
    }

    private boolean checkUniqueKey(Object key, Object value) {
        if (arr[getHashCode(key)].size() == 0) {
            return true;
        }
        for (int i = 0; i < arr[getHashCode(key)].size(); i++) {
            Object[] t = (Object[]) arr[getHashCode(key)].get(i);
            if (t[0].equals(key)) {
                t[1] = value;
                return false;
            }
        }
        return true;
    }


    public String toString() {
        try {
            if (this.arr == null) {
                throw new NullPointerException();
            }
            String str = "{";
            for (int i = 0; i < this.arr.length; i++) {
                if (arr[i] != null) {
                    for (int j = 0; j < arr[i].size(); j++) {
                        Object[] t = (Object[]) arr[i].get(j);
                        str += t[0] + "=" + t[1];
                        str += ", ";
                    }
                }
                //todo need to change
                if (i == this.arr.length - 1) {
                    str = str.substring(0, str.length() - 2);
                }
            }
            str += "}";
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
