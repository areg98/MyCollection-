package MyMap;

import java.util.HashMap;

public class MyHashMap<K, V> implements MyMap{

    private int capacity = 8;
    private int size;
    private int temp;
    private Node[] arr, container;
    private static final int MAX_MAP_SIZE = 67108864;
    K key;
    V value;

    private class Node<K,V> extends HashMap {
        K key;
        V value;

        private Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap(){
        this.size = 0;
        this.temp = -1;
        this.arr = new Node [capacity];
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
            }
            // TODO: check multiple key */
//            else if (){
//
//            }

            else if (capacity - size == 1) {
                newSpace();
            }
            size++;
            arr[++temp] = new Node<>(key, value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m" + "Array list size cannot be more than " + MAX_MAP_SIZE + "\u001B[0m");
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Object key) {

    }

    @Override
    public Object getByKey(Object key) {
        return null;
    }

    @Override
    public Object getByValue(Object value) {
        return null;
    }
    private void newSpace() {

        container = (Node[]) new Object[size];
        for (int i = 0; i < container.length; i++) {
            container[i] = arr[i];
        }
        this.arr = (Node[]) new Object[capacity * 2];
        for (int i = 0; i < container.length; i++) {
            this.arr[i] = this.container[i];
        }
        container = null;
        capacity *= 2;
    }

    public String toString() {
        try {
            if (this.arr == null) {
                throw new NullPointerException();
            }
            String str = "[" + arr[0].key + "=" + arr[0].value;
            for (int i = 1; i < this.size; i++) {
                str += ", " + arr[i].key + "=" + arr[0].value;
            }
            str += "]";
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
