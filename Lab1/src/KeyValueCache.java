import java.util.LinkedHashMap;
import java.util.Map;

public class KeyValueCache <K, V> {
    private Map<K, V> cached = new LinkedHashMap<>();
    private int maxSize = 1;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        if (maxSize < 1)
            throw new RuntimeException();
        this.maxSize = maxSize;
    }

    public void add(K key, V value) {
        if (cached.size() == maxSize) {
            cached.entrySet().iterator().remove();
        }
        cached.put(key, value);
    }

    public boolean isCached(K key) {
        return cached.get(key) != null;
    }

    public V get(K key) {
        return cached.get(key);
    }

    public void invalidate() {
        cached.clear();
    }
}
