package structure.linkList;

public class Link<T> {
    private final T data;
    private Link<T> next;

    public Link(T data) {
        this.data = data;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public Link<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
