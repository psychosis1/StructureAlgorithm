package structure.array;

import java.lang.reflect.Array;

/**
 * приоритетная очередь на базе массивов
 */
public class PriorityQueue<T extends Comparable> {
    private T[] array;
    private int maxSize;
    private int length;

    public PriorityQueue(Class<T> tClass, int length) {
        this.array = (T[]) Array.newInstance(tClass, length);
        maxSize = length;
        this.length = 0;
    }

    public void insert(T value) {
        if (length == 0) {
            array[length++] = value;
        } else {
            int i;
            for (i = length - 1; i >= 0; i--) {
                if (array[i].compareTo(value) < 0) {
                    array[i + 1] = array[i];
                } else break;
            }
            array[i + 1] = value;
            length++;
        }
    }

    public T remove() {
        return array[length--];
    }

    public T peek() {
        return array[length - 1];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == maxSize;
    }
}
