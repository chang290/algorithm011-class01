/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        order(root,list);
        return list;  
    }
    private void order(TreeNode root,List<Integer> list){
        if(root == null) return;
        order(root.left,list);
        list.add(root.val);
        order(root.right,list);
    }

    //使用一个栈的方法遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || stack.isEmpty() == false){
            //把左子树全部入栈
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }

        return list;  
    }    

   //使用一个栈的方法遍历
   static class ColorNode{
        public int color;
        public TreeNode node;
        public ColorNode(int color,TreeNode node){
            this.color = color;
            this.node = node;
        }
   }

    private int WHITE = 0;
    private int GRAY = 1;
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(WHITE,root));
        while(stack.isEmpty() == false){
            ColorNode cnode = stack.pop();
            if(cnode.node != null){
                if(cnode.color == WHITE){
                    //因为是中序遍历，考虑栈的特性，需要先入右节点最后左节点
                    stack.push(new ColorNode(WHITE,cnode.node.right));
                    stack.push(new ColorNode(GRAY,cnode.node));
                    stack.push(new ColorNode(WHITE,cnode.node.left));   
                }else{
                    list.add(cnode.node.val);
                }
            }
        }
        return list;  
    }   
}
