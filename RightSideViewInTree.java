import java.util.LinkedList;
import java.util.Queue;

public class RightSideViewInTree {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int value) {
            val = value;
        }
    }

    /*
    In this, we will print the right side view element by using a queue and the level order traversal,
    And print condition would be whenever we will encounter a null, then we will print the next element in the
    queue using queue.peek().
     */
    public void rightView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        TreeNode temp;
        System.out.println(node.val);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            while(temp!=null){
               if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                temp = queue.poll();
            }
            if(temp == null){
                queue.add(null);
                if(queue.peek() != null) System.out.println(queue.peek().val);
                if(queue.peek()==null) break;
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

        RightSideViewInTree rightSideViewInTree = new RightSideViewInTree();
        rightSideViewInTree.rightView(root);

    }
}