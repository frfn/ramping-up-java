package DataStructure_BinaryTree;

public class BinaryTree<X extends Comparable<X>> {

    private Node<X> root;
    private int size;

    // Constructor
    public BinaryTree(){
        root = null;
        size = 0;
    }

    // Utility Functions
    public boolean isEmpty(){
        return root == null;
    }
    public Node<X> getRoot() { return root; }

    // Add
    private void insert(Node<X> parent, Node<X> child){
        if(child.getData().compareTo(parent.getData()) <= 0){
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
            }
            else{
                insert(parent.getLeft(), child);
            }
        }
        else if(child.getData().compareTo(parent.getData()) > 0){
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
            }
            else{
                insert(parent.getRight(), child);
            }
        }
    }
    public void add(X data){
        Node<X> node = new Node<>(data);
        if(isEmpty()){
            root = node;
        }
        else{
            insert(root, node);
        }
        size++;
    }

    // Delete
    private Node<X> search(X data){
        Node<X> current = root;
        while(current != null){
            int compareValue = data.compareTo(current.getData());
            if(compareValue == 0){
                return current;
            }

            else if(compareValue <= 0){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }
        return null;
    }
    private void redirectNode(Node<X> current, Node<X> toNode){
        if(current == root){
            toNode.setLeft(current.getLeft());
            toNode.setRight(current.getRight());
            root = toNode;
        }
        else if(current.getParent().getRight() == current){
            current.getParent().setRight(toNode);
        }
        else{
            current.getParent().setLeft(toNode);
        }
    }
    public boolean delete(X data){
        boolean deleted = false;

        Node<X> currentNode = search(data);

        // THIS IS THE LAST CASE YOU HAVE TO WORRY ABOUT
        if(currentNode == root){
            Node<X> child = currentNode.getLeft();
            while(child.getLeft() != null || child.getRight() != null){
                child = child.getRight();
            }
            if (child != currentNode.getLeft()) {
                // after getting right most node from left child

                /**
                 * 1. set the right most node to null
                 * 2. the right most node will now set current node left and right
                 * 3. redirect pointer from parent of current node, to child
                 */
                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
            }
            child.setRight(currentNode.getRight());
            root = child;
            deleted = true;
        }
        else {
            if (currentNode != null) {
                //if currentNode has no branches
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    redirectNode(currentNode, null);
                    deleted = true;
                }
                //if currentNode has left branch
                else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                    redirectNode(currentNode, currentNode.getLeft());
                    deleted = true;
                }
                //if currentNode has right branch
                else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                    redirectNode(currentNode, currentNode.getRight());
                    deleted = true;
                }
                //if currentNode has both branch
                else {
                    Node<X> child = currentNode.getLeft();
                    while (child.getLeft() != null || child.getRight() != null) {
                        child = child.getRight();
                    }
                    if (child != currentNode.getLeft()) {
                        // after getting right most node from left child

                        /**
                         * 1. set the right most node to null
                         * 2. the right most node will now set current node left and right
                         * 3. redirect pointer from parent of current node, to child
                         */
                        child.getParent().setRight(null);
                        child.setLeft(currentNode.getLeft());  // child will get current node's left branch
                    }
                    child.setRight(currentNode.getRight());  // child will get current node's right branch
                    redirectNode(currentNode, child);  // redirect the current node, getParent().setLeft/Right(), set the child node
                    deleted = true;
                }
            }
        }
        return deleted;
    }

    // Find Min and Max
    public Node<X> findMin(){
        if(isEmpty()){
            return null;
        }
        Node<X> current = root;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
    public Node<X> findMax(){
        if(isEmpty()){
            return null;
        }
        Node<X> current = root;
        while(current.getRight() != null){
            current = current.getRight();
        }
        return current;
    }

    // Recursive Functions
    public boolean isBST(Node<X> current, X minValue, X maxValue){
        // KEY WORDS: current, minValue, maxValue
        /*
        * compare min <= current data && max > current data
        * current.getLeft, minValue, current.getData
        * current.getRight, current.getData, maxValue
        * */
        if(minValue.compareTo(current.getData()) <= 0 && maxValue.compareTo(current.getData()) > 0
            && isBST(current.getLeft(), minValue, current.getData())
            && isBST(current.getRight(), current.getData(), maxValue)){
                return true;
        }
        else {
            return false;
        }
    }
    public int heightOfTree(Node<X> current){
        int height;
        if(current == null){
            return 0;
        }
        int left = heightOfTree(current.getLeft());
        int right = heightOfTree(current.getRight());
        height = left > right ? left + 1 : right + 1;
        return height;

        /*
                            o
                           / \
                          o   o
                         / \   \
                        o  o    o
                       /         \
                      o           o
                                 /
                                o
         */

//        if(left > right){
//            height = 1 + left;
//        }
//        else{
//            height = 1 + right;
//        }


    }
    public boolean contains(Node<X> current, X data){
        boolean found = false;
        if(current != null){
            int compareValue = data.compareTo(current.getData());
            if(compareValue == 0){
                found = true;
            }
            else if(compareValue < 0){
                found = contains(current.getLeft(), data);
            }
            else{
                found = contains(current.getRight(), data);
            }
        }
        return found;
    }
    public Node<X> findMin(Node<X> current){
        if(current == null){
            return null;
        }
        else if(current.getLeft() == null){
            return current;
        }
        else{
            return findMin(current.getLeft());
        }
    }
    public Node<X> findMax(Node<X> current){
        if(current == null){
            return null;
        }
        else if(current.getRight() == null){
            return current;
        }
        else{
            return current.getRight();
        }
    }

    // Traversal Functions
    public void printInOrder(Node<X> current){
        if(current != null){
            printInOrder(current.getLeft());
            System.out.println(current.getData());
            printInOrder(current.getRight());
        }
    }
    public void printLevelOrder(){
        if(isEmpty()){
            System.out.println("Empty list...");
            return;
        }
        QueueBST<X> queue = new QueueBST<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<X> first = queue.getFirst();
            System.out.println(first.getData());
            if(first.getLeft() != null){
                queue.add(first.getLeft());
            }
            if(first.getRight() != null){
                queue.add(first.getRight());
            }
            queue.delete();
        }
    }
}

