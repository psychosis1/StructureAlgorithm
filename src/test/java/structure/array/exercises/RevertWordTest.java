package structure.array.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevertWordTest {

    @Test
    void revert() {
        var revert = new RevertWord("Day dreams");
        assertEquals("smaerd yaD", revert.revert());
    }
}