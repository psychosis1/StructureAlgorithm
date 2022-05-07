package structure.linkList.doubleLinkList;

public class Link<T> {
    private final T data;
    private Link<T> next;
    private Link<T> previous;

    public Link(T data) {
        this.data = data;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public Link<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Link<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }
}
