Distributed Cache – Explanation

1.  Data Distribution Across Nodes Data is distributed across multiple
    cache nodes using a pluggable distribution strategy. In the current
    implementation, a modulo-based strategy is used where the node is
    selected using:

    node = key % numberOfNodes

This ensures that each key consistently maps to the same node. The
design keeps this logic abstracted behind a DistributionStrategy
interface, allowing replacement with more advanced strategies such as
consistent hashing without impacting other components.

2.  Cache Miss Handling When a get(key) request is made, the system
    first determines the appropriate node and checks if the key exists
    in that node’s cache.

- If present, the value is returned directly (cache hit).
- If absent, the system fetches the value from the database, stores it
  in the cache, and then returns it.

This follows a read-through caching approach. One implication of this
design is that evicted data may be reloaded into the cache upon access.

3.  Eviction Mechanism Each cache node has a fixed capacity. When this
    capacity is exceeded, an eviction policy determines which entry
    should be removed.

The current implementation uses LRU (Least Recently Used): - Every
access updates the recency of the key. - When eviction is required, the
least recently used key is removed.

Eviction is handled independently at the node level, not globally across
the entire distributed cache.

4.  Extensibility of Design The system is designed to be extensible by
    abstracting key decisions into interfaces:

- DistributionStrategy → controls how keys are mapped to nodes
- EvictionPolicy → controls how entries are evicted

This allows easy substitution of implementations. For example: -
Modulo-based distribution can be replaced with consistent hashing - LRU
can be replaced with LFU or MRU

Since these behaviors are decoupled from the core cache logic, new
strategies can be introduced without modifying existing classes.
