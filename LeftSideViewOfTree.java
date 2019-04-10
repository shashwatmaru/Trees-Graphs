import java.util.LinkedList;
import java.util.Queue;

public class LeftSideViewOfTree {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int value) {
            val = value;
        }
    }

    public void leftView(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        System.out.println(node.val);
        TreeNode temp;
        TreeNode rightNode;
        while(!queue.isEmpty()){
            temp = queue.poll();
            while(temp != null){
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                temp = queue.poll();
                //This is the condition, we need to check if the next element is null and current element is not null
                // then print current element.
                if(temp != null && queue.peek()== null){
                    System.out.println(temp.val);
                }
            }
            if(temp == null){
                queue.add(null);
                if(queue.peek() == null) break;
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

        LeftSideViewOfTree leftSideViewOfTree = new LeftSideViewOfTree();
        leftSideViewOfTree.leftView(root);

    }
}
