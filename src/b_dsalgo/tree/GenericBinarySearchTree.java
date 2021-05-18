package b_dsalgo.tree;

// isBST? function not implemented | sees if tree is a binary search tree ...
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Comparable contains a compareTo method that we have to fill in
// were giving the X type a function called compareTo() --> ? super X comes from Effective Java!
public class GenericBinarySearchTree<X extends Comparable<? super X>> { // Effective Java
    // here, X gets that extra Comparable fn
    private Node<X> root;
    private int size;

    //-----------------//
    //   Constructor   //
    //-----------------//
    public GenericBinarySearchTree() {
        root=null;
        size=0;
    }

    //-----------------//
    //   Utility Fns   //
    //-----------------//
    public Node<X> contains(X item) {
        Node<X> current = root;
        while(current != null) {
            int compareEvaluation = item.compareTo(current.getItem()); // will be: -1 , 0 , 1

            if (compareEvaluation == 0) {
                return current; // traversing!
            } else if (compareEvaluation < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    } // search fn for delete() -- traverse the tree till it finds the current item we're looking for
    private void redirectNode(Node<X> current, Node<X> toNextNode) {
        // deleting root?
        if(current == root) {
            // the next node will be root
            toNextNode.setLeft(current.getLeft());
            toNextNode.setRight(current.getLeft());
            root = toNextNode;
        }
        // reassign right node
        else if (current.getParent().getRight() == current) {
            current.getParent().setRight(toNextNode);
        }
        // reassign left node
        else {
            current.getParent().setLeft(toNextNode);
        }
    } // redirect pointer to left or right nodes to link the nodes , and 'delete' the removed node , through GC.
    public boolean itIsEmpty() { return root == null; }
    public Node<X> getRoot() { return root != null ? root :  null; }
    public int getSize() { return size; }

    // draw a diagram and go over, this logic is simple to follow

    //---------------------//
    //   Add Node in BST   //
    //---------------------//

    // This is what
    public Node<X> addRecursion(Node<X> current, X item) {
        // if the tree is EMPTY
        if(itIsEmpty()) {
            root = new Node<>(item);
            size++;
            return root;
        }

        // the base case, we reassign current, which is null, as the new node
        if(current == null) {
           current = new Node<>(item); size++;
           return current;
        }

        // we traverse the tree, and once the base case returns a node, that node either becomes current.left = node | current.right = node
        if(item.compareTo(current.getItem()) <= 0) {
            current.left = addRecursion(current.left, item);
        } else if(item.compareTo(current.getItem()) > 0) {
            current.right = addRecursion(current.right, item);
        }

        return current;

    } // add node | more efficient recursive
    // you need to learn!

    public void addIterative(X item) {
        Node<X> current = root;
        Node<X> newNode = new Node<>(item);

        if(current == null) {
            root = newNode;
            size++;
            return;
        }

        while(current != null) {

            if(newNode.getItem().compareTo(current.getItem()) <= 0) {
                if(current.getLeft() == null) {
                    current.setLeft(newNode);
                    newNode.setParent(current);
                    size++;
                    break;
                }
                current = current.getLeft();
            }

            if(newNode.getItem().compareTo(current.getItem()) > 0) {
                if(current.getRight() == null) {
                    current.setRight(newNode);
                    newNode.setParent(current);
                    size++;
                    break;
                }
                current = current.getRight();
            }
        }
    } // iterative adding in a BST
    private void insert(Node<X> current, Node<X> child) {
        /*
        Comparable interface!
        less than = -1
        equal to  =  0
        more than =  1
         */
        if(child.getItem().compareTo(current.getItem()) <= 0) {
            // base case
            if(current.getLeft() == null){
                current.setLeft(child);
                child.setParent(current);
            }
            else {
                insert(current.getLeft(), child);
            }
        }
        else if(child.getItem().compareTo(current.getItem()) > 0){
            // base case
            if (current.getRight() == null ){
                current.setRight(child);
                child.setParent(current);
            }
            else {
                insert(current.getRight(), child);
            }
        }
    } // helper fn for add() , recursively add
    public void add(X item){
        Node<X> node = new Node<>(item); // Node has no connections, just item
        if(itIsEmpty()){
            root = node;
        }
        else{
            insert(root, node);
        }
        size++;
    } // to add

    //------------------------//
    //   Delete Node in BST   //
    //------------------------//

    // This is what
    public Node<X> delete(Node<X> current, X item) {
        if(current == null) return null;

        if(item.compareTo(current.getItem()) < 0) {
            current.left = delete(current.left, item);

        } else if (item.compareTo(current.getItem()) > 0) {
            current.right = delete(current.right, item);

        } else {
            if(current.left == null || current.right == null) {
                 return current.left == null ? current.right : current.left; // this is correct, current.right even if null is a thing
//                Node<X> temp = current.left == null ? current.right : current.left;
//                return temp;
//                if(temp == null) {
//                    return null;
//                } else {
//                    return temp;
//                }
            } else {
                /*
                Two ways:
                - right subtree : find the min
                - left subtree  : find the max

                in this case, find min.
                 */
                Node<X> successor = current.right;
                while(successor.left != null) {
                    successor = successor.left;
                }

                // now replace the data!
                current.setItem(successor.getItem()); // current.item = successor.item;

                // delete the successor since it's not needed anymore!
                current.right = delete(current.right, successor.getItem());
            }

        }
        return current;
    }
    // you need to learn!

    //-----------------------------------------//
    //   Find Min and Max Recursively in BST   //
    //-----------------------------------------//
    // Min
    public Node<X> getMinRecursive(Node<X> current) {
        if(itIsEmpty()) return null;
        return current.getLeft() == null ? current : getMinRecursive(current.getLeft());
    }
    // Max
    public Node<X> getMaxRecursive(Node<X> current) {
        if(itIsEmpty()) return null;
        return current.getRight() == null ? current : getMaxRecursive(current.getRight());
    }

    //-----------------------------------------//
    //   Find Min and Max Iteratively in BST   //
    //-----------------------------------------//
    // Min
    public Node<X> getMinIterative() {
        if (itIsEmpty()) {
            return null;
        }
        Node<X> current = root;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
    // Max
    public Node<X> getMaxIterative() {
        if (itIsEmpty()) {
            return null;
        }
        Node<X> current = root;
        while(current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    // Great to understand!

    //------------------------------------//
    //   Print Items Recursively in BST   //
    //------------------------------------//
    // There is a call stack, that when the function does not fully finish, it will return to the line it left off on!
    // print items 'pre order' recursively!
    public void printPreOrderRecursive(Node<X> current) {
        if(itIsEmpty()){
            System.out.println("Nothing to print...");
        }
        if(current != null) {
            System.out.println(current.getItem());
            printPreOrderRecursive(current.getLeft());
            printPreOrderRecursive(current.getRight());
        }

    }
    // print items 'in order' recursively!
    public void printInOrderRecursive(Node<X> current) {
        if(itIsEmpty()){
            System.out.println("Nothing to print...");
        }
        if(current != null) {
            printInOrderRecursive(current.getLeft());
            System.out.println(current.getItem());
            printInOrderRecursive(current.getRight());
        }

    }
    // print items 'post order' recursively!
    public void printPostOrderRecursive(Node<X> current) {
        if(itIsEmpty()){
            System.out.println("Nothing to print...");
        }
        if(current != null) {
            printPostOrderRecursive(current.getLeft());
            printPostOrderRecursive(current.getRight());
            System.out.println(current.getItem());
        }

    }

    //------------------------------------//
    //   Print Items Iteratively in BST   //
    //------------------------------------//
    // Once done on white board, it becomes VERY easy to understand and see how the stack works!
    // PreOrder
    public void printPreOrderIterative() {
        if(itIsEmpty()) {
            System.out.println("Empty tree... Add data!");
        }

        Stack<Node<X>> stack = new Stack<>(); // this simulates the `call stack` the recursive methods uses, LIFO
        stack.push(getRoot());

        while(!stack.isEmpty()) {
            Node<X> temp = stack.pop(); // even though pop(), we still have the reference to the popped value from stack!
            System.out.println(temp.getItem());

            // right first so that LEFT will be on top of stack | we're popping.
            if(temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if(temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
    }
    // InOrder
    public void printInOrderIterative() {
        if(itIsEmpty()) System.out.println("No data... Add data!");

        Stack<Node<X>> stack = new Stack<>();
        Node<X> temp = root; // start from root

        // difference from PreOrder is only pushing left branch
        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.getLeft(); // finish going all the way to the left
            }
            else {
                temp = stack.pop();
                System.out.println(temp.getItem() + " ");
                temp = temp.getRight();
            }
        }

    }
    // PostOrder | this is here ... but, you don't need to know how to implement this. Not significant. | Poll === Pop functionally
    public void printPostOrderIterative() {
        if(itIsEmpty()) System.out.println("Empty tree... Add data!");

        Stack<Node<X>> stack = new Stack<>();
        Node<X> current = root; // out pointer / reference

        while(!stack.isEmpty() || current != null ) {
            if(current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            else {
                Node<X> temp = stack.peek().getRight();
                if(temp == null){
                    temp = stack.pop();
                    System.out.println(temp.getItem() + " ");
                    while(!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        System.out.println(temp.getItem() + " ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }
    }

    //---------------------------------------//
    //   Print Items Level by Level in BST   //
    //---------------------------------------//
    // implemented with Queue
    public void printLevelOrder() {
        if(itIsEmpty()) System.out.println("Empty tree... Add data!");
        // Example of polymorphism through inheritance, Queue has all of LinkedList methods
        // Implementation is different from linked list!
        Queue<Node<X>> queue = new LinkedList<>();
        queue.offer(root); // add === offer functionality
        while(!queue.isEmpty()) {
            Node<X> temp = queue.poll(); // pop === poll functionality
            System.out.println(temp.getItem() + " ");
            if(temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if(temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }

    }

    //-----------------//
    //   Find Height   //
    //-----------------//
    // Depth VS Height
    // You can do this iteratively by altering the printLevelOrder and having a counter and adding by one!
    // No idea how this goes :)
    public int findHeight(Node<X> current) {
        if(current == null) {
            return -1;
        }

        // Every time we complete a recursion call, increase the variable!
        int leftHeight = findHeight(current.getLeft());
        int rightHeight = findHeight(current.getRight());

        // Compare the value, see which is greater, use that value to calculate the height!
        // Confused? Debug again!
        return Math.max(leftHeight, rightHeight) + 1;

    }


    // Methods that needs to be commented below
    public int findMaxInABinaryTree(Node<Integer> current) {
        if(itIsEmpty()) return 0;

        if(current == null) {
            return Integer.MIN_VALUE;
        }

        int maxNum = current.getItem();
        int left = findMaxInABinaryTree(current.getLeft());
        int right = findMaxInABinaryTree(current.getRight());

        if(left > maxNum) {
            maxNum = left;
        }
        if(right > maxNum) {
            maxNum = right;
        }

        return maxNum;
    }

    public boolean symmetricTree(Node<X> root) {
        return symmetricTreeHelper(root, root);
    }
    private boolean symmetricTreeHelper(Node<X> p, Node<X> q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.getItem().compareTo(q.getItem()) == 0) {
            return symmetricTreeHelper(p.getLeft(), q.getRight()) && symmetricTreeHelper(p.getRight(), q.getLeft());
        }

        return false;

        /*
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
         */
    }

    public boolean sameTree(Node<X> p, Node<X> q) {
        // Equal nullity denotes that this branch is the same (local equality)
        // This is a base case, but also handles being given two empty trees
        if (p == null && q == null) return true;

            // Unequal nullity denotes that the trees aren't the same
            // Note that we've already ruled out equal nullity above
        else if (p == null || q == null) return false;

        // Both nodes have values; descend iff those values are equal
        // "&&" here allows for any difference to overrule a local equality
        if (p.getItem() == q.getItem()) {
            return sameTree(p.getLeft(), q.getLeft()) && sameTree(p.getRight(), q.getRight());
        }

        // If we're here, both nodes have values, and they're unequal, so the trees aren't the same
        return false;

        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
         */
    }

    public Node<X> lowestCommonAncestor(Node<X> head, int a, int b) {
        while(head != null) {
            if((Integer)head.getItem() > a && (Integer)head.getItem() > b) {
                head = head.getLeft();
            }
            else if((Integer)head.getItem() < a && (Integer)head.getItem() < b) {
                head = head.getRight();
            }
            else break;
        }
        return head;
    }
}

// this is a generic class, creates Node<X> object!
class Node<X> {

    private X item;
    Node<X> parent, left, right; // you can refer other objects here | this is 'linking' the objects!

    // this is how you _make_ the object
    public Node(X item){
        this.item = item;
        parent=left=right=null;
    }

    // pretty much, you don't need the things at the bottom, don't make the stuff private
    public X getItem() { return item; }
    public Node<X> getParent() { return parent; }
    public Node<X> getLeft() { return left; }
    public Node<X> getRight() { return right; }

    public void setItem(X item) { this.item = item; }
    public void setParent(Node<X> parent) { this.parent = parent; }
    public void setLeft(Node<X> left) { this.left = left; }
    public void setRight(Node<X> right) { this.right = right; }
}

class TestBinaryTree {

    public static void main(String[] args) throws Exception {

        GenericBinarySearchTree<Integer> tree = new GenericBinarySearchTree<>();

        tree.addRecursion(tree.getRoot(), 10);
        tree.addRecursion(tree.getRoot(), 5);
        tree.addRecursion(tree.getRoot(), 15);
        tree.addRecursion(tree.getRoot(), 3);
        tree.addRecursion(tree.getRoot(), 8);
        tree.addRecursion(tree.getRoot(), 9);
        tree.addRecursion(tree.getRoot(), 11);
        tree.addRecursion(tree.getRoot(), 18);
        tree.addRecursion(tree.getRoot(),7);

        tree.delete(tree.getRoot(), 10);

        tree.printPreOrderIterative();

    }

}