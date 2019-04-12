public class CheckIfATreeIsSubTreeOfAnotherTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }
    /*
        This method takes 2 tree's root node, and then isIdentical method is called which return true if both are same
        if not then we traverse left in the main and tree and recursively check the same.
        And then we traverse right.
     */
    public boolean isSubtree(TreeNode mainTreeRoot, TreeNode givenTreeRoot){
        if(mainTreeRoot==null) return  false;
        if(givenTreeRoot==null) return true;
        if(isIdentical(mainTreeRoot,givenTreeRoot)) return  true;

        return (isSubtree(mainTreeRoot.left,givenTreeRoot) || isSubtree(mainTreeRoot.right,givenTreeRoot));
    }
    /*
    This method takes 2 nodes of 2 different trees.
    If both are not null then we compare the val of the nodes and then traverse left and right and if all matches then
    we return true other wise false.
     */
    private boolean isIdentical(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return  true;
        if(node1 != null && node2 != null){
            if(node1.val == node2.val && isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right))
                return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(56);
        root1.left = new TreeNode(14);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(1);
        root1.left.left.right = new TreeNode(2);

        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(3);
        root1.right.right.left = new TreeNode(2);
        root1.right.right.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(56);
        root2.left = new TreeNode(14);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(1);
        root2.left.left.right = new TreeNode(2);

        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(3);
        root2.right.right.left = new TreeNode(2);
        root2.right.right.right = new TreeNode(1);

        CheckIfATreeIsSubTreeOfAnotherTree checkIfATreeIsSubTreeOfAnotherTree = new CheckIfATreeIsSubTreeOfAnotherTree();
        System.out.println("Is root2 is a  subtree of a root1 tree: "+checkIfATreeIsSubTreeOfAnotherTree.isSubtree(root1,root2));
    }


}
