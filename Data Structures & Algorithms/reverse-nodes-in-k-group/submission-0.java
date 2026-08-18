/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head== null || head.next == null){
            return head;
        }
        return reverseList(head,k);
        
    }

    public ListNode reverseList(ListNode head, int k){
        ListNode cur = head;
        int count = 0;
        while(count < k){
            if(cur != null){
                cur =cur.next;
                count++;
            } else {
                return head;
            }
        }
        ListNode prevNode = reverseList(cur,k);
        count = 0;
        cur = head;
        ListNode prev = cur;
        while(count < k){
            ListNode newNode = prev.next;
            prev.next = prevNode;
            prevNode = prev;
            prev = newNode;
            count++;
        }
        head = prevNode;
        return head;
    }
}
