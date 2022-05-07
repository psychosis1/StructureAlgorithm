package structure.linkList;

/**
 * Двусторонний список
 */
public class FirstLastList<T extends Comparable<T>> extends LinkList<T> {
    private Link<T> last;

    @Override
    public void insertBegin(T data) {
        Link<T> link = new Link<>(data);
        if (!this.isEmpty()) {
            link.setNext(first);
        } else {
            last = link;
        }
        first = link;
    }

    @Override
    public T delete() {
        if (this.isEmpty())
            return null;
        Link<T> deleted = first;
        first = deleted.getNext();
        if (first == null)
            last = null;
        return deleted.getData();
    }

    /**
     * вставка в конец
     */
    public void insertEnd(T data) {
        Link<T> link = new Link<>(data);
        if (!this.isEmpty()) {
            last.setNext(link);
        } else {
            first = link;
        }
        last = link;
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
