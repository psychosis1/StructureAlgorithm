package structure.tree.binary;

public class Node <T,S> {
    private final T key;
    private final S data;
    private Node<T,S> left;
    private Node<T,S> right;

    public Node(T key, S data) {
        this.key = key;
        this.data = data;
    }

    public void setLeft(Node<T, S> left) {
        this.left = left;
    }

    public void setRight(Node<T, S> right) {
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public S getData() {
        return data;
    }

    public Node<T, S> getLeft() {
        return left;
    }

    public Node<T, S> getRight() {
        return right;
    }

    @Override
    public String
    toString() {
        return "Node{" +
                "key=" + key +
                ", data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
