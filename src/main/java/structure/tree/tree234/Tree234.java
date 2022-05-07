package structure.tree.tree234;

public class Tree234 {

    private Node root;

    public String find(int key) {
        if (root == null) {
            return null;
        }

        var currentNode = root;
        while (true) {
            var foundData = currentNode.findElement(key);
            if (foundData != null) {
                return foundData.value();
            }

            if (currentNode.isLeaf()) {
                return null;
            }
            currentNode = getNextNode(currentNode, key);
        }
    }

    private Node getNextNode(Node currentNode, int key) {
        int numberElements = currentNode.getNumberElements();

        for (int i = 0; i < numberElements; i++) {
            if (key < currentNode.getElement(i).key()) {
                return currentNode.getChild(i);
            }
        }
        return currentNode.getChild(numberElements);
    }

    public void insert(int key, String value) {
        var data = new DataItem(key, value);

        if (root == null) {
            root = new Node();
            root.insertElement(data);
            return;
        }

        var currentNode = root;
        Node parent = null;
        while (true) {
            if (currentNode.isFull()) {
                currentNode = split(currentNode, parent);
            } else if (currentNode.isLeaf()) {
                break;
            } else {
                parent = currentNode;
                currentNode = getNextNode(currentNode, key);
            }
        }

        currentNode.insertElement(data);
    }

    private Node split(Node node, Node parent) {
        DataItem middleData, rightData;
        Node child3, child4;

        rightData = node.removeBiggestElement();
        middleData = node.removeBiggestElement();

        child3 = node.disconnectChild(2);
        child4 = node.disconnectChild(3);

        var rightNode = new Node();
        rightNode.insertElement(rightData);

        // корневой узел
        if (parent == null) {
            root = new Node();

            root.connectChild(0, node);
            parent = root;
        }

        var itemIndex = parent.insertElement(middleData);

        for (int i = parent.getNumberElements() - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        parent.connectChild(itemIndex + 1, rightNode);

        // не лист
        if (!node.isLeaf()) {
            rightNode.connectChild(0, child3);
            rightNode.connectChild(1, child4);
        }

        return parent;
    }
}
