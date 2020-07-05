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
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.isEmpty() == false){
            TreeNode node = stack.pop();
            if(node != null){
                list.add(node.val);

                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(WHITE,root));
        while(stack.isEmpty() == false){
            ColorNode cnode = stack.pop();
            if(cnode.node != null){
                if(cnode.color == WHITE){
                    //因为是中序遍历，考虑栈的特性，需要先入右节点最后左节点
                    stack.push(new ColorNode(WHITE,cnode.node.right));
                    stack.push(new ColorNode(WHITE,cnode.node.left));   
                    stack.push(new ColorNode(GRAY,cnode.node));
               }else{
                    list.add(cnode.node.val);
                }
            }
        }
        return list;  
    }   
}
