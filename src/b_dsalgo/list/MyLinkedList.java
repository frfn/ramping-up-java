package b_dsalgo.list;

public class MyLinkedList<X extends Comparable<? super X>> {

    private Node<X> head;
    private int size;

    // ----------- //
    // Constructor //
    // ----------- //
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // --------- //
    // Utilities //
    // --------- //
    public Node<X> getHead() {
        return head;
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
    public void toPrint(Node<X> node) {
        Node<X> current = node;
        while(current != null) {
            System.out.print(current.getItem() + ", ");
            current = current.getNext();
        }
    }

    // --- //
    // Add //
    // --- //
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

    // ------ //
    // Delete //
    // ------ //
    public Node<X> delete(X item) {
        Node<X> deleted;
        Node<X> current = head;

        if(item.compareTo(head.getItem()) == 0) {
            deleted = head;
            head = head.next;
            size--;
            return deleted;
        }

        while(current != null) {
            if(item.compareTo(current.getNext().getItem()) == 0) {
                deleted = current.getNext();
                current.setNext(current.getNext().getNext());
                size--;
                return deleted;
            }
            current = current.getNext();
        }

        throw new IllegalArgumentException("Item does not exist...") ;
    }

    // --------------- //
    // Merge Two Lists //
    // --------------- //
    public Node<X> mergeTwoLists(Node<X> L, Node<X> R) {
       Node<X> sorted = new Node<>(null); // the place holder to stay in the beginning of the list
       Node<X> current = sorted; // created a reference to the beginning (sorted), current will be used as the iterator to move to current

       while(L != null && R != null) { // both has to be true to iterate
           if(L.getItem().compareTo(R.getItem()) <= 0) {
               current.setNext(L);
               L = L.getNext();
           }else{
               current.setNext(R);
               R = R.getNext();
           }
           current = current.getNext();
       }

        // for the remainder? | since the remainder is a linked list, the REFERENCE may or may not contain other nodes
        // R = 2, 4, 6
        // L = 1
        // 1, L is null, R
        // since L == null now, current's next WILL be 'R'. In this case, R is equals to -> 2, 4, 6

        // so list wil become, 1, 2, 4, 6!
        current.setNext(L == null ? R : L);

        return sorted.getNext();

        /*
        similar logic to an array, but you MUST iterate through the arrays AFTER (L != null && R != null) because though it will contain other values, it does chain liked a linked list
         */
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
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6); list.add(7); list.add(8); list.add(9);
        list.delete(9);
        list.toPrint();
    }
}