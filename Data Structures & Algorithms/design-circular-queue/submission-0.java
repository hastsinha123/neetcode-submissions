class MyCircularQueue {

    static class Node{
        Node next;
        int val;

        public Node(int data){
            this.val = data;
            this.next = null;
        }
    }

    Node rear = null;
    Node front = null;
    int count = 0;
    int size = 0;

    public MyCircularQueue(int k) {
        this.size = k;
    }
    
    public boolean enQueue(int value) {
        Node newNode = new Node(value);
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            rear = newNode;
            front = newNode;
            rear.next = front;
        } else {
            newNode.next = front;
            rear.next = newNode;
            rear = newNode;
        }
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        if(count == 1){
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        count--;
        return true;
    }
    
    public int Front() {
        if(count == 0){
            return -1;
        }
        return front.val;
        
    }
    
    public int Rear() {
        if(count == 0){
            return -1;
        }
        return rear.val;
        
    }
    
    public boolean isEmpty() {
        return count == 0;
        
    }
    
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */