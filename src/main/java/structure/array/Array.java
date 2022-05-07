package structure.array;

/**
 * неотсортированный массив
 *
 * @param <T>
 */
public class Array<T extends Comparable<T>> {
    private T[] massive;
    private int length = 0;

    private Class<T> tClass;

    public Array(Class<T> tClass, int length) {
        this.tClass = tClass;
        massive = (T[]) java.lang.reflect.Array.newInstance(tClass, length);
    }

    public void insert(T value) {
        massive[length] = value;
        length++;
    }

    /**
     * сортировка Пузырьком
     */
    public void bubbleSort() {
        for (int i = length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (massive[j].compareTo(massive[j + 1]) > 0) {
                    T buf = massive[j + 1];
                    massive[j + 1] = massive[j];
                    massive[j] = buf;
                }
            }
        }
    }

    /**
     * сортировка Выбором
     */
    public void selectSort() {
        int min = 0;
        T buf;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (massive[min].compareTo(massive[j]) > 0)
                    min = j;
            }
            buf = massive[i];
            massive[i] = massive[min];
            massive[min] = buf;
            min = 1 + i;

        }

    }

    /**
     * сортировка слиянием
     */
    public void mergeSort() {
        recursMerge(0, massive.length-1);
    }

    private void recursMerge(int lower, int upper) {
        if (lower == upper)
            return;

        int mid = (lower + upper) / 2;

        recursMerge(lower, mid);
        recursMerge(mid + 1, upper);

        merge(lower, mid, upper);
    }

    private void merge(int lower, int mid, int upper) {
        int lengthLeft = mid - lower + 1;
        int lengthRight = upper - mid;

        T[] leftArray = (T[]) java.lang.reflect.Array.newInstance(tClass, lengthLeft);
        T[] rightArray = (T[]) java.lang.reflect.Array.newInstance(tClass, lengthRight);

        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = massive[lower+i];
        }

        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = massive[mid+i+1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = lower; i < upper + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0)
                    massive[i] = leftArray[leftIndex++];
                else
                    massive[i] = rightArray[rightIndex++];
            } else if (leftIndex<lengthLeft){
                massive[i] = leftArray[leftIndex++];
            }else if (rightIndex<lengthRight){
                massive[i] = rightArray[rightIndex++];
            }
        }
    }

    public T[] getMassive() {
        return massive;
    }
}
