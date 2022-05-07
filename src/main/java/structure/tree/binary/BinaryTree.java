package structure.tree.binary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryTree<T extends Comparable<T>, S> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTree.class);

    private Node<T, S> root;

    public S find(T key) {
        if (root == null) {
            return null;
        }

        var currentNode = root;
        while (currentNode.getKey() != key) {
            if (key.compareTo(currentNode.getKey()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.getData();
    }

    public void insert(T key, S data) {
        var newNode = new Node<>(key, data);

        if (root == null) {
            root = newNode;
            return;
        }

        var currentNode = root;
        while (true) {
            final Node<T, S> currentLeftOrRight;
            if (key.compareTo(currentNode.getKey()) < 0) {
                currentLeftOrRight = currentNode.getLeft();
                if (currentLeftOrRight == null) {
                    currentNode.setLeft(newNode);
                    return;
                }
            } else {
                currentLeftOrRight = currentNode.getRight();
                if (currentLeftOrRight == null) {
                    currentNode.setRight(newNode);
                    return;
                }
            }
            currentNode = currentLeftOrRight;
        }
    }

    public boolean delete(T key) {
        if (root == null) {
            return false;
        }

        // нахождение удаляемого узла
        var currentNode = root;
        Node<T, S> parent = null;
        while (currentNode.getKey() != key) {
            parent = currentNode;
            if (key.compareTo(currentNode.getKey()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }

            if (currentNode == null) {
                return false;
            }
        }

        // нет потомков
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (parent == null) {
                root = null;
                return true;
            }

            if (parent.getLeft() == currentNode) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }

        // есть один потомок
        if (currentNode.getLeft() == null ^ currentNode.getRight() == null) {
            Node<T, S> child = currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight();

            if (parent == null) {
                this.root = child;
                return true;
            }

            if (parent.getLeft() == currentNode) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            return true;
        }

        // есть оба потомка
        var successor = getSuccessor(currentNode);
        successor.setLeft(currentNode.getLeft());
        if (currentNode.getRight() != successor) {
            successor.setRight(currentNode.getRight());
        }

        if (parent == null) {
            root = successor;
            return true;
        }

        if (parent.getLeft() == currentNode) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }
        return true;
    }

    /**
     * получение преемника
     * @param deletedNode удаляемый узел
     * @return преемник
     */
    private Node<T, S> getSuccessor(Node<T, S> deletedNode) {
        Node<T, S> rightNode = deletedNode.getRight();

        // преемник правый
        if (rightNode.getLeft() == null) {
            return rightNode;
        }

        // нахождение минимума по правой ветке
        var currentNode = rightNode;
        Node<T, S> parent = null;
        while (currentNode.getLeft() != null) {
            parent = currentNode;
            currentNode = currentNode.getLeft();
        }

        // приемник без потомков
        if (currentNode.getRight() == null) {
            parent.setLeft(null);
            return currentNode;
        }

        // преемник с правым потомком
        parent.setLeft(currentNode.getRight());
        return currentNode;
    }

    public S min() {
        if (root == null) {
            return null;
        }

        var currentNode = root;

        while (true) {
            if (currentNode.getLeft() == null) {
                return currentNode.getData();
            } else {
                currentNode = currentNode.getLeft();
            }
        }
    }

    /**
     * симметричный обход
     */
    public void startInOrder() {
        inOrder(root);
    }


    private void inOrder(Node<T, S> node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        LOGGER.info("Node: {}", node.getData());
        inOrder(node.getRight());
    }

    public void clear() {
        root = null;
    }
}
