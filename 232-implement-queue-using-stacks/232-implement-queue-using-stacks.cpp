class MyQueue {
public:
    struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
    };
    
    MyQueue() {
        head = nullptr;
        last = nullptr;
    }
    
    void push(int x) {
        if (head){
            last->next = new ListNode(x);
            last = last->next;
        }
        else{
            head = new ListNode(x);
            last = head;
        }
    }
    
    int pop() {
        ListNode* temp = head->next;
        int res = head->val;
        delete head;
        head = temp;
        return res;
    }
    
    int peek() {
        return head->val;    
    }
    
    bool empty() {
        return !head;
    }
    
private:
    ListNode* head;
    ListNode* last;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */