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
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        
        if (head.next != null){
            ListNode hd = head.next;
            ListNode nx = head;
            ListNode nxR = head.next.next;
            
            head = hd;
            head.next = nx;
            head.next.next = swapPairs(nxR);
        }

        return head;
    }
}
