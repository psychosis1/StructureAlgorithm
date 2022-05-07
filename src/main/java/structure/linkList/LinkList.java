package structure.linkList;

/**
 * Простой связный список
 *
 * @param <T> Данные
 */
public class LinkList<T extends Comparable<T>> {
    protected Link<T> first;

    /**
     * вставка в начало
     */
    public void insertBegin(T data) {
        Link<T> link = new Link<>(data);
        if (!this.isEmpty()) {
            link.setNext(first);
        }
        first = link;
    }

    /**
     * удаление из начала списка
     *
     * @return удаленное значение
     */
    public T delete() {
        if (this.isEmpty())
            return null;
        Link<T> deleted = first;
        first = deleted.getNext();
        return deleted.getData();
    }

    public boolean find(T data) {
        Link<T> current = first;
        while (current != null) {
            if (current.getData().equals(data))
                return true;
            current = current.getNext();
        }
        return false;
    }

    public T deleteValue(T data) {
        Link<T> current = first;
        if (current != null) {
            if (current.getData().equals(data)) {
                first = current.getNext();
                return current.getData();
            }
        }

        while (current != null) {
            if (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    Link<T> deleted = current.getNext();
                    current.setNext(deleted.getNext());
                    return deleted.getData();
                }
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Вставка в начало в порядке возрастания
     */
    public void insertSort(T data) {
        Link<T> link = new Link<>(data);
        if (this.isEmpty()) {
            first = link;
            return;
        }

        Link<T> current = first;

        if (first.getData().compareTo(data) > 0) {
            link.setNext(first);
            first = link;
            return;
        }

        while (current.getNext() != null && current.getNext().getData().compareTo(data) <= 0) {
            current = current.getNext();
        }

        link.setNext(current.getNext());
        current.setNext(link);

    }

    /**
     * получение значения первого элемента
     *
     * @return значение
     */
    public T getFirstData() {
        if (this.isEmpty())
            return null;
        return first.getData();
    }

    public void display() {
        System.out.println("---------------------");
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("---------------------");
    }

    public boolean isEmpty() {
        return first == null;
    }
}
