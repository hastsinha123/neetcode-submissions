class LFUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.prev = null;
            this.next = null;
        }
    }

    class Lfu{
        Node head;
        Node tail;
        int size;
        HashMap<Integer, Node> map;

        public Lfu(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
            map = new HashMap<>();
        }

        public void addNode(Node node){
            int key= node.key;
            if(map.containsKey(key)){
                Node oldNode = map.get(key);
                map.remove(key);
                deleteNode(oldNode);
            }

            map.put(key, node);
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            this.size = map.size();
            nodeMap.put(key, node);
        }

        public void deleteNode(Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            map.remove(node.key);
            nodeMap.remove(node.key);
            this.size = map.size();
        }
    }

    HashMap<Integer, Lfu> freqMap;
    HashMap<Integer, Integer> keyMap;
    HashMap<Integer, Node> nodeMap;
    int minFreq;
    int length;

    public LFUCache(int capacity) {
        this.length = capacity;
        minFreq = 0;
        freqMap = new HashMap<>();
        keyMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        Node node = nodeMap.get(key);
        int freq = keyMap.get(key);
        Lfu lru = freqMap.get(freq);
        lru.deleteNode(node);
        int newFreq = freq+1;
        if(lru.size == 0){
            minFreq = newFreq;
        }
        
        if(!freqMap.containsKey(newFreq)){
            freqMap.put(newFreq, new Lfu());
        }
        
        Lfu list = freqMap.get(newFreq);
        list.addNode(node);
        keyMap.put(key,newFreq);

        return node.value;
    }
    
    public void put(int key, int value) {
       
        if(keyMap.containsKey(key)){ 
            int freq = keyMap.get(key);
            Lfu currList = freqMap.get(freq);
            int newFreq = freq+1;
            Node node = nodeMap.get(key);
            currList.deleteNode(nodeMap.get(key));
            node.value = value;
            
            if(currList.size == 0){
                minFreq = newFreq;
            }
            
            if(!freqMap.containsKey(newFreq)){
                freqMap.put(newFreq, new Lfu());
            }
            Lfu newList = freqMap.get(newFreq);
            newList.addNode(node);
            keyMap.put(key, newFreq);
        } else {
            if(nodeMap.size() == length){
                Lfu eList = freqMap.get(minFreq);
                keyMap.remove(eList.tail.prev.key);
                eList.deleteNode(eList.tail.prev);
            }
            Node node = new Node(key, value);

            if(!freqMap.containsKey(1)){
                freqMap.put(1,new Lfu());
            }
            Lfu lru = freqMap.get(1);
            lru.addNode(node);
            keyMap.put(key, 1);
            minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */