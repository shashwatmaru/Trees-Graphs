import java.util.Iterator;
import java.util.Stack;

public class PrintRootToLeafPathWithGivenSum {
    Stack<Integer> stack = new Stack<>();
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }
    public void printPath(int sum,TreeNode node, int k){
        if(node == null) return;


        sum += node.val;
        stack.push(node.val);
        if(sum == k){
            while(!stack.empty()){
                System.out.print(stack.pop()+" ");
            }
        }
        printPath(sum,node.left,k);
        printPath(sum,node.right,k);

        sum =sum- node.val;
        if(!stack.empty())
            stack.pop();

    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(12);

        int sum=0;
        PrintRootToLeafPathWithGivenSum printRootToLeafPathWithGivenSum = new PrintRootToLeafPathWithGivenSum();
        printRootToLeafPathWithGivenSum.printPath(sum,root, 20);
    }
}
