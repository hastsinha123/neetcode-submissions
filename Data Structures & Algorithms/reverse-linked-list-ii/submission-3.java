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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        for(int i =1;i < left;i++){
            prev = cur;
            cur = cur.next;
        }

        ListNode firstPivot = cur;


        int count = (right-left+1);
        ListNode prev2 = null;
        for(int i= 0;i< count;i++){
            ListNode newNode = cur.next;
            cur.next = prev2;
            prev2 = cur;
            cur = newNode;
        }

        ListNode secondPivot = cur;

        prev.next = prev2;
        firstPivot.next = secondPivot;
      
        return dummy.next;
        
    }
}