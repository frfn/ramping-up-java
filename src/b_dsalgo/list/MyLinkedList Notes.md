# Linked List

## utilities
- `getSize()` - returns the size of linked list
- `toString()` - prettifies the node to be printed
- `getHead()` - returns the first element of LL
- `isEmpty()` - returns true or false if empty
- `toPrint()` - prints the LL from beginning or specified node

## isLoop
- uses two pointers
    - ptr1: `ptr1 = ptr1.next;`
    - ptr2: `ptr2 = ptr2.next.next;`
    
- see if `ptr1 == ptr2`. If they do, LL does loop!

## prepend, add

- Prepend: `node`.next = head; head = `node`
- Add: iterates to the end of LL
    - make sure condition is `current.getNext != null`, we want to land on a node, not on null!

## delete, deleteAtIndex

- delete(X item): iterates through the LL till it finds the item, skip this item and relink!
    - special case: if head; then `head = head.next`
- deleteAtIndex: iterates through the LL till the index is found, skip this item and relink!
    - special case:
        - make sure index is not greater than size or less than 0
        - if head, then `head = head.next`
    
## rotate

- ex. 1 -> 2 -> 3 -> 4 -> 5 -> null , `rotate at 3`, 3 -> 4 -> 5 -> 1 -> 2 -> null
- logic 
    - create dummy node
    - iterate till it finds the item you are looking for to rotate at
    - set dummy node to hold the node we're looking for (may contain other nodes!),
    - `current.setNext(null)` so that we cut off the reference! 
    - set the current to head again to start from the beginning
    - iterate the dummy node to it's last node. `current.getNext() != null`, then add the current!

## getNthNodeFromEndOfList

- 1 2 3 4 5, value = 2, will return 4
- logic have two pointers, iterate the refPointer by the value 
- iterate with currentPointer and refPointer until refPointer is null, return current!

## getMiddleNode

- two pointers: `slowPointer`, `fastPointer`
    - `slowPointer = current;`
    - `fastPointer = current.getNext();` while `fastPointer != null && fastPointer.getNext() != null`
    - return slowPointer
    
## mergeSort | mergeTwoLists

- mergeTwoLists merges lists, works best when lists are sorted!
    - logic:
        - create a dummy node and an iterator!
        - `while(l1 != null && l2 != null)` see if the value from L1 < L2
        - iterator = iterator.next  
        - if less than, set iterator.next to this value, l1 = l1.next
        - else, set iterator.next to this value, l2 = l2.next
        - if any leftovers: if l1 == null ? l2 : l1;
        - return dummyNode.next!
    
- mergeSort
    - logic: 
        - split the LL into two
        - recursively call until the LL is split into one element
        - call mergeTwoLists and merge LEFT and RIGHT nodes! (this is the bulk of implementation!)
    
## reverse

- reversing a linked list: 1 2 3 null -> 3 2 1 null
- logic:
    - create Node<X> next; Node<X> reversed = null;
    - 4 easy steps
        - next = current.next // iterator | keeping track of next node
        - current.next = reversed // logic | setting current next to reversed (first iteration, set to NULL)
        - reversed = current // logic  | setting the pointer from (NULL if first iteration) to CURRENT
        - current = next; // iterator | going to next node

    - recursive? Think of it as a stack
        - base case: `if(node.getNext() != null) { head = node; return; }`
        - grab the next node, set next node(the bigger number) -> current node(the smaller number)
    
## palindrome

- logic:
    
    - grab middle node
    - reverse the second list
    - while second list != null, compare values if they are equal
        - if not return false, else true

## removeDupes

- logic: 
    - two pointers
        - current: iterator
        - pointer: value will be pointer if value is NOT in hashSet
    - important logic
        - must set pointer to a new value not in set
        - if in set, pointer.setNext(current.getNext());

# Node<X> 

- A node class that generates nodes