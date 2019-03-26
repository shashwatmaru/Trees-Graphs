/*
@author Shashwat Maru
Date: 03/26/2019
Closest Binary Search Tree Value
  Go to Discuss
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 */

public class ClosestBSTValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int closestValue(TreeNode root, double target) {
            int value = root.val;

            while(root != null){
                if(Math.abs(target - root.val) < Math.abs(target - value)){
                    value = root.val;
                }
                root = root.val > target ? root.left: root.right;
            }
            return value;

    }
    public static void main(String[] args){
        //TEST CASE 1:
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println("TEST CASE1: "+ closestValue(root, 3.56666666666));

    }
}

