/*
@Author: Shashwat Maru
Problem statement: To find the height of the tree or MAxDepth of the tree using recursion method.
 */
public class MaxDepthInTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

    }

    public int findMaxDepth(TreeNode root){
        if(root == null) return 0;
        int depth;
        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        if(left>right){
            depth = 1 + left;
        }
        else{
            depth= 1+ right;
        }
        return depth;
    }

    public static void main(String[] args){
        MaxDepthInTree maxDepthInTree = new MaxDepthInTree();
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
        System.out.println("Depth of the given tree: "+maxDepthInTree.findMaxDepth(root));


    }


}
