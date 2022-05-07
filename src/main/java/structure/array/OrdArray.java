package structure.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * упорядоченный массив
 */
public class OrdArray<T extends Comparable<T>> {
    private T[] massive;
    private int length = 0;

    public OrdArray(Class<T> tClass, int length) {
        massive = (T[]) Array.newInstance(tClass, length);
    }

    public void insert(T value) {
        int i;
        for (i = 0; i < length; i++) {
            if (massive[i].compareTo(value) > 0) {
                break;
            }
        }
        for (int j = length; j > i; j--) {
            massive[j] = massive[j - 1];
        }

        massive[i] = value;
        length++;
    }

    public void delete(T value) {
        int i;
        for (i = 0; i < length; i++) {
            if (massive[i].compareTo(value) == 0)
                break;
        }
        for (int j = i; j < length - 1; j++) {
            massive[j] = massive[j + 1];
        }
        massive[length - 1] = null;
        length--;
    }

    /**
     * Бинарный поиск
     *
     * @param value искомое значение
     * @return позиция
     */
    public int find(T value) {
        int lower = 0;
        int upper = length - 1;
        int i;
        while (true) {
            i = (lower + upper) / 2;
            if (massive[i] == value)
                return i;
            if (lower > upper)
                return -1;
            if (massive[i].compareTo(value) < 0)
                lower = i + 1;
            else upper = i - 1;
        }
    }

    /**
     * Бинарный поиск (рекурсия)
     */
    public int findRecurs(T value, int lower, int upper) {
        int i = (lower + upper) / 2;
        if (massive[i] == value)
            return i;
        if (lower > upper)
            return -1;
        if (massive[i].compareTo(value) < 0)
            return findRecurs(value, i + 1, upper);
        else return findRecurs(value, lower, i - 1);
    }

    public T[] getMassive() {
        return massive;
    }
}
