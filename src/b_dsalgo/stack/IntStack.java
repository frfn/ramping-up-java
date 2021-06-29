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

    public int pop() {
        int returnThis = head.data;
        head = head.next; // delete the head
        return returnThis;
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
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public boolean is3() {
        return head == null;
    }

    public void sort(IntStack stack) {
        IntStack tempStack = new IntStack();

        /*
        Logic:
        - https://www.youtube.com/watch?v=933UoS5iZPQ&ab_channel=GuruMack

        I did create this on my own, I white boarded how it is done and then coded it.

        Logic is:
        Keep the temporary stack in DESCENDING order. example: 1 2 3 4 5,

        - Start with 4 2 5 3 1

        stack   temp
        5       2
        3       4
        1

        Right now, if we add 5 to the temp, will it be descending order? No. SO pop 5, then pop all of temp back into stack, push 5, then readd 4 and 2
        - this will give us 2 4 5 in the temp!
         */

        while(!stack.is3()) {

            int poppedValue = stack.pop();
            System.out.println(poppedValue);

            while(!tempStack.is3() && tempStack.top() < poppedValue) {
                stack.push(tempStack.pop());
            }
            tempStack.push(poppedValue);
        }

        head = tempStack.head;

    }

}

class Node {
    int min;
    int data;
    Node next;
    Node(int val, int min) { this(val, min, null); }

    Node(int val, int min, Node next) {
        data = val; this.min = min; this.next = next; // <-- this.next refers to the node being created, "= next" is the HEAD, so we are prepending.
    }

}

class TestIntStack {
    public static void main(String[] args) {
        IntStack minStack = new IntStack();

        minStack.push(1); minStack.push(3); minStack.push(5);
        minStack.push(2); minStack.push(4);

        minStack.sort(minStack);

        minStack.print();

    }
}
