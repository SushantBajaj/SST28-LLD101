import java.util.*;

public class LRUCache implements EvictionPolicy {

    private LinkedHashSet<Integer> set;
    public LRUCache() {
        set = new LinkedHashSet<>();
    }
    @Override
    public synchronized void keyAccessed(int key) {
        if (set.contains(key)) {
            set.remove(key);
        }
        set.add(key);
    }
    @Override
    public synchronized int evictKey() {
        int oldest = set.iterator().next();
        set.remove(oldest);
        return oldest;
    }
    @Override
    public synchronized void removeKey(int key) {
        set.remove(key);
    }
}