class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            res.add(0, temp.val); // Add node at the beginning to reverse the postorder sequence
            for (Node child : temp.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
