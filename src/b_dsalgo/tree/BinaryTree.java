package b_dsalgo.tree;

// isBST function | heightOfTree function | print level order (Queue)

// Comparable contains a compareTo method that we have to fill in
// were giving the X type more functions from Comparable, check the implementation
public class BinaryTree<X extends Comparable<? super X>> { // Effective Java
    // here, X gets that extra Comparable fn
    private Node<X> root;
    private int size;

    public BinaryTree() {
        root=null;
        size=0;
    }

    //-----------------//
    //   Utility Fns   //
    //-----------------//
    public boolean itIsEmpty() { return root == null; }
    public Node<X> getRoot() { return root != null ? root :  null; }
    public int getSize() { return size; }

    // draw a diagram and go over, this logic is simple to follow

    //--------------//
    //   Add Node   //
    //--------------//
    // helper fn for add() , recursively add
    private void insert(Node<X> current, Node<X> child) {
        /*
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
    }
    // to add
    public void add(X item){
        Node<X> node = new Node<>(item); // Node has no connections, just item
        if(itIsEmpty()){
            root = node;
        }
        else{
            insert(root, node);
        }
        size++;
    }

    //-----------------//
    //   Delete Node   //
    //-----------------//
    // search fn for delete() -- traverse the tree till it finds the current item we're looking for
    public Node<X> contains(X item) {
        Node<X> current = root;
        while(current != null) {
            int compareEvaluation = item.compareTo(current.getItem()); // will be: -1 , 0 , 1

            if (compareEvaluation == 0) {
                return current; // traversing!
            } else if (compareEvaluation <= 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }
    // redirect pointer to left or right nodes to link the nodes , and 'delete' the removed node , through GC.
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
    }
    // delete node
    public Node<X> delete(X item) throws Exception {
        if (itIsEmpty()) {
            throw new Exception("Tree has no items! Add item first!");
        }

        // See if item exists
        Node<X> toBeDeletedNode = contains(item);

        // Delete Root: special case! redirectNode is not used here
        if (toBeDeletedNode == root) {

            // root has no children
            if (toBeDeletedNode.getLeft() == null && toBeDeletedNode.getRight() == null) {
                root = null;
                size = 0;
            }

            // if root has no left child,
            if (toBeDeletedNode.getLeft() == null) {
                Node<X> child = toBeDeletedNode.getRight();
                while (child.getLeft() != null || child.getRight() != null) {
                    child = child.getLeft(); // push child to the left to grab the next potential root!
                }
                if (child != toBeDeletedNode.getRight()) {
                    child.getParent().setLeft(null);
                    child.setRight(toBeDeletedNode.getRight());
                }
                child.setLeft(toBeDeletedNode.getLeft()); // it will still have all the right branch items if it has a left branch, if none, null will be assigned
                root = child;
                size--;
                return toBeDeletedNode;
            }


            // if root has left child
            if (toBeDeletedNode.getLeft() != null) {
                Node<X> child = toBeDeletedNode.getLeft();
                while (child.getLeft() != null || child.getRight() != null) {
                    child = child.getRight(); // push child to the right to grab the next potential root!
                }
                if (child != toBeDeletedNode.getLeft()) { // after the traversal, if child item is not the left of root
                    child.getParent().setRight(null);
                    child.setLeft(toBeDeletedNode.getLeft());
                }
                child.setRight(toBeDeletedNode.getRight()); // it will still have all the left branch items if it has a left branch
                root = child;
                size--;
                return toBeDeletedNode;
            }
        }
        // for the other cases if toBeDeletedNode is not root
        else {
            if (toBeDeletedNode != null) {
                // if toBeDeletedNode has BOTH children
                if (toBeDeletedNode.getLeft() != null && toBeDeletedNode.getRight() != null) {
                    Node<X> child = toBeDeletedNode.getLeft();
                    while (child.getLeft() != null || child.getRight() != null) {
                        child = child.getRight();
                    }
                    // if child is not adjacent to the toBeDeletedNode
                    if (child != toBeDeletedNode.getLeft()) {
                        child.getParent().setRight(null);
                        child.setLeft(toBeDeletedNode.getLeft());
                    }
                    child.setRight(toBeDeletedNode.getRight());
                    redirectNode(toBeDeletedNode, child);
                    size--;
                    return toBeDeletedNode;
                }

                // if the toBeDeletedNode has left branch
                else if (toBeDeletedNode.getLeft() != null && toBeDeletedNode.getRight() == null) {
                    redirectNode(toBeDeletedNode, toBeDeletedNode.getLeft());
                    return toBeDeletedNode;
                }

                // if the toBeDeletedNode has right branch
                else if (toBeDeletedNode.getLeft() == null && toBeDeletedNode.getRight() != null) {
                    redirectNode(toBeDeletedNode, toBeDeletedNode.getRight());
                    return toBeDeletedNode;
                }

                // if the toBeDeletedNode has NO children
                else if (toBeDeletedNode.getLeft() == null && toBeDeletedNode.getRight() == null) {
                    redirectNode(toBeDeletedNode, null);
                    return toBeDeletedNode;
                }
            }
        }
        return null;
    }

    //----------------------------------//
    //   Find Min and Max Recursively   //
    //----------------------------------//
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

    //----------------------------------//
    //   Find Min and Max Iteratively   //
    //----------------------------------//
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

    //-----------------------------//
    //   Print Items Recursively   //
    //-----------------------------//
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

    //-----------------------------//
    //   Print Items Iteratively   //
    //-----------------------------//

}

// this is a generic class, creates Node<X> object!
class Node<X> {

    private X item;
    private Node<X> parent, left, right; // you can refer other objects here | this is 'linking' the objects!

    // this is how you _make_ the object
    public Node(X item){
        this.item = item;
        parent=left=right=null;
    }

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

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(10);
        tree.add(5);
        tree.add(12);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(15);
        tree.add(3);
        tree.add(14);

        tree.printPreOrderRecursive(tree.getRoot());

    }

}
