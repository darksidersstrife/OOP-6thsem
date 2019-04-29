public class ValueCache <V> {
    private V value = null;

    public void set(V value) {
        this.value = value;
    }

    public boolean isCached() {
        return value != null;
    }

    public V get() {
        return value;
    }

    public void invalidate() {
        value = null;
    }
}
