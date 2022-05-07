package structure.linkList;

/**
 * стек на базе связного списка
 * @param <T> тип данных
 */
public class Stack<T extends Comparable<T>> {
    private final LinkList<T> linkList;

    public Stack() {
        this.linkList = new LinkList<>();
    }

    public void push(T value) {
        linkList.insertBegin(value);
    }

    public T pop() {
        return linkList.delete();
    }

    public T peek() {
        return linkList.getFirstData();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void display() {
        linkList.display();
    }
}
