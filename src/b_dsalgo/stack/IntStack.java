package b_dsalgo.stack;

// LIFO - Last In First Out

public class IntStack {

    private Node head;

    /*
    No need for a constructor, we are given default!
    public IntStack() {
        head = null;
    }
    */


    // 8 <- head

    // new Node(2, min(2,8), 8) <-- then this becomes head!
    public void push(int val) {
        if(head == null) head = new Node(val, val);
                    //data = val; this.min = min; this.next = next;

        else head = new Node(val, Math.min(val, head.min), head); // this says PREPEND, then set the new node as the head.
    }

    public void pop() {
        head = head.next; // delete the head
    }

    public int top() {
        return head.data; // return the data
    }

    public int getMin() {
        return head.min;
    }

    public void print() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}

class Node {
    int min;
    int data;
    Node next;
    Node(int val, int min) { this(val, min, null); }

    Node(int val, int min, Node next) {
        data = val; this.min = min; this.next = next; // <-- this syntax for stack is cool.
    }

}

class TestIntStack {
    public static void main(String[] args) {
        IntStack minStack = new IntStack();

        minStack.push(-2); minStack.push(0); minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.getMin());

    }
}
