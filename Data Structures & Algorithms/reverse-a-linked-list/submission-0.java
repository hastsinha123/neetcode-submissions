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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur!=null){
            ListNode newNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = newNode;
        }

        return prev;
        
    }
}
