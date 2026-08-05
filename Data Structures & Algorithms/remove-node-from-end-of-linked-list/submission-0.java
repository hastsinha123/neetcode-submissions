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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode first = dummy;
        while(n > 0 && cur.next!= null){
            cur = cur.next;
            n--;
        }

        while(cur.next!=null){
            first = first.next;
            cur = cur.next;
        }
        ListNode temp = first.next;
        first.next = temp.next;
        return dummy.next;


    }
}
