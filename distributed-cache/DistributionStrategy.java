public interface DistributionStrategy {
    int getNode(int key, int numNodes);
}