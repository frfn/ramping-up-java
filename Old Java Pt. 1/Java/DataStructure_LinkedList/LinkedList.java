package DataStructure_LinkedList;
import java.util.HashSet;

@SuppressWarnings("ALL")  // this just suppresses the warnings "method has NOT been used"
public class LinkedList<X extends Comparable<X>> {
    /**
     * Generic Linked List Node class
     * @param <X>
     */
    private static class Node<X>{
        private X data;
        private Node<X> next;

        public Node(X data){
            this.data = data;
        }

        public Node(){
            data = null;
        }

        public Node<X> getNext() {
            return next;
        }

        public X getData() {
            return data;
        }

        public void setNext(Node<X> next) {
            this.next = next;
        }

        public void setData(X data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(1);
        l1.add(3);
        l1.add(4);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(3);

        Node sorted = l1.merge(l1.head, l2.head);
        l1.print(sorted);
    }

    private Node<X> head;
    private int length;

    public boolean isEmpty(){
        return length == 0;
    }

    public LinkedList(){
        head = null;
        length = 0;
    }

    public void print(Node<X> node){
        Node<X> current = node;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    public void add(X data){
        if(data == null){
            System.out.println("Error");
            return;
        }
        Node<X> node = new Node<>(data);
        if(isEmpty()){
            head = node;
        }
        else{
            Node<X> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
        }
        length++;
        return;
    }

    public void prepend(X data){
        if(data == null){
            System.out.println("Error");
            return;
        }
        Node<X> node = new Node<>(data);
        if (!isEmpty()) {
            node.setNext(head);
        }
        head = node;
        length++;
        return;
    }

    public X delete(X data){
        X deleted = data;

        if(data.compareTo(head.getData()) == 0){
            head = head.next;
            length--; return deleted;
        }

        Node<X> current = head;
        while(current.getNext() != null){
            if(data.compareTo(current.getNext().getData()) == 0){
                current.setNext(current.getNext().getNext());
                length--; return deleted;
            }
            current = current.getNext();
        }

        return deleted;
    }

    public X removeAtIndex(int index){
        X deleted = null;
        Node<X> current = head;

        if(index < 0 || index > length-1){
            System.out.println("Invalid index...");
        }
        else if(index == 0){
            deleted = head.getData();
            delete(deleted);
            return deleted;
        }
        else{
            int i=0;
            while(current != null){
               if(i+1 == index){
                   deleted = current.getNext().getData();
                   current.setNext(current.getNext().getNext());
                   length--;
                   return deleted;
               }

                current = current.getNext();
                i++;
            }
        }

        return deleted;
    }

    public boolean isLoop(){
        Node<X> slowPtr = head; Node<X> fastPtr = head;

        while(fastPtr != null){
            if(slowPtr == fastPtr){
                return true;
            }
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        return false;
    }

    public void rotateAt(X data){
        Node<X> newHead = null,
                addToNewHead = null;

        Node<X> current = head;
        while(current.getNext() != null){
            if(data.compareTo(current.getNext().getData()) == 0){
                newHead = current.getNext();
                current.setNext(null);

                addToNewHead = head;

                current = newHead;

                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(addToNewHead);
                head = newHead;
                return;
            }
            current = current.getNext();
        }
    }

    public Node<X> getNthNodeFromEnd(int index){
        Node<X> nthNode = null;

        if(index+1 > length || index < 0){
            throw new NullPointerException("Invalid index...");
        }

        Node<X> current = head,
                refPtr = head;

        int counter = 0;
        while(counter < index){
            refPtr = refPtr.getNext();
            counter++;
        }

        while(refPtr.getNext() != null){
            current = current.getNext();
            refPtr = refPtr.getNext();
        }
        nthNode = current;
        return nthNode;
    }

    public Node<X> getMiddleNode(Node<X> node){
        /**
         * This will favor left side having more elements
         *
         * ex. 7 elements = Left: 4 -- Right: 3
         */

        Node<X> slowPtr = node,
                fastPtr = node.getNext();

        while(fastPtr != null && fastPtr.getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        return slowPtr;
    }

    private Node<X> merge(Node<X> L, Node<X> R){
        Node<X> temp = new Node<>();
        Node finalList = temp;  // this is here so we can return it, that's the sole purpose. Temp moves... so yeah.

        while(L != null && R != null){
            if(L.getData().compareTo(R.getData()) <= 0){
                temp.setNext(L);
                L = L.getNext();
            }
            else{
                temp.setNext(R);
                R = R.getNext();
            }
            temp = temp.getNext(); // this is the mover, the setNext(node) just sets the value at this current
        }
        temp.setNext(L == null ? R : L);

        return finalList.getNext();
    }

    public Node<X> mergesort(Node<X> node){
        /**
         * Base Case: Hot Spot
         * Think of recursive functions, will always have a base case
         */
        if(node == null || node.getNext() == null){
            return node;
        }

        Node middle = getMiddleNode(node);
        Node secondHalf = middle.getNext();
        middle.setNext(null);

        // Note: we use "node" here, node refers to the beginning of current list
        Node<X> left = mergesort(node);
        Node<X> right = mergesort(secondHalf);

        return merge(left, right);
    }

    public void setHead(Node<X> node){
        head = node;
    }

    public void removeDuplicates(){
        HashSet<X> set = new HashSet<>();

        Node<X> current = head;
        Node<X> prev = null;
        while(current != null){
            if(set.contains(current.getData())){
                prev.setNext(current.getNext());
            }
            else{
                set.add(current.getData());
                prev = current;
            }
            current = current.getNext();
        }
    }

    public Node<X> reverse(Node<X> node){
        Node<X> prev = null,
                after = null,
                current = node;

        while(current != null){
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }

        return prev;
    }

    public Node<X> deleteMiddleNode(){
        Node<X> middleNode = getMiddleNode(head);
        delete(middleNode.getData());
        return middleNode;
    }

    public void partition(X data){
        Node<X> lessThan = new Node<>(),
                greaterThan = new Node<>(),
                list1 = lessThan,
                list2 = greaterThan,
                current = head;

        while(current != null){
            if(data.compareTo(current.getData()) >= 0){
                lessThan.setNext(current);
                lessThan = lessThan.getNext();
            }
            else{
                greaterThan.setNext(current);
                greaterThan = greaterThan.getNext();
            }
            current = current.getNext();
        }

        // this is IMPORTANT, we have to set next nodes to null for printing!
        lessThan.setNext(null);
        greaterThan.setNext(null);

        System.out.println("Less than or equal to " + data + ": ");
        print(list1.getNext());

        System.out.println();

        System.out.println("Greater than " + data + ": ");
        print(list2.getNext());

    }

    public boolean isPalindrome(){
        boolean palindrome = true;
        Node<X> slowPtr = head,
                fastPtr = head;

        while(fastPtr != null && fastPtr.getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        slowPtr = reverse(slowPtr);
        fastPtr = head;

        /**
         * slowPtr keeps its position, so even if odd, slowPointer will become null and not compare!
         * slowPtr will already by half way!
         */
        while(slowPtr != null) {
            palindrome = slowPtr.getData().compareTo(fastPtr.getData()) != 0 ? false : true;
            if(palindrome == false){
                return false;
            }
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext();
        }

        return palindrome;
    }

    // Recursive Methods
    public void reverseRecursive(Node<X> node){
        if(node.getNext() == null){
            head = node;
            return;
        }
        reverse(node.next);

        /**
         * 1, 2, 3, 4
         *
         * node.getNext() = 4
         * node           = 3
         *
         * 4 --> 3 --> null
         */

        Node<X> current = node.getNext();
        current.setNext(node);
        node.setNext(null);
    }

}
