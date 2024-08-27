package Tree;

/**
Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 */
public class BSTRemove {

    // To delete a node in BST 
    // First we need to find the Node, by traversing through the tree
    // If we find the node, there are 2 different scenarios: 
    // - If the node to be deleted has 0 or 1 child
    // - Or the node to be deleted has 2 children 
    // For case 1, if the node's right child is null, return the left child, whether it's null or not
    // If the node's left child is null, return the right child, whether it's null or not
    // For case 2, we first need to find the minium value for the node's subtree
    // We first assign the minimum value to the node, then call remove the minimum value on the subtree
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // When we found the node to delete
            if (root.right == null) {
                return root.left; 
            } else if (root.left == null) {
                return root.right;
            } else {
                // If the node has 2 children
                // Find the minimum node in this tree
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        TreeNode curr = root; 
        while (curr != null && curr.left != null) {
            curr = root.left;
        }
        return curr;
    }
}
