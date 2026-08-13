class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        head= new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int ans = node.value;
            deleteNode(node);
            map.remove(key);
            map.put(key,node);
            addNode(node);
            return ans;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        } else if(!map.isEmpty() && map.size() == this.size ){
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }

       

        map.put(key, newNode);
        addNode(newNode);
    }

    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addNode(Node node){
        Node nextNode = head.next;
        node.prev = head;
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
    }
}
