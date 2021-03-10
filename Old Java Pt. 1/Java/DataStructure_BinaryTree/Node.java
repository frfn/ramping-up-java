package DataStructure_BinaryTree;

public class Node<X> {

    private X data;
    protected Node<X> parent, left, right, next;

    public Node(X data){
        this.data = data;
        parent=left=right=next=null;
    }
    public X getData() {
        return data;
    }
    public Node<X> getRight() {
        return right;
    }
    public Node<X> getLeft() {
        return left;
    }
    public Node<X> getParent() { return parent; }

    public void setData(X data) {
        this.data = data;
    }
    public void setLeft(Node<X> left) {
        this.left = left;
    }
    public void setRight(Node<X> right) {
        this.right = right;
    }
    public void setParent(Node<X> parent) {
        this.parent = parent;
    }
}
