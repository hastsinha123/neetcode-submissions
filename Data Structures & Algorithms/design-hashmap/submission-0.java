class MyHashMap {

    static class Node{
        int key;
        int value;
         
        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[1009];
        for(int i=0;i<1009;i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public int hashIndex(int key){
        return key%1009;
    }
    
    public void put(int key, int value) {
        int index = hashIndex(key);
        for(Node node: buckets[index]){
            if(node.key == key){
                node.value = value;
                return;
            }
        }
        Node node = new Node(key,value);
        buckets[index].add(node);
    }
    
    public int get(int key) {
        int index = hashIndex(key);

        for(Node node: buckets[index]){
            if(node.key == key){
                return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hashIndex(key);
        Iterator<Node> it = buckets[index].iterator();
        while(it.hasNext()){
            if(it.next().key == key){
                it.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */