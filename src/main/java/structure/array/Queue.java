package structure.array;

import java.lang.reflect.Array;

/**
 * очередь
 */
public class Queue<T> {
    private T[] array;
    private int rear; //конец очереди
    private int front; //начало очереди
    private int maxSize;
    private int length;


    public Queue(Class<T> tClass, int length) {
        maxSize = length;
        this.length = 0;
        this.array = (T[]) Array.newInstance(tClass, length);
        rear = -1;
        front = 0;
    }

    public void insert(T value) {
        if (rear == maxSize - 1)
            rear = -1;
        array[++rear] = value;
        length++;
    }

    public T remove() {
        T buf = array[front++];
        if (front == maxSize)
            front = 0;
        length--;
        return buf;
    }


    public T peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return (length == maxSize);
    }

    public int size() {
        return length;
    }
}
