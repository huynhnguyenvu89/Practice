package Hashing;

import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    class Node {
        int key;
        int value; 
        Node next; 
        Node previous;
        public Node(int key, int value) {
            this.key = key; 
            this.value = value;
            next = null; 
            previous = null;
        }
    }
    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node left;
    private Node right;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.previous = left; 
    }
    
    public int get(int key) {
        Node res = map.get(key);
        if (res != null) {
            remove(res);
            insert(res);
            return res.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        Node newNode = new Node(key, value);
        
        if (node != null) {
            remove(node);
        }
        
        insert(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node lruNode = this.left.next;
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }

    private void remove(Node node) {
        Node next = node.next;
        Node previous = node.previous;
        next.previous = previous;
        previous.next = next;
    }

    private void insert(Node node) {
        Node previous = this.right.previous;
        this.right.previous = node; 
        previous.next = node; 
        node.previous = previous; 
        node.next = this.right; 
    }
}
