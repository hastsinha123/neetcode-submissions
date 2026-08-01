class MyHashSet {

    LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[1009];
        for(int i=0;i<1009;i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public int hashIndex(int key){
        return key%1009;
    }
    
    public void add(int key) {
        int index = hashIndex(key);
        if(!buckets[index].contains(key)){
            buckets[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hashIndex(key);
        if(buckets[index].contains(key)){
            buckets[index].remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = hashIndex(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */