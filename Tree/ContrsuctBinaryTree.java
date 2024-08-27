package Tree;

import java.util.Arrays;

/**
You are given two integer arrays preorder and inorder.

preorder is the preorder traversal of a binary tree
inorder is the inorder traversal of the same tree
Both arrays are of the same size and consist of unique values.
Rebuild the binary tree from the preorder and inorder traversals and return its root.
 */
public class ContrsuctBinaryTree {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null; 
        }
   
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            int n = inorder[i];
            if (n == preorder[0]) {
                index = i;
                break;
            }
        }
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}
