/*
Given a number find the max possible number of Binary Search Tree possible using Dynamic Programming
This problem is  Catalan Problem.
 */

public class CountNumberOfBSTPossibleGivenNKeysDP {

    public int maxPossibleBST(int n){
        int[] T = new int[n+1];
        T[0]=1;
        T[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                T[i]+=T[j]*T[i-j-1];
            }
        }
        return T[n];
    }

    public static void main(String [] args){
        CountNumberOfBSTPossibleGivenNKeysDP countNumberOfBSTPossibleGivenNKeysDP = new CountNumberOfBSTPossibleGivenNKeysDP();
        System.out.println("Max possible BST possible: "+countNumberOfBSTPossibleGivenNKeysDP.maxPossibleBST(5));
    }

}
