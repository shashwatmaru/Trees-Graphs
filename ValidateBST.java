/*
98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */

public class ValidateBST {

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
         }


        public static boolean isValidBST(TreeNode root) {

             return isValidBSTUtil(root, Long.MAX_VALUE, Long.MIN_VALUE );
        }
        private static boolean isValidBSTUtil(TreeNode root,long max, long min){
            if(root == null){
                return true;
            }


            if( root.val <= min || root.val >= max){
                return false;
            }

            return isValidBSTUtil(root.left, root.val, min) && isValidBSTUtil(root.right, max, root.val);
        }
        public static void main(String[] args){
            //TEST CASE 1:
            TreeNode root1 = new TreeNode(2);
            TreeNode node11 = new TreeNode(1);
            TreeNode node21 = new TreeNode(3);
            root1.left = node11;
            root1.right = node21;
            System.out.println("TEST CASE2: "+isValidBST(root1));

            //TESTCASE 2
            TreeNode root = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(4);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(6);
            root.left = node1;
            root.right = node2;
            node2.left = node3;
            node2.right = node4;
            System.out.println("TEST CASE2: "+isValidBST(root));
        }
}
