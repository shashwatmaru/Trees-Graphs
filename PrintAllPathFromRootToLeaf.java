import java.util.Iterator;
import java.util.Stack;

public class PrintAllPathFromRootToLeaf {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }
    Stack<TreeNode> stack = new Stack<>();

    /*
    In this inorder traversal will be done, Here we will traverse left till a null node is not found (parallely we are adding
    nodes to the stack as well,
    then we will check if the current nodes right is also null.
    if current node has right node, then we will traverse in that direction recursively.

    if it is not, then we are sure that current node is a leaf,
    and we will iterate thru the stack using iterator.
    and after that we will pop the current element and go to parent call stack.

    In this way all the path will be printed.
     */
    public void printAllPath(TreeNode root){
        if(root == null) return;
        stack.push(root);
        printAllPath(root.left);
        if(root.left == null && root.right == null){
            Iterator iterator = stack.iterator();
            while(iterator.hasNext()){
                TreeNode temp = (TreeNode)iterator.next();
                System.out.print(temp.val+" ");
            }
            System.out.println();

        }
        printAllPath(root.right);
        stack.pop();

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

        PrintAllPathFromRootToLeaf printAllPathFromRootToLeaf = new PrintAllPathFromRootToLeaf();
        printAllPathFromRootToLeaf.printAllPath(root);
    }

}
