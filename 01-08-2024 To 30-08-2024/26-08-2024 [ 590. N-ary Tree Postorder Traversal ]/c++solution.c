class Solution {
private:
    void helper(Node * n,vector<int> &res){
        if(n == NULL) return;
        for(auto c : n->children){
            helper(c,res);
        }
        res.push_back(n->val);
    }
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        helper(root,res);
        return res;
    }
};
