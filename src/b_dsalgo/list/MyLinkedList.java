package b_dsalgo.list;

public class MyLinkedList<X extends Comparable<? super X>> {

    private Node<X> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void toPrint() {
        Node<X> current = head;
        while(current != null) {
            System.out.print(current.getItem() + ", ");
            current = current.getNext();
        }
    }

    public boolean add(X item) {
        Node<X> newNode = new Node<>(item);
        if(isEmpty()) {
            head = newNode;
            size++;
        }
        else {
            Node<X> current = head;
            // next node shall not be null ... it must be an object you're landing on
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        return true;
    }

}

class Node<X> {

    X item;
    Node<X> next;

    public Node(X item) {
        this.item = item;
        this.next = null;
    }

    public X getItem() {
        return item;
    }

    public Node<X> getNext() {
        return next;
    }

    public void setItem(X item) {
        this.item = item;
    }

    public void setNext(Node<X> node) {
        this.next = node;
    }

}

class MyLinkedListMain {
    public static void main(String[] args){
        MyLinkedList<Integer> intList = new MyLinkedList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        intList.toPrint();
    }
}