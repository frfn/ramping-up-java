package b_dsalgo.list;
import java.util.HashSet;

public class IntLinkedList {

    int size;
    ListNode head;

    // ----------- //
    // constructor //
    // ----------- //
    public IntLinkedList() {
        size = 0;
        head = null;
    }

    // --------- //
    // head node //
    // --------- //
    public ListNode getHead() { return head; }

    // ----- //
    // empty //
    // ----- //
    public boolean isEmpty() { return head == null; }

    // -------- //
    // add node //
    // -------- //
    public void add(ListNode newNode) {
        if(head == null) {
            head = newNode; size++; return;
        }

        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        size++;
    }
    public void addNode(ListNode node, int data) {
        ListNode newNode = new ListNode(data);
        if(node == null) {
            head = newNode; size++; return;
        }

        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        size++;
    }

    // ------------ //
    // prepend node //
    // ------------ //
    public void prepend(int data) {
        ListNode newNode = new ListNode(data);
        if(!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    // ----------- //
    // insert node //
    // ----------- //
    public void insert(ListNode node, int index, int data) {
        if(index < 0 || index > size) throw new IllegalArgumentException("Out of bounds!");

        if(index == 1) {
            prepend(data); return;
        }

        ListNode current = node;
        int count = 1;

        while(count < index - 1) {
            count++;
            current = current.next;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // ----------- //
    // delete node //
    // ----------- //
    public ListNode delete(ListNode node, int data) {
        if(isEmpty()) throw new IllegalArgumentException("Empty list...");

        // if head
        if(data == head.val) {
            return deleteFirstNode(node, data);
        }

        ListNode current = node;
        while(current.next != null) {
            if(current.next.val == data) {
                current.next = current.next.next;
                size--;
                return current;
            }
            current = current.next;
        }

        throw new IllegalArgumentException("Does not exist...");
    }

    // ----------------- //
    // delete first node //
    // ----------------- //
    public ListNode deleteFirstNode(ListNode node, int data) {
        if(isEmpty()) throw new IllegalArgumentException("Empty list...");

        ListNode temp = node;

        node = node.next;
        head = node;

        temp.next = null; // unlinking head
        size--;

        return temp;
    }

    // --------------- //
    // add two numbers //
    // --------------- //
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode iterator = dummy; // for moving the node up

        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        int carry = 0;

        while(pointer1 != null || pointer2 != null) {
            // sum is important bc it accounts for the carry value
            int sum = carry;


            if(pointer1 != null && pointer2 != null) sum += pointer1.val + pointer2.val;
            else if(pointer1 != null) sum += pointer1.val;
            else sum += pointer2.val;

            // reasoning for this is that if sum is greater than 9, than we must carry!
            if(sum > 9) {
                int nodeToBePlaced = sum % 10; // grabs the remainder
                iterator.next = new ListNode(nodeToBePlaced);
                iterator = iterator.next; // move up!
                carry = sum / 10; // cuts the remainder off
            }

            else {
                iterator.next = new ListNode(sum);
                iterator = iterator.next;

                // [2,4,3]
                // [5,6,4]
                //  7 0 8 , if you don't do this, the carry will remain and give false values, carry will just be 1 at all times.
                if(carry > 0) {
                    carry /= 10;
                }
            }

            if(pointer1 != null) pointer1 = pointer1.next;
            if(pointer2 != null) pointer2 = pointer2.next;
        }
        if(carry != 0) iterator.next = new ListNode(carry);

        return dummy.next;

    }

    // ------- //
    // reverse //
    // ------- //
    public ListNode reverse(ListNode node) {
        if(node == null) return null;
        ListNode next, prev = null, current = node;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        return prev;
    }

    // ------ //
    // rotate //
    // ------ //
    public ListNode rotate(ListNode node, int index) {
        if(index == 0) return node;

        ListNode dummy = new ListNode(); ListNode iterate = dummy;
        ListNode current = node;

        int count = 1;
        while(count < index - 1) {
            current = current.next;
            count++;
        }

        dummy.next = current.next;
        current.next = null; // the reason why head changes as well is because the head AND current are pointing to the same pointer... they are the same element.

        while(iterate.next != null) {
            iterate = iterate.next;
        }

        iterate.next = node;

        return dummy.next;
    }
    public ListNode rotateFromEnd(ListNode node, int indexFromEnd) {
        ListNode current = node;
        int size = 1;

        // 1. get length
        while(current.next != null) {
            current = current.next;
            size++;
        }

        /*
        1 % 5 = 1
        ..
        4 % 5 = 4

        -->

        5 % 5 = 0
        6 % 5 = 1
        7 % 5 = 2
        ..
         */

        // 2. get the recalculated (if needed) iterations, argument index can be bigger than size!
        indexFromEnd %= size; // 7 % 5 = 2 | 5 - 2 = 3
        current.next = node; // creates the circular linked list

        // 3. note the size - indexFromEnd
        for(int i = 0; i < size - indexFromEnd; i++) {
            current = current.next;
        }

        // by visualizing this, it makes way more sense
        // lets say [current] = 5
        node = current.next;    // node = 1->...5->null | we are declaring the new [node] value
        current.next = null;    // 5.next = null
        return node;            // --> 1,2,3,4,5,null
    } // circular linked list

    // ----------------------- //
    // get n-th node from last //
    // ----------------------- //
    public ListNode getNthNodeFromEnd(ListNode node, int indexFromEnd) {
        if(isEmpty()) return null;

        ListNode current = node;
        ListNode refPointer = node;

        //       2
        // 1 2 3 4 5
        //   ^ - refPointer
        //       ^ - current!

        int counter = 1;
        while(counter < indexFromEnd && refPointer != null) {
            counter++;
            refPointer = refPointer.next;
        }
        while(refPointer != null && refPointer.next != null) {
            current = current.next;
            refPointer = refPointer.next;
        }
        return current;
    } // uses referencePointer to move up by index, then uses pointer to go forward
    public ListNode getNthNodeSimilarAlgToRotateFromEnd(ListNode node, int indexFromEnd) {

        int size = 1;
        ListNode current = node;
        while(current.next != null) {
            current = current.next;
            size++;
        }

        indexFromEnd %= size; // gets remainder
        current.next = node;

        for(int i = 0; i < size-indexFromEnd; i++) {
            current = current.next;
        }

        return current.next;

    } // circular linked list

    // ------- //
    // is loop // Floyd's Detection Loop!
    // ------- //
    public boolean isLoop(ListNode node) {
        ListNode slowPtr = node, fastPtr = node;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) return true;
        }
        return false;
    }

    // --------------------- //
    // where does loop begin //
    // --------------------- //
    public ListNode beginningOfLoop(ListNode node) {
        ListNode slowPtr = node, fastPtr = node;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
               return getStartOfLoop(slowPtr);
            }
        }
        return null;
    }
    private ListNode getStartOfLoop(ListNode slowPtr) {
        ListNode temp = head;

        while(temp != slowPtr) { // this will land on the starting node
            temp = temp.next;
            slowPtr = slowPtr.next;
        }

        return temp; // this will be the starting node of the loop | this is the Floyd's Detection Algorithm!
    }

    // -------------- //
    // take loop away //
    // -------------- //
    public void cutLoop(ListNode node) {
        ListNode slowPtr = node, fastPtr = node;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
               cut(slowPtr);
               return; // this breaks the while loop!
            }
        }
    }
    private void cut(ListNode slowPtr) {
        ListNode temp  = head;

        while(temp.next != slowPtr.next) { // we want to go to a node before the starting node
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null; // this will be the node right before the starting node!
    }

    // --------------- //
    // get middle node //
    // --------------- //
    public ListNode getMiddle(ListNode node) {
        if(isEmpty()) return null;

        ListNode slowPtr = node, fastPtr = node.next;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // ----------------- //
    // merge sorted list //
    // ----------------- //
    public ListNode sortLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyIterator = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                dummyIterator.next = l1;
                l1 = l1.next;
            }
            else {
                dummyIterator.next = l2;
                l2 = l2.next;
            }
            dummyIterator = dummyIterator.next;
        }
        dummyIterator.next = l1 == null ? l2 : l1;

        return dummy.next;

    }

    // ---------- //
    // merge sort //
    // ---------- //
    public ListNode mergeSort(ListNode l) {
        if(l == null || l.next == null) return l;

        ListNode middle = getMiddle(l);
        ListNode halfOfList = middle.next;
        middle.next = null;

        ListNode left = mergeSort(l);
        ListNode right = mergeSort(halfOfList);

        return sortLists(left,right); // returns a node
    }

    // ----------------- //
    // intersection node // Similar to Floyd's Loop Detection
    // ----------------- //
    public ListNode intersectionNode(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;

        ListNode a = l1;
        ListNode b = l2;

        while(a != b) {
            a = a == null ? l2 : a.next;
            b = b == null ? l1 : b.next;
        }

        return a;
    }

    // --------------------------- //
    // remove dupes in sorted list //
    // --------------------------- //
    public ListNode removeDupesInSorted(ListNode node) {
        if(node == null) return null;

        ListNode current = node;

        while(current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return node;
    }

    // ----------------------------- //
    // remove dupes in unsorted list //
    // ----------------------------- //
    public ListNode removeDupesInUnsorted(ListNode node) {
        if(node == null) return null;

        HashSet<Integer> set = new HashSet<>();
        ListNode current = node;
        ListNode pointer = null; // keeps track of new value

        while(current != null) {
            if(set.contains(current.val)){
              pointer.next = current.next;
            }
            else {
                set.add(current.val);
                pointer = current; // new value is here!
            }
            current = current.next;
        }
        return node;
    }

    // ------------------ //
    // is list palindrome //
    // ------------------ //
    public boolean isPalindrome(ListNode node) {
        if(node == null) return true;

        ListNode middle = getMiddle(node);
        ListNode half = middle.next;
        middle.next = null;

        ListNode halfReversed = reverse(half);
        ListNode current = node;

        while(halfReversed != null) {
            if(current.val != halfReversed.val) return false;

            current = current.next;
            halfReversed = halfReversed.next;

        }
        return true;
    }

    // ------------- //
    // printing list //
    // ------------- //
    public void print(ListNode node) {
        ListNode current = node;
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class TestIntLinkedList {

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;

        list.add(one);

        System.out.println(list.isLoop(one));               // is loop?
        System.out.println(list.beginningOfLoop(one).val);  // start of loop?
        list.cutLoop(list.getHead());                       // cut loop!
        list.print(list.getHead());                         // the algorithm works.
    }
}