package structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayTest {

    private Array<Integer> array;

    private Integer[] expectedArray;

    @BeforeEach
    void setUp() {
        var size = 10;
        array = new Array<>(Integer.class, size);

        array.insert(10);
        array.insert(8);
        array.insert(89);
        array.insert(3);
        array.insert(1);
        array.insert(67);
        array.insert(2);
        array.insert(19);
        array.insert(6);
        array.insert(11);

        expectedArray = Arrays.stream(array.getMassive()).sorted().toArray(Integer[]::new);
    }

    @Test
    void bubbleSort() {
        array.bubbleSort();

        assertArrayEquals(expectedArray, array.getMassive());
    }

    @Test
    void selectSort() {
        array.selectSort();

        assertArrayEquals(expectedArray, array.getMassive());
    }

    @Test
    void mergeSort() {
        array.mergeSort();

        assertArrayEquals(expectedArray, array.getMassive());
    }
}