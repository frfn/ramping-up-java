package b_dsalgo.tree;

// This IS IMPORTANT. Binary Search Trees are used in lots of FAANG questions.

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

        /* when the node is null, we create a new TreeNode and return that node to be the left or right child */
        if(node == null) {
            size++;
            node = new TreeNode(data); // when we hit null, we return a new node,
            return node;
        }

        if(data < node.data) {
            TreeNode newNode = add(node.left, data); // we eventually will reach a null since we are passing node.left | node.right

            node.left = newNode;
            newNode.parent = node;
        } else if(data > node.data) {
            TreeNode newNode = add(node.right, data);

            node.right = newNode;
            newNode.parent = node;
        }
        return node;
    }
    public TreeNode delete(TreeNode node, int data) {
        if(root == null) return null;

        /* we traverse the tree until we find the node */
        if(data < node.data) {
            node.left = delete(node.left, data);
        }

        else if(data > node.data) {
            node.right = delete(node.right, data);
        }

        /* we found node */
        else {
            // having one child
            if(node.left == null || node.right == null) {
                return node.left == null ? node.right : node.left; // <-- here
            }
            // having two children
            else {
                // find the min in the right subtree! this is the logic to find potential node to replace deleted node with two children
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


        /*

          BST ( you do bubble out when popping from call stack. )

                                       100
                                     /     \
                                 50           150
                               /    \
                              5     75
                                  /
                                60

         */

        IntBST tree = new IntBST();
        tree.add(tree.getRoot(), 100);
        tree.add(tree.getRoot(), 150);
        tree.add(tree.getRoot(), 50);
        tree.add(tree.getRoot(), 5);
        tree.add(tree.getRoot(), 1);

        tree.preOrderTraversal(tree.getRoot());

    }

}
