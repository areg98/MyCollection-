

public interface MyList <T> {



    int size();

    boolean add(T el);

    void add(int index, T el);

    void remove(int index);

    T get(int index);

    boolean contains(T el);

    void clear();

    boolean isEmpty();

    int indexOf(T el);

    int lastIndexOf(T el);

    void set(int index, T el);

    T subList(int fromIndex, int toIndex);

    T clone();

    void sort();
}
