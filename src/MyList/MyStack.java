package MyList;

public class MyStack<T> extends MyVector {

    MyStack(T ...el) {
        super(el);
    }

    void push(T el) {
       super.add(el);
    }

    T pop() {
        T result = (T) super.get(super.size()-1);
        super.remove(super.size()-1);
        return result;
    }

    boolean empty(){
        return (super.size() == 0);
    }

    T peek(){
        return (T) super.get(super.size()-1);
    }




    int search(T el){
        for (int i = 0; i < super.size(); i++) {
            if(super.get(i) == el) return i;
        }
        return -1;
    }

}
