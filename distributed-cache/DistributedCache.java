import java.util.*;

public class DistributedCache {

    private List<CacheNode> nodes;
    private DistributionStrategy strategy;
    private Database db;
    public DistributedCache(int numNodes, int capacityPerNode, DistributionStrategy strategy) {
        this.strategy = strategy;
        this.db = new Database();
        this.nodes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new CacheNode(capacityPerNode, new LRUCache()));
        }
    }
    private CacheNode getNode(int key) {
        int index = strategy.getNode(key, nodes.size());
        return nodes.get(index);
    }

    public int get(int key) {
        CacheNode node = getNode(key);
        Integer value = node.get(key);

        if (value != null) {
            System.out.println("Cache Found");
            return value;
        }

        System.out.println("Cache Miss");
        int dbValue = db.get(key);
        if (dbValue != -1) {
            node.put(key, dbValue);
        }
        return dbValue;
    }

    public void put(int key, int value) {
        CacheNode node = getNode(key);

        node.put(key, value);
        db.put(key, value);

        System.out.println("Stored in cache and Database");
    }
}