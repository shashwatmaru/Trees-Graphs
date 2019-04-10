import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalInTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }

    /*
     In this method all the element in the tree needs to be print in level order,


     This is done using a queue, and we are polling from the queue and if it is not null
     then its children nodes are added and if null value is encountered, then code will terminate.
     */
    public void printLevelOrder(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
         TreeNode temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp != null){
                System.out.print(temp.val+" ");
                if(temp.left != null ) queue.add(temp.left);
                if(temp.right != null ) queue.add(temp.right);
            }
            if(temp == null) break;

        }


    }


    /*
        We need to add root followed by a null element in queue.

        In this method we are printing each level in new line, This is done by queue,
        where we are adding element in the queue until we find a null value in the queue ( actually null
        value tells that the elements in a particular level has been exhausted and now new level has to be print.

        And null is introduced whenever we encounter a previous null value and then print a \n.

        The break condition is 2 consecutive null in queue.
     */
    public void printLevelOrderNewLine(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        TreeNode temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            while(temp != null){
                System.out.print(temp.val+" ");
                if(temp.left != null ) queue.add(temp.left);
                if(temp.right != null ) queue.add(temp.right);
                temp = queue.poll();
            }
            if(temp == null){
                queue.add(null);
                System.out.println();
                TreeNode n1= queue.peek();
                if(n1 == null) break;
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

        LevelOrderTraversalInTree levelOrderTraversalInTree = new LevelOrderTraversalInTree();
        levelOrderTraversalInTree.printLevelOrder(root);
        System.out.println();
        System.out.println("Now printing each level in new line.");
        levelOrderTraversalInTree.printLevelOrderNewLine(root);

    }

}
