package b_dsalgo.tree;

// This IS IMPORTANT. Binary Search Trees are used in lots of FAANG questions.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntBST {

    TreeNode root;
    int size;

    public IntBST() {
        root=null; size=0;
    }

    public TreeNode getRoot() { return root; }


    // contains
    public boolean contains(TreeNode root, int data) {
        /*
        Create an easy to understand explanation here. Iterative is easier to implement!'

        1. You had the right approach at the first round

        2. contains() returns a boolean, use that as a VALUE,

        3. because
            - T & F = F
            - T & T = T

            if F, then we go down to false!
         */

        if(root == null) return false;

        if(data == root.data) return true;
        else if(data < root.data && contains(root.left, data)) return true;
        else if(data > root.data && contains(root.right, data)) return true;

        return false;
    }


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
        // you're wondering what happens to the returned node values, the value goes to the newNode
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
            // having one child, at this point your AT the node, you will return one of it's child
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


    // traversing tree in iterative manner ( DFS )
    public void preOrderIterative(TreeNode node) {
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data);

            if(temp.right != null) stack.push(temp.right);
            if(temp.left  != null) stack.push(temp.left);
        }
    }
    public void inOrderIterative(TreeNode node) {
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                current = stack.pop(); // we utilize the stack and use it as the next iterator
                System.out.println(current.data);
                current = current.right;
            }
        }
    }
    /* Do       postOrderIterative      tomorrow!  */ // it is confusing...


    // print items level order ( BFS )
    public void levelOrderTraversal(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.println(temp.data);

            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
    }


    // find height
    public int findHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1; // you MUST increase
    }


    // finding max in Binary Tree and Binary Search Tree recursively | you find min by doing this
    public int findMaxInBT(TreeNode node) {
        if(node == null) return -1;

        int maxValue = node.data;
        int left = findMaxInBT(node.left); // the return value is max value
        int right = findMaxInBT(node.right);

        if(left > maxValue) maxValue = left;
        if(right > maxValue) maxValue = right;

        return maxValue;

    }
    public int findMaxInBST(TreeNode node) {
        if(node.right == null) {
            return node.data;
        }
        return findMaxInBST(node.right);
    }


    // lowest common ancestor
    public int lowestCommonAncestor(TreeNode node, int a, int b) {
        while(node != null) {
            if(node.data > a && node.data > b) {
                node = node.left;
            }

            else if(node.data < a && node.data < b) {
                node = node.right;
            }

            else break;
        }
        return node != null ? node.data : -1;
    }


    // symmetric tree | interesting, so it reads, after it does first p.left, q.right, it it will start p.right, q.left and re do the method calls! Fascinating.
    public boolean symmetricTree(TreeNode root) {
        return symTreeHelper(root, root);
    }
    private boolean symTreeHelper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;  // when it hits null return true
        if(p == null || q == null) return false; // if the parent has a child and the other parent doesn't... well it's not symmetric.

        if(p.data == q.data) return
                symTreeHelper(p.left, q.right)
                && symTreeHelper(p.right, q.left);

        return false;
    }


    // same tree
    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;  // when it hits null return true
        if(p == null || q == null) return false; // if the parent has a child and the other parent doesn't... well it's not symmetric.

        if(p.data == q.data) return
                sameTree(p.left, q.left)
                && sameTree(p.right, q.right);

        return false;
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
        tree.add(tree.getRoot(), 75);
        tree.add(tree.getRoot(), 80);

        System.out.println(tree.contains(tree.root, 1));


        // -------------------------------------------------- //


        /*

          Binary Tree

                                        0
                                     /     \
                                   1        1
                                 /  \     /   \
                               3    4    4     3

         */


        // Binary Tree
        IntBST binaryTree = new IntBST();
        TreeNode root = new TreeNode(0); // root

        TreeNode node1 = new TreeNode(1); // second layer
        TreeNode node2 = new TreeNode(1);

        TreeNode node3 = new TreeNode(3); // third layer
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        // setting up
        binaryTree.add(binaryTree.getRoot(), root.data);

        binaryTree.getRoot().left = node1;
        binaryTree.getRoot().right = node2;

        binaryTree.getRoot().left.left = node3;
        binaryTree.getRoot().right.right = node6;
        binaryTree.getRoot().left.right = node4;
        binaryTree.getRoot().right.left = node5;

        // BT 2

        IntBST binaryTree2 = new IntBST();
        TreeNode rootCopy = new TreeNode(0); // root

        TreeNode node1Copy = new TreeNode(1); // second layer
        TreeNode node2Copy = new TreeNode(1);

        TreeNode node3Copy = new TreeNode(3); // third layer
        TreeNode node4Copy = new TreeNode(4);
        TreeNode node5Copy = new TreeNode(4);
        TreeNode node6Copy = new TreeNode(3);

        // setting up
        binaryTree2.add(binaryTree.getRoot(), rootCopy.data);

        binaryTree2.getRoot().left = node1Copy;
        binaryTree2.getRoot().right = node2Copy;

        binaryTree2.getRoot().left.left = node3Copy;
        binaryTree2.getRoot().right.right = node6Copy;
        binaryTree2.getRoot().left.right = node4Copy;
        binaryTree2.getRoot().right.left = node5Copy;

        //System.out.println(binaryTree.sameTree(binaryTree.getRoot(), binaryTree2.getRoot()));


    }

}
