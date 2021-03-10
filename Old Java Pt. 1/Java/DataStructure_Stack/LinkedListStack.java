package DataStructure_Stack;

public class LinkedListStack<X> {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.print();

        System.out.println();
        stack.pop(); stack.pop();
        stack.print();
    }

    private static class Node<X> {
        private X data;
        private Node<X> next;
        public Node(X data){ this.data = data; }
        public X getData() { return data; }
        public Node<X> getNext() { return next; }
        public void setData(X data) { this.data=data; }
        public void setNext(Node<X> next){ this.next=next; }
    }

    private Node<X> top;
    private int size;

    public LinkedListStack(){ top=null; size=0; }
    public int getSize() { return size; }
    public boolean isEmpty() { return size==0; }
    public void push(X data){
        Node<X> node = new Node<>(data);
        if (!isEmpty()) {
            node.setNext(top);
        }
        top = node;
        size++;
    }
    public X pop(){
        X item = top.getData();
        if(isEmpty()){
            throw new IllegalArgumentException("Empty stack...");
        }
        top = top.getNext();
        size--;
        return item;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("Empty queue...");
        }
        Node<X> current = top;
        while(current != null){
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
    }
}
