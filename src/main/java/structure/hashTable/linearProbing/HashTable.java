package structure.hashTable.linearProbing;

/**
 * Хеш-таблица с линейным пробированием
 *
 * @param <S> данные
 */
public class HashTable<S> {
    DataItem<S>[] hashArray;
    int arraySize;

    public HashTable(int arraySize) {
        this.hashArray = new DataItem[arraySize];
        this.arraySize = arraySize;
    }

    private int hash(int key) {
        return key % arraySize;
    }

    public S find(int key) {
        var index = hash(key);

        while (hashArray[index] != null) {
            if (hashArray[index].getKey() == key) {
                if (hashArray[index].isDeleted()) {
                    return null;
                } else {
                    return hashArray[index].getData();
                }
            }

            index++;
            index %= arraySize;
        }

        return null;
    }

    public void insert(int key, S data) {
        var item = new DataItem<>(key, data);

        var index = hash(key);
        while (hashArray[index] != null && !hashArray[index].isDeleted()) {
            index++;
            index %= arraySize;
        }

        hashArray[index] = item;
    }

    public S delete(int key) {
        var index = hash(key);

        while (hashArray[index] != null) {
            if (hashArray[index].getKey() == key) {
                if (hashArray[index].isDeleted()) {
                    return null;
                } else {
                    var item = hashArray[index];
                    item.setDeleted(true);
                    return item.getData();
                }
            }

            index++;
            index %= arraySize;
        }
        return null;
    }

    public void increaseArraySize() {
        var newSize = arraySize * 2;
        newSize = getPrime(newSize);
        var newArray = new DataItem[newSize];

        var oldArray = hashArray;
        var oldSize = arraySize;

        hashArray = newArray;
        arraySize = newSize;

        for (int i = 0; i < oldSize; i++) {
            var item = oldArray[i];
            if (item == null || item.isDeleted()) {
                continue;
            }
            insert(item.getKey(), item.getData());
        }
    }

    private int getPrime(int size) {
        int value = size + 1;
        while (true) {
            if (isPrime(value)) {
                return value;
            }
            value++;
        }
    }

    private boolean isPrime(int value) {
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
