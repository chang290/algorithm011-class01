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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 
                || preorder.length != inorder.length) return null;

            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0; i < inorder.length ; i++){
                map.put( inorder[i], i);
            }
            return myBuild(map , preorder , inorder , 0 , preorder.length - 1 , 0 , inorder.length - 1);
        }
        
        private TreeNode myBuild(Map<Integer, Integer> map, int[] preorder, int[] inorder, 
                int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
            //结束
            if(preorderLeft > preorderRight){
                return null;
            }

            int preorderRoot = preorderLeft;
            int inorderRoot = map.get( preorder[preorderRoot] );
            //前序遍历首个节点就是根节点

            TreeNode root = new TreeNode( preorder[preorderRoot] );

            int leftSize = inorderRoot - inorderLeft;
 
            //前序遍历 preorder = [3,9,20,15,7]
            //中序遍历 inorder = [9,3,15,20,7]


            //递归构建左子树+递归
            root.left = myBuild(map, preorder, inorder, 
                preorderLeft + 1 , preorderLeft + leftSize, inorderLeft, inorderRoot - 1);

            root.right = myBuild(map, preorder, inorder, 
                preorderLeft + leftSize + 1, preorderRight, inorderRoot + 1, inorderRight);
            
            return root;
        }
}

