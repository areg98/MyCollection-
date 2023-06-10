package MyMap;

public interface MyMap <K,V> {
    int size();

    void put(K key, V value);

    void remove(K key);

    K getByKey(K key);

    K getByValue(K value);


}
