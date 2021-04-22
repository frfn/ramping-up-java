package b_dsalgo.list;

import java.util.HashSet;
import java.util.Set;

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
    public int getSize() { return size; }
    public X toString(Node<X> node) {
        return node.getItem();
    }
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

    // ------ //
    // isLoop //
    // ------ //
    public boolean isLoop(Node<X> node) {
        Node<X> slowPtr, fastPtr;
        slowPtr=fastPtr=head;
        while(fastPtr != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    // --- //
    // Add //
    // --- //
    public boolean prepend(X item) {
        Node<X> newNode = new Node<>(item);
        if(!isEmpty()) {
            newNode.setNext(head);
        }
        head = newNode;
        size++;
        return true;
    }
    public boolean add(X item) {
        Node<X> newNode = new Node<>(item);
        if(isEmpty()) {
            head = newNode;
        }
        else {
            Node<X> current = head;
            // next node shall not be null ... it must be an object you're landing on
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
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
    public boolean deleteAtIndex(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Given index is invalid!");

        Node<X> current = head;
        int currentIndex = 0;

        if(index == 0) {
            head = head.next;
            size--;
            return true;
        }

        while(current != null) {
            if(currentIndex + 1 == index) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
            currentIndex++;
        }
        size--;
        return true;
    }

    // ------ // 1 2 3 4 5 6 7 8 9
    // Rotate // 5 6 7 8 9 1 2 3 4
    // ------ // rotate at 5
    public Node<X> rotateAt(X item) {
        if(item.compareTo(head.getItem()) == 0) {
            return head;
        }
        Node<X> current = head;
        Node<X> rotated = new Node<>(null);
        while(current != null) {
            if(item.compareTo(current.getNext().getItem()) == 0) {
                rotated.setNext(current.getNext());
                current.setNext(null);
            }
            current = current.getNext();
        }

        /* System.out.println("Head value: "); toPrint(head); */

        Node<X> iterator = rotated.getNext(); // from the dummy node, you move up one
        // .getNext because I want to land on a Node, not on null!
        while(iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(head);
        return rotated.getNext();
    }

    //       0            1            2            3            4             5   | index
    //       1            2            3            4            5             6   | length
    // 10 % 6 = 4    ...    6 - 4 = 2    ...   rotate at NODE 5
    // k = k % length ... -> i < length - k

    public Node<X> rotateFromEnd(Node<X> head, int k) {
        if(k == 0) return head;
        if(head == null) return null;

        Node<X> current = head;

        int length = 1;
        while(current.getNext() != null) {
            current = current.getNext(); length++;
        }

        current.setNext(head);

        k = k % length; // important logic

        for(int i = 0; i < length - k; i++) {
            current = current.getNext();
        }

        head = current.getNext();
        current.setNext(null);
        return head;

    }

    // ----------------------- //
    // Get N-Th node from last //
    // ----------------------- //
    // with size given
    public Node<X> getNthNodeFromEndOfList(int position) {
        if(position >= size || size < 0) throw new NullPointerException("Null exception!");

        int counter = 0;
        Node<X> referencePtr, current;
        referencePtr=current=head;
        while(counter < position) {
            referencePtr = referencePtr.getNext();
            counter++;
        }
        while(referencePtr != null) {
            current = current.getNext();
            referencePtr = referencePtr.getNext();
        }
        return current;
    }

    // no size is given
    public Node<X> getNthNodeFromEOL(int position) {
        if(position == 0) return null;

        Node<X> current = head;
        int length = 1;
        while(current.next != null) {
            current = current.next;
            length++;
        }

        position %= length;
        current = head;

        for(int i = 0; i < length - position; i++) {
            current = current.next;
        }

        return current;

    }

    // ----------- //
    // Middle Node // in favor of left, more elements on left side!
    // ----------- //
    public Node<X> getMiddleNode(Node<X> node) {
        Node<X> slowPtr = node, fastPtr = node.getNext(); // without getNext, it will fail for even numbers
        // s s
        // 1 2 3 4 null
        //   f   f

        // s s s s -> return 4
        // 1 2 3 4 5 6 7 null
        //   f   f   f   f
        while(fastPtr != null && fastPtr.getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        return slowPtr;
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

    // ---------- //
    // Merge Sort //
    // ---------- //

    // 6 4 2 5 1 3 5 7

    // LEFT BRANCH          // RIGHT

    // 6 4 2 5              // 1 3 5 7

    // 6 4                  // 1 3
    // 6                    // 1
    // 4                    // 3
    // 4 6                  // 1 3
    // 6 4

    // 2 5                  // 5 7
    // 2                    // 5
    // 5                    // 7
    // 2 5                  // 57
    // 2 5

    // 2 4 5 6              // 1 3 5 7

    // 1 2 3 4 5 5 6 7
    public Node<X> mergesort(Node<X> node) {
        if(node == null || node.getNext() == null) {
            return node; // when it reaches the final recursive step
        }
        Node<X> middle = getMiddleNode(node);
        Node<X> half = middle.getNext();
        middle.setNext(null);

        Node<X> left = mergesort(node);
        Node<X> right = mergesort(half);

        return mergeTwoLists(left, right);

    }

    // ------- // 1 2 3 4 null
    // Reverse // 4 3 2 1 null
    // ------- //
    public Node<X> reverseInPlace(Node<X> node) {
        Node<X> reversed, after;
        Node<X> current = node;
        reversed=null; //null will be end of reversed
        while(current != null){
            after = current.getNext(); // get next of current
            current.setNext(reversed); // set current to reversed, first one is to null
            reversed = current; // reversed is pointer to null, current is assigned to reverse, reverse is now 1
            current = after; // iterator!
        }
        return reversed;
    }

    public void reverseRecursive(Node<X> node) {

        // 1 2 3 null
        // 1
        // 2 will return here, at 2, node == 2
        // 3 head
        // null, now bubble out
        if(node.getNext() == null) {
            head = node; return;
        }

        reverseRecursive(node.getNext());

        Node<X> current = node.getNext(); // current is 3, then current 2
        current.setNext(node); // so  current == 3, node == 2, 3 -> 2 -> 3 -> null, then current == 2, node == 1
        node.setNext(null); // 3 -> 2 -> null, then 3 -> 2 -> 1 -> null

    }

    // ---------- // 1 2 3 2 1 null = true
    // Palindrome // 1 2 3 1 2 null = false
    // ---------- //
    public boolean isPalindrome(Node<X> node) {
        if(getSize() == 1) return true;

        Node<X> middleNode = getMiddleNode(node); // there's more elements in this list, bc of the algorithm for getMiddleNode
        Node<X> reversed = reverseInPlace(middleNode.getNext());
        middleNode.setNext(null);

        while(reversed != null) {
            if(node.getItem().compareTo(reversed.getItem()) != 0) {
                return false;
            }
            reversed = reversed.getNext();
            node = node.getNext();
        }

        return true;
    }

    // ------------ // 1 1 2 2 3 3 3 4 5 5 5 null = 1 2 3 4 5 null
    // Remove Dupes //
    // ------------ //
    public void removeDuplicates() {
        Node<X> current = head;
        Node<X> pointer = null;

        HashSet<X> set = new HashSet<>();
        while(current != null) {
            if(set.contains(current.getItem())) {
                pointer.setNext(current.getNext());

            } else {
                set.add(current.getItem());
                pointer = current;
            }

            current = current.getNext();
        }
    }

    public Node<X> removeDupesInSortedList(Node<X> head) {
        Node<X> current = head;

        while(current != null && current.getNext() != null) { // the current.getNext() is the off by one cause ( -1 )
            if(current.getItem() == current.getNext().getItem()) {
                current.setNext(current.getNext().getNext());
            }
            else {
                current = current.getNext();
            }

        }
        return head;
    }

    public Node<X> removeDuplicatesFromASortedList(Node<X> node) {
        HashSet<X> set = new HashSet<>();

        Node<X> removedDupes = new Node<>(null); // this has next
        Node<X> notDupe = removedDupes; // temp variable
        Node<X> current = node;

        while(current != null) {
            if(set.contains(current.getItem())) {
                notDupe.setNext(current.getNext());
            } else {
                set.add(current.getItem());
                notDupe.setNext(current);
                notDupe = notDupe.getNext(); // only move when there is a new value
            }
            current = current.getNext();
        }
        return removedDupes.getNext();
    }

    // ---------------- // 2 4 6 8 \
    // Find Merge Point //          9 10 null
    // ---------------- // 5 6 7 8 /
    public X findMergeNode(Node<X> list, Node<X> otherList) {
        Node<X> currentList = list;
        Node<X> currentOtherList = otherList;
        Set<Node<X>> set = new HashSet<>();

        while(currentList != null) {
            set.add(currentList);
            currentList = currentList.getNext();
        }

        for(Node<X> node: set) {
            System.out.println(node.getItem());
        }

        while(currentOtherList != null){
            if(set.contains(currentOtherList)){
                return currentOtherList.getItem();
            }
            currentOtherList = currentOtherList.getNext();
        }

        return null;

    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    public Node<X> getIntersectionNode(Node<X> headA, Node<X> headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        Node<X> a = headA;
        Node<X> b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.getNext();
            b = b == null ? headA : b.getNext();
        }

        return a;
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
        list.add(1); list.add(2); list.add(3); list.add(4);

        list.toPrint(list.getHead());

        System.out.println();

        /*
        // the driver for finding merged point
        Node<Integer> current = list2.getHead();
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(list.getHead().getNext().getNext().getNext().getNext().getNext());
        System.out.println(list.findMergeNode(list.getHead(), list2.getHead()));
        */
    }
}
/*
First Iteration.
public Node<X> rotateRight(Node<X> head, int k) {
        if(head == null) return null;
        if(k == 0) return head;

        int length = 1;
        Node<X> current = head;
        while(current.getNext() != null) {
            current = current.next;
            length++;
        }

        System.out.println("length: "+length);


        int rotateAt = length - k; // 5 - 1 = 4

        System.out.println("rotate at: "+rotateAt);

        current = head;
        Node<X> dummy = new Node<>(null);
        int index = 0;

        while(current.next != null) {
            if(index+1 == rotateAt) {
                System.out.println("index: "+index);
                dummy.next = current.next;
                current.next = null;

                Node<X> iterator = dummy.getNext();
                while(iterator.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = head;
                break;
            }
            index++;
            current = current.next;
        }
        return dummy.next;
    }
 */