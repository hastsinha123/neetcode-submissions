/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur!=null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        Node cur2 = head;
        while(cur2!=null){
            Node temp = cur2.next;
            temp.random = cur2.random != null ? cur2.random.next : null;
            cur2 = cur2.next.next;
        }

        Node cur3 = head;
        Node copy = head.next;
        while(cur3 != null){
            Node temp = cur3.next;
            cur3.next = temp.next;
            temp.next = temp.next != null ? temp.next.next : null ;
            cur3 = cur3.next;
        }
        return copy;
        
    }
}
