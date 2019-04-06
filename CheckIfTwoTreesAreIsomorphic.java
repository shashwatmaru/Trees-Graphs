public class CheckIfTwoTreesAreIsomorphic {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }

    public boolean isIsomorphic(TreeNode root1, TreeNode root2){
            if(root1 == null && root2== null) return true;
            if(root1== null || root2 == null) return false;
            if(root1.val != root2.val) return false;
            if((root1.left.val == root2.left.val && root1.right.val == root2.right.val) ||
                    (root1.left.val == root2.right.val && root1.right.val == root2.left.val))
                return true;

            return false;
    }
    public static void main(String [] args){
        CheckIfTwoTreesAreIsomorphic checkIfTwoTreesAreIsomorphic = new CheckIfTwoTreesAreIsomorphic();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.left.right = new TreeNode(6);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println("Both the trees are Isomorphic: "+checkIfTwoTreesAreIsomorphic.isIsomorphic(root1,root2));



    }

}
