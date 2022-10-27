public class MyStack<T> extends MyVector {
    int tos;

    MyStack(T ...el) {
        super();
        tos = -1;
    }

//    MyStack() {
//        super = (T[]) new Object[2];
//        tos = -1;
//    }

    void push(T el) {
        if (tos == super.size())
            System.out.println("is full");
        else
            super.add((T)el);
        tos++;
    }

    T pop() {
        T result = null;
        try{
            if (tos < 0) {
                System.out.println("is empty ");
                return null;
            } else{
                result = (T) super.arr[tos];
                super.remove(tos--);
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\u001B[31m" + "Stack is Empty" + "\u001B[0m");
        }
        return result;
    }



}
