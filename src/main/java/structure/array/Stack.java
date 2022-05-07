package structure.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * стек на базе массива
 */
public class Stack<T> {
    private T[] array;
    private int top;

    public Stack(Class<T> tClass, int length) {
        this.array = (T[]) Array.newInstance(tClass, length);
        this.top = -1;
    }

    public void push(T value) {
        array[++top] = value;
    }

    public T pop() {
        return array[top--];
    }

    public T peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == array.length - 1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", top=" + top +
                '}';
    }
}
