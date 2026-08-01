class MyHashSet {

    ArrayList<Integer> arr;

    public MyHashSet() {
        arr = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!arr.contains(key)){
            arr.add(key);
        }
    }
    
    public void remove(int key) {
        if(arr.contains(key)){
            int index = arr.indexOf(key);
           arr.remove(index);
        }
    }
    
    public boolean contains(int key) {
        return arr.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */