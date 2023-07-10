package MyMap;

import MyList.MyArrayList;
import MyList.MyList;

public class MyHashMap<K, V> implements MyMap {

    private int capacity = 8;
    private int size;
    private MyList[] arr, container;
    private static final int MAX_MAP_SIZE = 67108864;

    enum Flag {
        GET,
        REMOVE,
    }

//    private static class Node<T> {
//        Object key, value;
//
//        private Node(Object key, Object value) {
//            this.key = key;
//            this.value = value;
//        }
//    }

    public MyHashMap() {
        this.size = 0;
        this.arr = new MyList[capacity];
        for (int i = 0; i < capacity; ++i) {
            this.arr[i] = new MyArrayList();
        }
    }

    private final int getHashCode(Object key) {
        final int ASCIISymCnt = 127;
        int hash = 0;
        String sKeyString = String.valueOf(key);

        for (int i = 0; i < sKeyString.length(); ++i) {
            hash = hash * ASCIISymCnt + sKeyString.charAt(i);
        }

        if (hash < 0) hash *= -1;
        return hash % capacity;
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    public void put(Object key, Object value) {
        try {
            if (size == MAX_MAP_SIZE) {
                throw new ArrayIndexOutOfBoundsException();

            } else if (capacity - size == 1) {
                normalizeMap();
            }

            size++;

            // can we have version with duplicate keys?
            // yes, maybe the user wants to put an element with the key which is already exists.

            Object[] currElement = GetRemoveHelper(key, Flag.GET);

            if (currElement == null) {
                Object[] pairKeyValue = new Object[2];
                pairKeyValue[0] = key;
                pairKeyValue[1] = value;
                arr[getHashCode(key)].add(pairKeyValue);
//                arr[getHashCode(key)].add(new Node (key, value));
            } else {
                currElement[1] = value;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array list size cannot be more than " + MAX_MAP_SIZE + " or something went wrong" + "\u001B[0m");
            e.printStackTrace();
        }
    }

    /**
     * helper for get/remove
     */

    private Object[] GetRemoveHelper(Object key, Flag flag) {

        MyList currBucket = arr[getHashCode(key)];

        for (int i = 0; i < currBucket.size(); i++) {
            Object[] currElement = (Object[]) currBucket.get(i);

            /** if found key to remove or return */

            if (currElement[0].equals(key)) {

                switch (flag) {
                    case GET:
                        return currElement;
                    case REMOVE:
                        currBucket.remove(i);
                        return null;
                }
            }
        }
        return null;
    }

    @Override
    public void remove(Object key) {

        try {
            GetRemoveHelper(key, Flag.REMOVE);
        } catch (Exception e) {
            System.out.println("\u001B[31m" + "No Such Element" + "\u001B[0m");
            e.printStackTrace();
        }

        size--;
    }

    @Override
    public Object get(Object key) {

        try {
            return GetRemoveHelper(key, Flag.GET)[1];
        } catch (NullPointerException e) {
            System.out.println("\u001B[31m" + "No Such Element" + "\u001B[0m");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getByValue(Object value) {
        return null;
    }

    private void normalizeMap() {

        capacity *= 2;
        MyList[] tempContainer = new MyList[capacity];
        for (int i = 0; i < capacity; ++i) {
            tempContainer[i] = new MyArrayList();
        }

        for (int i = 0; i < this.arr.length; ++i) {
            MyList currBucket = arr[i];
            for (int j = 0; j < currBucket.size(); ++j) {
                Object[] currElement = (Object[]) currBucket.get(j);
                tempContainer[getHashCode(currElement[0])].add(currElement);
            }
        }

        this.arr = tempContainer;
    }


    public String toString() {

        String str;

        str = "{";
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] != null) {
                for (int j = 0; j < arr[i].size(); j++) {
                    Object[] t = (Object[]) arr[i].get(j);
                    str += t[0] + "=" + t[1];
                    str+= (i == arr.length -1) ? "" : ", ";
                }
            }
        }
        str += "}";
        return str;
    }

//    public String toString() {
//
//        String str;
//        if (this.size == 0) {
//            return str = "{}";
//        }
//        str = "{";
//        for (int i = 0; i < this.arr.length; i++) {
//            if (arr[i] != null) {
//                for (int j = 0; j < arr[i].size(); j++) {
//                    Node node = (Node) arr[i].get(j);
//                    str += node.key + "=" + node.value;
//                    str += ", ";
//                }
//            }
//            //todo need to change
//            if (i == this.arr.length - 1) {
//                str = str.substring(0, str.length() - 2);
//            }
//        }
//        str += "}";
//        return str;
//    }
}
