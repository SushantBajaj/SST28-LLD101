import java.util.*;

public class Database {

    private Map<Integer, Integer> db = new HashMap<>();
    public synchronized int get(int key) {
        return db.getOrDefault(key, -1);
    }
    public synchronized void put(int key, int value) {
        db.put(key, value);
    }
}