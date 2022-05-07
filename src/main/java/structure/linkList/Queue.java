package structure.linkList;

/**
 * очередь на базе связного списка
 *
 * @param <T> тип данных
 */
public class Queue<T extends Comparable<T>> {
    private final FirstLastList<T> firstLastList;

    public Queue() {
        firstLastList = new FirstLastList<>();
    }

    public void insert(T value) {
        firstLastList.insertEnd(value);
    }

    public T remove() {
        return firstLastList.delete();
    }


    public T peek() {
        return firstLastList.getFirstData();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void display() {
        firstLastList.display();
    }
}
