package structure.tree.tree234;

import java.util.Arrays;

public class Node {

    private final DataItem[] elements = new DataItem[3];
    private final Node[] children = new Node[4];

    private int numberElements;

    public DataItem findElement(int key) {
        for (DataItem element : elements) {
            if (element == null) {
                return null;
            }
            if (element.key() == key) {
                return element;
            }
        }
        return null;
    }

    public int insertElement(DataItem element) {
        if (numberElements == elements.length) {
            return -1;
        }

        numberElements++;

        for (int i = elements.length - 2; i >= 0; i--) {
            if (elements[i] == null) {
                continue;
            }

            if (elements[i].key() > element.key()) {
                elements[i + 1] = elements[i];
            } else {
                elements[i + 1] = element;
                return i + 1;
            }
        }

        elements[0] = element;
        return 0;
    }

    public DataItem removeBiggestElement() {
        var temp = elements[numberElements - 1];
        elements[numberElements - 1] = null;
        numberElements--;
        return temp;
    }

    public int getNumberElements() {
        return numberElements;
    }

    public DataItem getElement(int index) {
        return elements[index];
    }

    public Node getChild(int index) {
        return children[index];
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return elements[elements.length - 1] != null;
    }

    public Node disconnectChild(int index) {
        var temp = children[index];
        children[index] = null;
        return temp;
    }

    public void connectChild(int index, Node child) {
        children[index] = child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "elements=" + Arrays.toString(elements) +
                ", children=" + Arrays.toString(children) +
                ", numberElements=" + numberElements +
                '}';
    }
}
