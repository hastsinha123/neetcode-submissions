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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode ans = head;

        while(l1 != null || l2 != null){

            if(l1 != null && l2 != null){
                sum = sum + carry + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next; 
            } else if(l1 != null){
                sum = sum + carry + l1.val;
                l1 = l1.next;
            } else if(l2 != null){
                sum = sum + carry + l2.val;
                l2 = l2.next;
            }
            int rem = sum%10;
            carry = sum/10;

            ListNode node = new ListNode(rem);
            ans.next = node;
            ans = ans.next;
            sum = 0;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            ans.next = node;
            ans = ans.next;
        }
        return head.next;
        
    }
}
