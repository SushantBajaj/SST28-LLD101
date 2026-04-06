public class Main {
    public static void main(String[] args) {

        DistributedCache cache =
        new DistributedCache(3, 2, new ModuloStrategy());

        cache.put(1, 100); // node 1
        cache.put(4, 400); // node 1

        System.out.println(cache.get(1)); // should be found and make 1 recent

        cache.put(7, 700); // node 1 should evict 4
        
        System.out.println(cache.get(4)); // should be miss, and adds 4 back into node 1, which evicts 1
        System.out.println(cache.get(4)); // should be found
        System.out.println(cache.get(1)); // should be miss
    }
}