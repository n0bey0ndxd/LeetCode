/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        int counter = 1u;
        ListNode* mid_node = head;
        
        ListNode* node = head->next;
        if (!node){
            return mid_node;
        }
        
        while(node){
            counter++;
            
            if(counter % 2 == 0){
                mid_node = mid_node->next;
            }
            
            node = node->next;
        }
        
        return mid_node;
    }
};