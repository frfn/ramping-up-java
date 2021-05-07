package b_dsalgo.tree;

// This IS IMPORTANT. Binary Search Trees are used in lots of FAANG questions.

public class IntBST {

    TreeNode root;
    int size;

    public IntBST() {
        root=null; size=0;
    }

    public TreeNode getRoot() { return root; }

    // adding and deleting in recursive manner
    public TreeNode add(TreeNode node, int data) {
        // if tree is empty
        if(root == null) {
            size++;
            root = new TreeNode(data);
            return root;
        }

        /* when the node is null, we create a new TreeNode and return that node to be the left or right child */
        if(node == null) {
            size++;
            node = new TreeNode(data); // when we hit null, we return a new node,
            return node;
        }

        if(data < node.data) {
            TreeNode newNode = add(node.left, data); // we eventually will reach a null since we are passing node.left | node.right

            node.left = newNode; // current node's left = newNode, when bubbling out of recursive call, it will just point to existing node

            newNode.parent = node; // same here as well from explanation above ^

        } else if(data > node.data) {
            TreeNode newNode = add(node.right, data);

            node.right = newNode;

            newNode.parent = node;
        }
        return node;
        // you're wondering what happens to the returned node, the value goes to the newNode
        // we DO bubble out and the newNode CAN have existing nodes already since we bubble out! :D
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

    // traversing tree in recursive manner
    public void preOrderTraversal(TreeNode node) {
        if(node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(TreeNode node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }

    // traversing tree in iterative manner
    // ... do this tomorrow

    // print items level order
    // ... do this tomorrow

    // find height
    public int findHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1; // you MUST increase
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
                                  50        150
                                 /  \
                               5    75
                                      \
                                       80

         */

        IntBST tree = new IntBST();
        tree.add(tree.getRoot(), 100);
        tree.add(tree.getRoot(), 150);
        tree.add(tree.getRoot(), 50);
        tree.add(tree.getRoot(), 5);
//        tree.add(tree.getRoot(), 1);
        tree.add(tree.getRoot(), 75);
        tree.add(tree.getRoot(), 80);

        System.out.println(tree.findHeight(tree.getRoot()));

    }

}
