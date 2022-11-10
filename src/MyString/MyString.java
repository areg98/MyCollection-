package MyString;

public class MyString {

    private char[] array;
    private int size;
    public static int a;

    public MyString(char ...str){
        this.size = str.length;
        this.array = new char[size];
        for (int i = 0; i < size; i++) {
            this.array[i] = str[i];
        }
    }


    public String toString(){
        return String.valueOf(array);
    }



    public char charAt(int index) {
        if (size == 0 || index < 0 || index > size) {
            System.out.println("Index out of range");
            return array[0];
        }
        return array[index];
    }

    public char[] subString(int index) {
        char[] temp = new char[size - index];
        int tempInd = 0;
        for (int i = index; i < size; i++) {
            temp[tempInd++] = array[i];
        }
        return temp;
    }

    public char[] subString(int firstIndex, int lastIndex) {
        char[] temp = new char[lastIndex - firstIndex];
        int tempInd = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            temp[tempInd++] = array[i];
        }
        return temp;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        boolean b;
        return b = size == 0 ? true : false;
    }

    public int codePointAt(int index) {
        return array[index];
    }

    public int codePointAtBefore(int index) {
        return array[--index];
    }

    public int indexOf(int ch) {
        for (int i = 0; i < size; i++) {
            if (array[i] == ch) {
                return i;
            }

        }
        return 0;
    }

    public int indexOf(int ch, int index) {
        for (int i = index; i < size; i++) {
            if (array[i] == ch) {
                return i;
            }

        }
        return 0;
    }
}