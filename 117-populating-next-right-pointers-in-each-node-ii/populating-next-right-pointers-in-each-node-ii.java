/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> dq = new LinkedList<>();
        dq.addFirst(root);
        Node last = root,temp;
        while(!dq.isEmpty()){
            temp = dq.pollFirst();
            if(temp.left!=null) dq.addLast(temp.left);
            if(temp.right!=null) dq.addLast(temp.right);
            if(temp==last){
                last = dq.peekLast();
                Node prev = null;
                for(Node i:dq){
                    if(prev==null){
                        prev=i;
                    }else{
                        prev.next = i;
                        prev =i;
                    }
                }
            }
        }
        return root;
    }
}