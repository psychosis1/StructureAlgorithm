package structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdArrayTest {

    private OrdArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new OrdArray<>(Integer.class, 5);

        array.insert(1);
        array.insert(5);
        array.insert(4);
        array.insert(3);
        array.insert(2);
    }

    @Test
    void delete() {
        var expectedArray = new Integer[]{1, 2, 3, 5, null};
        array.delete(4);
        assertArrayEquals(expectedArray, array.getMassive());
    }

    @Test
    void find() {
        assertEquals(3, array.getMassive()[array.find(3)]);
    }

    @Test
    void findRecurs() {
        assertEquals(5, array.getMassive()[array.findRecurs(5, 0, 4)]);
    }
}