/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>();
        
        ListNode node = headA;
        
        while (node != null){
            s.add(node);
            node = node.next;
        }
        
        node = headB;
        while(node != null){
            if (s.contains(node)){
                return node;
            }
            
            node = node.next;
        }
        
        return null;
    }
}