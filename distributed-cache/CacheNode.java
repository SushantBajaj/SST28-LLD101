import java.util.*;

public class CacheNode {

    private int capacity;
    private Map<Integer, Integer> cache;
    private EvictionPolicy policy;

    public CacheNode(int capacity, EvictionPolicy policy) {
        this.capacity = capacity;
        this.policy = policy;
        this.cache = new HashMap<>();
    }
    public synchronized Integer get(int key) {
        if (!cache.containsKey(key)) return null;

        policy.keyAccessed(key);
        return cache.get(key);
    }
    public synchronized void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            policy.keyAccessed(key);
            return;
        }

        if (cache.size() >= capacity) {
            int evict = policy.evictKey();
            cache.remove(evict);
        }

        cache.put(key, value);
        policy.keyAccessed(key);
    }
}