public class ModuloStrategy implements DistributionStrategy {
    @Override
    public int getNode(int key, int numNodes) {
        return key % numNodes;
    }
}