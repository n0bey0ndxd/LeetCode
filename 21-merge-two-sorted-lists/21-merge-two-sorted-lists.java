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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        
        if (list2 == null){
            return list1;
        }
        
        ListNode next = null;
        
        if (list1.val < list2.val){
            next = list1;
            next.next = mergeTwoLists(list1.next, list2);
        }
        else{
            next = list2;
            next.next = mergeTwoLists(list1, list2.next);
        }
        
        return next;
    }
}