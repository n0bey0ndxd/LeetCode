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
    ListNode* reverseList(ListNode* head) {
        ListNode* new_head = head;
        ListNode* tail = nullptr;
        ListNode* temp = nullptr;
        if (!head) {
            return head;
        }

        while (head->next) {
            new_head = head->next;
            temp = head;
            temp->next = tail;
            tail = temp;
            head = new_head;
        }
        
        new_head->next = tail;
        return new_head;
    }
};