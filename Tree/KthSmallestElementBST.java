package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given the root of a binary search tree, and an integer k, 
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        list = sortInOrder(list, root);
        return list.get(k).val;
    } 

    private List<TreeNode> sortInOrder(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return list;
        }

        sortInOrder(list, root.left);
        list.add(root);
        sortInOrder(list, root.right);

        return list;
    }

    public int kthSmallestIteratively(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (k != 0) {
            TreeNode node = stack.pop();
            k--; 
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right; 
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
