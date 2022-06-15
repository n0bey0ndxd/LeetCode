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
        if (head == null){
            return null;
        }
        
        if (head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode n_hd = reverseList(head.next);
        ListNode end = n_hd;

        while(end.next != null){
            end = end.next;
        }

        end.next = temp;
        temp.next = null;

        return n_hd;
    }
}