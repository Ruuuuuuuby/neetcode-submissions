class LRUCache {
    //双向链表头尾记录最常用最不常用
    class Node{
        int key;
        int value;

        Node next;//无参数类型
        Node prev;

        //两个参数类型
        public Node(int key, int value){//int k 要声明是int！！
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);            
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);//每次put都要记得movetohead
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);//add
            if(map.size() > capacity){//检查capacity
                Node toRemove = tail.prev;//tail是tail后面的dummy其实，移除末尾最不常用的
                removeNode(toRemove);//先remove node 再remove 整个map.entry
                map.remove(toRemove.key);
            }
        }
    }
    
    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);//记得更新到head
            return node.value;
        }else{
            return -1;
        }
        
    }

    public void addToHead(Node node){
        Node next = head.next;//tail作为dummy存在所以不怕没有next
        //next其实是真正的head
        node.prev = head;
        node.next = next;
        //先处理node的prev，next
        next.prev = node;
        head.next = node;
        //再处理next的prev和next
    }

    public void moveToHead(Node node){//一定要先remove再add不然链表混乱
        removeNode(node);
        addToHead(node);

    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

