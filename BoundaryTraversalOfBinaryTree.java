import java.util.HashSet;
import java.util.Set;

public class BoundaryTraversalOfBinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }

    /*
    It has 3 methods, one to print the left boundary, one to print the right boundary and one to print the leaves.
    Only we need to make sure than nodes do not repeat while printing.
     */
    public void printBoundaryNodes(TreeNode root, Set<TreeNode> set){

        if(root != null){
  //          set.add(root);
            printLeftBoundary(root, set);
            printLeaves(root, set);

//            set.add(root.right);
            printRightBoundary(root.right, set);
        }
    }

    public void printLeftBoundary(TreeNode root, Set<TreeNode> set){
        if(root!= null){

            if(root.left != null){
                set.add(root.left);
                System.out.print(root.val+" ");
                printLeftBoundary(root.left,set);
            }
            else if(root.right != null){
                set.add(root.right);
                System.out.print(root.val+" ");
                printLeftBoundary(root.right,set);
            }
        }
    }

    public void printRightBoundary(TreeNode root, Set<TreeNode> set){
        if(root != null){

            if(root.right != null){
                set.add(root.right);
                System.out.print(root.val+" ");
                printRightBoundary(root.right,set);
            }
            else if(root.left != null){
                set.add(root.left);
                System.out.print(root.val+" ");
                printRightBoundary(root.left,set);
            }
        }
    }

    public void printLeaves(TreeNode root, Set<TreeNode> set){
        if(root != null){
            printLeaves(root.left,set);
            if(root.left == null && root.right == null){
                System.out.print(root.val+" ");
                set.add(root);
            }
            printLeaves(root.right,set);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.left.left = new TreeNode(13);
        root.left.left.left.right = new TreeNode(14);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.left.left = new TreeNode(15);
        root.right.left.left.right = new TreeNode(16);
        root.right.left.right = new TreeNode(11);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(12);
        root.right.right.right.left = new TreeNode(17);
        root.right.right.right.right = new TreeNode(18);

        Set<TreeNode> set = new HashSet<>();
        BoundaryTraversalOfBinaryTree boundaryTraversalOfBinaryTree = new BoundaryTraversalOfBinaryTree();
        boundaryTraversalOfBinaryTree.printBoundaryNodes(root,set);
    }

}
