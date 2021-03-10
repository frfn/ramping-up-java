package DataStructure_Queue;

import java.sql.SQLOutput;

public class LinkedListQueue<X> {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.print();

        System.out.println();
        queue.dequeue();
        queue.dequeue();
        queue.print();

        while(!queue.isEmpty()){
            queue.dequeue();
        }

        System.out.println();
        queue.add(10);
        queue.print();
    }

    private static class Node<X>{
        private X data;
        private Node<X> next;
        public Node(X data){
            this.data = data;
        }
        public Node(){

        }
        public void setNext(Node<X> next){
            this.next = next;
        }
        public void setData(X data){
            this.data = data;
        }
        public Node<X> getNext() { return next; }
        public X getData(){
            return data;
        }
    }

    private Node<X> first, last;
    private int length;

    public LinkedListQueue(){
        first=last=null;
        length=0;
    }
    public int getLength() { return length; }
    public boolean isEmpty(){
        return length == 0;
    }
    public void add(X data){
        Node<X> node = new Node<>(data);
        if(isEmpty()){
            last = node;
            first = last;
        }
        else{
            last.setNext(node);
            last = last.getNext();
        }
        length++;
    }
    public void dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Empty queue...");
        }
        else{
            first = first.getNext();
            length--;
        }
    }
    public void print(){
        if(isEmpty()){
            throw new IllegalArgumentException("Empty queue...");
        }
        Node<X> current = first;
        while(current != null){
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
    }
}
