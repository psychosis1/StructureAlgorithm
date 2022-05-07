package structure.tree.tree234;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.tree.tree234.Tree234;

import static org.junit.jupiter.api.Assertions.*;

class Tree234Test {

    private Tree234 tree234;

    @BeforeEach
    void setUp() {
        tree234 = new Tree234();
    }

    @Test
    void find() {
        tree234.insert(70, "1");
        tree234.insert(50, "2");
        tree234.insert(30, "3");
        tree234.insert(40, "4");
        tree234.insert(20, "5");
        tree234.insert(80, "6");
        tree234.insert(25, "7");
        tree234.insert(90, "8");
        tree234.insert(75, "9");
        tree234.insert(10, "10");

        assertEquals("6", tree234.find(80));
    }
}