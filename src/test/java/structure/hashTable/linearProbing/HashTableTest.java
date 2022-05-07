package structure.hashTable.linearProbing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashTableTest {

    private HashTable<String> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>(15);

        hashTable.insert(1, "one");
        hashTable.insert(10, "two");
        hashTable.insert(99, "ninety-nine");
        hashTable.insert(189, "one hundred eighty-nine");
        hashTable.insert(1000, "one thousand");
    }

    @Test
    void find() {

        assertEquals("one hundred eighty-nine",hashTable.find(189));

        hashTable.delete(1000);
        assertNull(hashTable.find(1000));
    }

    @Test
    void delete() {
        assertEquals("one", hashTable.delete(1));
    }

    @Test
    void increaseArraySize() {
        hashTable.increaseArraySize();
    }
}