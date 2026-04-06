public interface EvictionPolicy {
    void keyAccessed(int key);
    int evictKey();
    void removeKey(int key);
}