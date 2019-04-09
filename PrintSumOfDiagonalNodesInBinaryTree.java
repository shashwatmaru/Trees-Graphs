import java.util.LinkedList;
import java.util.Queue;

public class PrintSumOfDiagonalNodesInBinaryTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }

    public void sumDiagonalNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode nullNode = null;
        int sum=0;
        TreeNode node1;

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
           node1= queue.poll();
            if(node1 == null){
                System.out.println(sum);
                queue.add(null);
                sum=0;
                node1 = queue.poll();
               if(node1 == null) break;
            }
            while(node1 != null){
                sum += node1.val;
                if(node1.left != null){
                    queue.add(node1.left);
                }
                node1 = node1.right;
            }
        }
    }

    public static void main(String [] args){
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


        PrintSumOfDiagonalNodesInBinaryTree printSumOfDiagonalNodesInBinaryTree = new PrintSumOfDiagonalNodesInBinaryTree();
        printSumOfDiagonalNodesInBinaryTree.sumDiagonalNode(root);
    }

}
