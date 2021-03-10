package DataStructure_BinaryTree;

public class QueueBST<X> {
    private Node<X> first, last;
    private int length;
    public QueueBST(){
        first=last=null;
        length = 0;
    }
    public boolean isEmpty(){ return first == null; }
    public Node<X> getFirst() { return first; }
    public int getLength() { return length; }
    public void add(Node<X> data){
        if(isEmpty()){
            last = data;
            first = last;
        }
        else{
            last.next = data;
            last = last.next;
        }
        length++;
    }
    public boolean delete(){
        if(isEmpty()) {
            System.out.println("Empty list...");
            return false;
        }

        first = first.next;  // till null :)
        length--;
        return true;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("Empty list...");
        }
        Node<X> current = first;
        while(current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }

}
