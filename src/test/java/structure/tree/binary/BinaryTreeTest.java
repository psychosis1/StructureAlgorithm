package structure.tree.binary;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structure.tree.binary.BinaryTree;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree<Integer, String> binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();

        binaryTree.insert(60, "Первый");
        binaryTree.insert(40, "Второй");
        binaryTree.insert(30, "Третий");
        binaryTree.insert(50, "Четвертый");
    }

    @Test
    void find() {

        assertNull(binaryTree.find(36));

        assertEquals("Второй", binaryTree.find(40));
    }

    @Test
    void insert() {
        binaryTree.insert(50, "Пятый");

        assertEquals("Четвертый", binaryTree.find(50));
    }

    @Test
    @DisplayName("Удаление корневого узла. Преемник с правым потомком")
    void delete01() {
        binaryTree.insert(70,"Пятый");
        binaryTree.insert(65,"Шестой");
        binaryTree.insert(67,"Седьмой");
        binaryTree.insert(90,"Восьмой");

        assertTrue(binaryTree.delete(60));
    }

    @Test
    @DisplayName("Удаление корневого узла. Преемник правый")
    void delete02() {
        binaryTree.insert(70,"Пятый");
        binaryTree.insert(90,"Восьмой");

        assertTrue(binaryTree.delete(60));
    }

    @Test
    @DisplayName("Удаление корневого узла. Преемник без потомков")
    void delete03() {
        binaryTree.insert(70,"Пятый");
        binaryTree.insert(65,"Шестой");
        binaryTree.insert(90,"Восьмой");

        assertTrue(binaryTree.delete(60));
    }

    @Test
    @DisplayName("Удаление корневого узла. Один потомок")
    void delete04() {
        assertTrue(binaryTree.delete(60));
    }

    @Test
    @DisplayName("Удаление узла без потомков")
    void delete05() {
        assertTrue(binaryTree.delete(30));
    }

    @Test
    @DisplayName("Удаление узла. Преемник без потомков")
    void delete06() {
        binaryTree.clear();

        binaryTree.insert(10,"Нулевой");
        binaryTree.insert(60, "Первый");
        binaryTree.insert(40, "Второй");
        binaryTree.insert(30, "Третий");
        binaryTree.insert(50, "Четвертый");
        binaryTree.insert(70,"Пятый");
        binaryTree.insert(65,"Шестой");
        binaryTree.insert(90,"Восьмой");

        assertTrue(binaryTree.delete(60));
    }

    @Test
    void min() {
        assertEquals("Третий", binaryTree.min());
    }


    @Test
    void startInOrder() {

        binaryTree.startInOrder();
    }
}