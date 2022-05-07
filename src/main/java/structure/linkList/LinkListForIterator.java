package structure.linkList;

public class LinkListForIterator<T> {
    private Link<T> first;

    public ListIterator<T> getIterator() {
        return new ListIterator<T>(this);
    }

    public Link<T> getFirst() {
        return first;
    }

    public void setFirst(Link<T> first) {
        this.first = first;
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
