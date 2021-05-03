package b_dsalgo.tree;

// This IS IMPORTANT.

public class IntBST {

    TreeNode root;
    int size;

    public IntBST() {
        root=null; size=0;
    }

    public TreeNode getRoot() { return root; }
    public TreeNode add(TreeNode node, int data) {
        if(root == null) {
            size++;
            root = new TreeNode(data);
            return root;
        }

        // This is recursion!
        if(node == null) {
            size++;
            node = new TreeNode(data);
            return node;
        }

        if(data < node.data) {
            node.left = add(node.left, data);
        } else if(data > node.data) {
            node.right = add(node.right, data);
        }
        return node;
    }
    public TreeNode delete(TreeNode node, int data) {
        if(root == null) return null;

        // the node.left | node.right = delete(...) will be assigned at 'here'
        if(data < node.data) node.left = delete(node.left, data);
        else if(data > node.data) node.right = delete(node.right, data);
        else {
            // having one child
            if(node.left == null || node.right == null) {
                return node.left == null ? node.right : node.left; // <-- here
            }
            // having two children
            else {
                // find the min in the right subtree! this is the logic to find potential node to replace deleted node with two childen
                TreeNode successor = node.right;
                while(successor.left != null) successor = successor.left;
                node.data = successor.data;
                node.right = delete(node.right, successor.data); // <-- here
            }

        }
        return node;
    }
    public void preOrderTraversal(TreeNode node) {
        if(node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}

class TreeNode {
    int data;
    TreeNode parent, left, right;
    public TreeNode(int data) { this.data = data; parent=left=right=null; }
}
class TestIntBST {

    public static void main(String[] args) {

        IntBST tree = new IntBST();
        tree.add(tree.getRoot(), 10);
        tree.add(tree.getRoot(), 5);
        tree.add(tree.getRoot(), 15);
        tree.add(tree.getRoot(), 3);
        tree.add(tree.getRoot(), 18);

        tree.delete(tree.getRoot(), 10);

        tree.preOrderTraversal(tree.getRoot());

    }

}
