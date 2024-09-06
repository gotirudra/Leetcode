class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int>s;
        for(auto x:nums) s.insert(x);
        ListNode* newHead= new ListNode(-1);
        ListNode* temp=newHead;
        while(head){
            if(s.count(head->val)==0){
                newHead->next=new ListNode(head->val);
                newHead=newHead->next;
            }
            head=head->next;
        }
        return temp->next;
    }
};
