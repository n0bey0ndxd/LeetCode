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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* start = head;
        ListNode* prev = nullptr;
        head = nullptr;

        while (start) {
            if (start->next && start->next->val == start->val) {
                while (start->next && start->next->val == start->val) {
                    start = start->next;
                }

                if (prev) {
                    prev->next = start->next;
                }
            }
            else {
                if (!prev) {
                    head = start;
                }

                prev = start;
            }

            start = start->next;
        }

        return head;
    }   
};