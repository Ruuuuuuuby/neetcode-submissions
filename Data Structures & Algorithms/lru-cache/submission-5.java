class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        private Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            if(cache.size() >= capacity){
                removeLRU();
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }

        
    }
    private void moveToHead(Node node){
        removeNode(node);//remove from original spot
        addToHead(node);//add to the head

    }

    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;//先改next的值
        node.next.prev = node.prev;
    }

    private void removeLRU(){
        Node lru = tail.prev;
        cache.remove(lru.key);
        removeNode(lru);//head.next == no.1, tail.prev == no.last
    }
}
