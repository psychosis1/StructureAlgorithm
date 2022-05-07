package structure.hashTable.linearProbing;

public class DataItem<S> {
    private final int key;
    private final S data;
    private boolean deleted = false;

    public DataItem(int key, S data) {
        this.key = key;
        this.data = data;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getKey() {
        return key;
    }

    public S getData() {
        return data;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "key=" + key +
                ", data=" + data +
                ", deleted=" + deleted +
                '}';
    }
}
