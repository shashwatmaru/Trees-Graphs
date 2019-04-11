import java.util.LinkedList;
import java.util.Queue;

public class PrintAllDiagonalsOfBinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }

    /*
    For printing the diagonal element, I have used a queue where initially we will push root followed by a null in queue.
    And after that, we will pop the element from the queue untill it is empty.
    And the pop element if it is not empty, then we will check if it has a left node, if it is then we will add that element
    to the queue and after that we will print the current node and traverse towards the right child untill a null node is met.
    While traversing thru the right child, we will check if the node has the left child or not, if it has then we will add it to
    the queue.
    Once a null node is met, We will again check if there is any node present in the queue, if it is then we will dequeue it
    and check in the same way.

    If the node is null, it means that all the diagonal element of a iteration has been visited and now a new diagonal element will
    be traversed, If we find 2 null nodes back 2 back, it means we have traversed all the nodes.
     */
    public void printDiagonals(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode temp;
        while(!queue.isEmpty()){
            temp=queue.poll();
            if(temp == null){
                queue.add(null);
                temp= queue.poll();
                System.out.println();
                if(temp == null) break;
            }

            while(temp != null){
                if(temp.left != null) queue.add(temp.left);
                System.out.print(temp.val+" ");
                temp=temp.right;
            }
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

        PrintAllDiagonalsOfBinaryTree printAllDiagonalsOfBinaryTree = new PrintAllDiagonalsOfBinaryTree();
        printAllDiagonalsOfBinaryTree.printDiagonals(root);
    }

}
