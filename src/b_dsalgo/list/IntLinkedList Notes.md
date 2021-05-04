# Integer Linked List

Reason behind creating this was that I could not so algorithm questions with generics as easy I'd like. So I created another Linked List class.

# ListNode

A simple node class
- `int val` for data
- `ListNode next` for next reference

# TestIntLinkedList

Driver class where we can test the Linked List Data Structure
- `psvm` is here and runs the program

# IntLinkedList

The Linked List Data Structure, the node has a reference to the next object.

Below will explain the methods in a simple, easy to understand way. No algorithms, but a good explanation.

## getHead()
Returns the head.

## isEmpty()
Returns false if Linked List is empty.

## add()
- If List is empty, `head` will be the new ListNode
- Else, create a temp node called `current`, traverse to the end of List `(current.next != null)`, current's next will be the new Node
- There are two methods for `add()`, either `(ListNode node, int data)` or `(int data)`

## prepend()
- Attaches new ListNode to beginning of List
- new Nodes next is head, new Node will become head

## insert()
- Same as add, but instead has a index to keep track off, create a counter variable
- Create temp variable called current and iterate through LL, increase count by 1, when `index - 1` is true, you are now at index
- Relink the nodes

## delete()
- Deletes node by skipping over and using `current.next = current.next.next`

## deleteFirstNode()
- Deletes the head
- Create a temp variable called `temp` which points to head
- `head = head.next`, `temp.next = null` to unlink from LL

## addTwoNumbers()
- Adds two Linked List
- 1. Conditionals to see if the pointers are null, if not add to the `sum`
- 2. If `sum` is greater than 9, we will get the remainder, and add 1 to the `sum` ( the carry )
- 3. if carry has happened and next sum plus carry is less than 9, you must `carry /= 10` to account for 'using' the carry
    
## reverse()
- Reverses the LL
- Create three ListNode references, `current = head`, `prev = null`, `next`
- 4-step algorithm

## rotate()
- Rotates the list from specified index
- Cuts the list, iterate to the end of list, add the first list to end of half of list

## rotateFromEnd()
- Uses the circular LL approach
- 1. Grab the `size` of the LL by creating a temp node, current, and iterating through LL
- 2. Use the size and `indexFromEnd %= size` to grab a recalculated if value is greater than size of LL
- 3. Use a `for loop` and have `i < size - indexFromEnd` to go through the LL in a circular manner
- 4. `node = current.next` ( this makes the next node the head )
- 5. `current.next = null` ( cuts the loop )
    
## getNthNodeFromEnd()
- 2 pointer nodes, the referencePointer will iterate forwards by the amount of `indexFromEnd`
- Both pointer nodes move forward by one till `referencePointer != null`

## getNthNodeSimilarAlgToRotateFromEnd()
- The same algorithm as `rotateFromEnd()`
- We just didn't do anything to stop the loop as well as make the `current.next` the `head`

## isLoop() - Floyd Loop Detection
- Two pointers, slowPointer and fastPointer
- Both starts at head, slowPointer moves by 1, fastPointer moves by 2
- If they become equal there is a loop

## beginningOfLoop() - Floyd Loop Detection
- Same as `isLoop()`
- Create new method, private preferably since it is a helper method, create a temp node that points to head
- Iterate in while-loop `(temp != slowPointer)`, return the temp node

## cutLoop() - Floyd Loop Detection
- Same as `isLoop()`
- Create new method, private preferably since it is a helper method, create a temp node that points to head 
- Iterate in while-loop `(temp.next != slowPointer.next)`, why `.next`? ... we want to land on a node **BEFORE** the beginning of loop
- `slowPointer.next = null` to cut the loop

## getMiddleNode()
- Two pointers, `slowPointer` starts at `head`, `fastPointer` starts `head.next`
- while-loop condition is `(fastPointer != null && fastPointer.next != null)`

## sortLists()
- Create a temp node, and iterator
- Go through the lists by going through the while-loop `(l1 != null && l2 != null)`
- Compare and if the value is less than, move l1 or l2 up, iterator.next = one of them, move the iterator up

## mergeSort()
- Sorts the LL by recursion
- Split the list by getting the middle node, put middle node's next in a temp variable like `halfOfList`, middle node's next is set to null to sever connection
- Create left and right ListNodes that will recursively call mergeSort to split the Linked List till `l.next == null`, then return the `l`
- Use `sortLists()` to merge the singular element list which will then be the whole list as it pops the recursive calls from the call stack

## intersectionNode()
- Create two temp ListNodes, `a` and `b`
- `a = a == null ? headB : a.next`
- `b = b == null ? headA : b.next`
- Similar manner to the Floyd Detection, interesting

## removeDupesInSorted()
- If `current.val == current.next.val` then `current.next = current.next.next` else `current = current.next`

## removeDupes()
- Create a temp pointer node to keep track of new values
- Use a hash set, iterate through LL and add to set
- If values is already inside the set, `pointer.next = current.next`
- Else add value to set, and assign the current to pointer

## palindrome()
- Grab the middle node
- Reverse the half of the list
- Iterate through the start of list and start of the newly reversed half of list
- while-loop condition is `(reversed != null)`, compare the values and move them up by one if they are the same