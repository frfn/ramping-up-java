package b_dsalgo.list;

import java.util.NoSuchElementException;

public class IntDoublyLinkedList {

    private DLLNode head;
    private DLLNode tail;
    private int length;

    public IntDoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }


    // Functionality
    public boolean isEmpty() { return length == 0; }
    public DLLNode getHead() { return head; }
    public DLLNode getTail() { return tail; }
    public int length() { return length; }


    // Print Functions
    public void printFromHead() {
        if(head == null) return;

        DLLNode current = head;

        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }

        System.out.println("null");
    }
    public void printFromTail() {
        if(tail == null) return;

        DLLNode current = tail;

        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.prev;
        }

        System.out.println("null");
    }


    // Prepend ( insert at beginning! -- the only thing you have to keep in mind is if list is empty! )
    public void prepend(int data) {
        DLLNode newNode = new DLLNode(data);

        if(isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    // Append ( way easier to add to the end! )
    public void append(int data) {
        DLLNode newNode = new DLLNode(data);

        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        length++;
    }

    public void addSorted(int data) {
        if(head == null) {
            prepend(data);
            return;
        }

        else if(data < head.data) {
            prepend(data);
            return;
        }

        DLLNode newNode = new DLLNode(data);
        DLLNode current = head;


        while(current.next != null) {
            if(data < current.next.data) {
                break;
            }
            current = current.next;
        }

        if(current.next != null) {
            current.next.prev = newNode;
        }

        newNode.prev = current;
        newNode.next = current.next;
        current.next = newNode;

        if(data > tail.data) {
            tail = newNode;
        }

        length++;
    }


    // Delete Head - you must not forget to break chain
    public DLLNode deleteHead() {
        if(isEmpty()) throw new NoSuchElementException();

        DLLNode temp = head;

        if(head == tail) {
            tail = null;
        } else {
            head.next.prev = null; // makes sense, unlinking the prev! would make sense when whiteboarded
        }

        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }

    // Delete Tail
    public DLLNode deleteTail() {
        if(isEmpty()) throw new NoSuchElementException();

        DLLNode temp = tail;

        if(tail == head) {
            head = null;
        } else {
            tail.prev.next = null;
        }

        tail = tail.prev;
        temp.prev = null;

        return temp;

    }

}

class DLLNode {

    DLLNode prev;
    int data;
    DLLNode next;

    public DLLNode(int data) { this.data = data; }

}

class TestDLL {

    public static void main(String[] args) {

        IntDoublyLinkedList dll = new IntDoublyLinkedList();
        dll.addSorted(1);
        dll.addSorted(3);
        dll.addSorted(5);
        dll.addSorted(2);
        dll.addSorted(4);
        dll.addSorted(6);

        dll.prepend(0);
        dll.append(10);

        dll.addSorted(8);
        dll.addSorted(9);
        dll.addSorted(7);

        System.out.println("From Head: ");
        dll.printFromHead();

        System.out.println();

        System.out.println("From Tail: ");
        dll.printFromTail();

    }


}