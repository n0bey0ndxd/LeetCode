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
    ListNode* removeElements(ListNode* head, int val) {
        if (!head){
            return nullptr;
        }
        
        while(head->val == val){
            if (head->next){
                ListNode* to_delete = head;
                head = head->next;
                delete to_delete;
            }
            else{
                return nullptr;
            }
        }
        
        ListNode* prevNode = head;
        ListNode* node = head->next;
        
        while(node){
            if (node->val == val){
                ListNode* to_delete = node;
                node = node->next;
                delete to_delete;
                prevNode->next = node;
            }
            else{
                node = node->next;
                prevNode = prevNode->next;
            }
        }
        
        return head;
    }
};