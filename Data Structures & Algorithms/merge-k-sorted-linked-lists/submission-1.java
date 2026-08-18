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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ){
            return null;
        }
        return divideAndMergeList(lists,0,lists.length-1);

    }

    public ListNode divideAndMergeList(ListNode[] lists,int start, int end){

        if(start == end ){
            return lists[start];
        }

        if(start == end-1){
            return mergeLists(lists[start],lists[end]);
        }

        int mid = start + (end - start) /2;
        ListNode left = divideAndMergeList(lists, start , mid);
        ListNode right = divideAndMergeList(lists, mid+1, end);
        return mergeLists(left,right);
    }

    public ListNode mergeLists(ListNode l1, ListNode l2 ) {
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while(l1 != null || l2 != null){
            if(l1!= null && l2 != null){
                if(l1.val > l2.val){
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next; 
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next; 
                }
            } else if(l1 != null){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else if(l2 != null){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        return head.next;

    }
}
