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
        Set<ListNode> sA = new HashSet<>();
        Set<ListNode> sB = new HashSet<>();

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != null || nodeB != null){
            if (nodeA != null){
                sA.add(nodeA);
                if (sB.contains(nodeA)){
                    return nodeA;
                }

                nodeA = nodeA.next;
            }

            if (nodeB != null){
                sB.add(nodeB);
                if (sA.contains(nodeB)){
                    return nodeB;
                }

                nodeB = nodeB.next;
            }
        }

        return null;
    }
}