package structure.linkList.doubleLinkList;

public class DoubleLinkList<T> {
    private Link<T> first;
    private Link<T> last;

    /**
     * вставка в начало
     *
     * @param data данные
     */
    public void insertFirst(T data) {
        Link<T> link = new Link<>(data);
        if (!this.isEmpty()) {
            first.setPrevious(link);
            link.setNext(first);
        } else {
            last = link;
        }
        first = link;
    }

    /**
     * вставка в конец
     *
     * @param data данные
     */
    public void insertLast(T data) {
        Link<T> link = new Link<>(data);
        if (!this.isEmpty()) {
            last.setNext(link);
            link.setPrevious(last);
        } else {
            first = link;
        }
        last = link;
    }

    /**
     * вставка после элемента
     */
    public void insertAfter(T findData, T afterData) {
        Link<T> after = new Link<>(afterData);

        if (last.getData().equals(findData)) {
            insertLast(afterData);
            return;
        }

        Link<T> current = first;

        while (!current.getData().equals(findData)) {
            current = current.getNext();
        }

        after.setPrevious(current);
        after.setNext(current.getNext());

        current.getNext().setPrevious(after);
        current.setNext(after);
    }

    /**
     * удаление первого элемента
     *
     * @return удаленный элемент
     */
    public T deleteFirst() {
        if (this.isEmpty())
            return null;
        Link<T> deleted = first;
        first = deleted.getNext();
        if (first == null)
            last = null;
        else first.setPrevious(null);
        return deleted.getData();
    }

    /**
     * удаление последнего элемента
     *
     * @return удаленный элемент
     */
    public T deleteLast() {
        if (this.isEmpty())
            return null;
        Link<T> deleted = last;
        last = deleted.getPrevious();
        if (last == null)
            first = null;
        else last.setNext(null);
        return deleted.getData();
    }

    public T deleteKey(T data) {
        Link<T> current = first;
        if (current != null) {
            if (current.getData().equals(data)) {
                deleteFirst();
                return current.getData();
            }
        }

        Link<T> lastEl = last;
        if (lastEl != null) {
            if (lastEl.getData().equals(data)) {
                deleteLast();
                return lastEl.getData();
            }
        }

        while (current != null) {
            if (current.getData().equals(data)) {
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * отображение от начала к концу
     */
    public void displayForward() {
        System.out.println("---------------------");
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("---------------------");
    }

    /**
     * отображение от конца к началу
     */
    public void displayBackward() {
        System.out.println("---------------------");
        Link<T> current = last;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrevious();
        }
        System.out.println("---------------------");
    }

}
