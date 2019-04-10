import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class TopViewOfBinaryTree {

    //This treeNode class will have a left, right, value of node and new attribute heightDepth.
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int heightDepth;
        public TreeNode(int value) {
            val = value;
        }
    }

    public void topView(TreeNode root){
        /*This map is used to print the first element/value in queue for a given key
          Key is the heightDepth and its value will be the node's value.

          And we are putting only one value for a given key, based on the Queue.
        */
        Map<Integer,Integer> map = new HashMap<>();
        /*
        Queue is used for level order traversal, here elements are added to the queue if they exists in the tree.
        and on next iteration elements it is dequeue.
         */
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        root.heightDepth=0;
        queue.add(root);

        /*
        This while loop will be run until the queue is empty.
         */
        while(!queue.isEmpty()){
            /*
            Taking the element from head of queue.
             */
           temp=queue.poll();
           /*
            if the map doesnot contain the keys, then it will store it with value.
            and print the node value.

            And when the same key comes again, with different node value, it will not be stored
            and printed, as the key concept of this is to print the first occured queue element using map.

            Or in other words, we are going to print only one element with unique HD.( and that will be the first/oldest
            element present in queue.)
            */
           if(!map.containsKey(temp.heightDepth)){
               map.put(temp.heightDepth,temp.val);
               System.out.print(temp.val+" ");
           }
           /*
           If the left child is not null, then it is added to the queue and set the hd = hd_parent -1;
           or in other words, child hd will always be 1 less to it's parent.
                       */
           if(temp.left != null){
               temp.left.heightDepth=temp.heightDepth-1;
               queue.add(temp.left);
           }

           /*
           If the right child is not null, then it is added to the queue and set the hd = hd_parent +1;
           or in other words, child hd will always be 1 more to it's parent.
                       */
           if(temp.right != null){
               temp.right.heightDepth = temp.heightDepth+1;
               queue.add(temp.right);
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

        TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
        topViewOfBinaryTree.topView(root);
    }

}
