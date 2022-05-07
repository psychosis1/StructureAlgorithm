package structure.linkList;

public class ListIterator<T> {
    private Link<T> current;
    private Link<T> previous;
    private final LinkListForIterator<T> linkList;

    public ListIterator(LinkListForIterator<T> linkList) {
        this.linkList = linkList;
    }

    public void reset() {
        current = linkList.getFirst();
        previous = null;
    }

    public Link<T> getCurrent() {
        return current;
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public boolean atEnd() {
        return current.getNext() == null;
    }

    public void insertAfter(T data) {
        Link<T> link = new Link<>(data);
        if (!linkList.isEmpty()) {
            link.setNext(current.getNext());
            current.setNext(link);
            nextLink();
        } else {
            linkList.setFirst(link);
            current = link;
        }
    }

    public void insertBefore(T data) {
        Link<T> link = new Link<>(data);
        if (previous != null) {
            previous.setNext(link);
            link.setNext(current);
            current = link;
        } else {
            link.setNext(linkList.getFirst());
            linkList.setFirst(link);
            reset();
        }
    }

    public T deleteCurrent() {
        if (previous != null) {
            previous.setNext(current.getNext());
            if (atEnd()) reset();
            else current = previous;
        }else {
            linkList.setFirst(current.getNext());
            reset();
        }
        return current.getData();
    }
}
