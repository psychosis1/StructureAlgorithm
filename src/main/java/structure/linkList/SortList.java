package structure.linkList;

/**
 * Сортированный список
 */
public class SortList<T extends Comparable<T>> {
    private final LinkList<T> linkList;

    public SortList() {
        linkList = new LinkList<>();
    }

    public void remove() {
        linkList.delete();
    }

    public void insert(T value) {
        linkList.insertSort(value);
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void display() {
        linkList.display();
    }
}
