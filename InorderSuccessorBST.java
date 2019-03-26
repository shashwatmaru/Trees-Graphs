/*
Inorder Successor in BST
  Go to Discuss
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.



Example 1:


Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.


Note:

If the given node has no in-order successor in the tree, return null.
It's guaranteed that the values of the tree are unique.
 */

public class InorderSuccessorBST {

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            TreeNode node = root;
            TreeNode result = null;
            //Condition 1: First condition if the target node has left subtree, Here inorder sucessor would be the lowest node ( w.r.t value) in the right    //subtree.
            if(p.right != null){
                TreeNode temp = p.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                return temp;
            }

            //Condition 2: If target node has no right subtree, then the inorder successor will be the first greater value over it, or greater parent or
            // if we go first right from target ( go upwards from target) or in other words the latest left turn taken if we traverse from root  //towards the target node.
            while(node.val != p.val){
                if(node.val >= p.val){
                    result = node;
                    node = node.left;
                }
                else{
                    node = node.right;
                }
            }
            return result;

        }

        public  static void main(String [] args){
            //TEST CASE 1:
            TreeNode root = new TreeNode(5);
            TreeNode node1 = new TreeNode(3);
            TreeNode node2 = new TreeNode(6);
            TreeNode node3 = new TreeNode(2);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(1);
            root.left = node1;
            root.right = node2;
            node1.left = node3;
            node1.right = node4;
            node3.left = node5;
            TreeNode result1 = inorderSuccessor(root, node2);
            if(result1 != null)
                System.out.println("TEST CASE1: "+ result1.val);
            else
                System.out.println("Test Case1: "+result1);

            //TESTCASE 2
            TreeNode root1 = new TreeNode(2);
            TreeNode node11 = new TreeNode(1);
            TreeNode node12 = new TreeNode(3);
            root1.left = node11;
            root1.right = node12;
            TreeNode result2 = inorderSuccessor(root1, node11);
            if(result2 != null)
                System.out.println("TEST CASE2: "+ result2.val);
            else
                System.out.println("Test Case2: "+result2);

     }

}
