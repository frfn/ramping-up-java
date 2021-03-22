# Binary Tree

A `binary tree` is data structure that has two children nodes and one parent node

A `binary search tree` is a _structured_ binary tree, where the data is sorted, left branch is less than right branch!

# Overview

- BinaryTree shows a `binary search tree`, _NOT_ a binary tree
- To alter it, don't have logic to add the items
- Recursive Fns ( find min/max , print pre/in/post order ) -- good job!
- Iterative Fns

## `Node<X>`

Contains
- `X` item
- `Node<X>` parent, left, right
- setters and getters

## Binary Search Tree

- constructor creates root and size is 0
- utility functions like `itIsEmpty()` and `getSize()` is coded

<br>

**Add Node**
>2 total functions

- `insert`, recursive logic to add the new node 
    - if _iterative_ approach is taken, `current = current.getLeft()` | `current = current.getRight()`
    
- `add` uses `insert`, starts at ROOT node and has the to be ADDED node as the second argument for `insert`

<br>

**Delete Node**
>3 total functions

- `contains`, to traverse through the tree to see if item exists
- `redirectNode`, to set node connection, to change the pointer to the next node or to null, overs _both_, _left_ or _right_
- `delete`, logic to re-link and _skip_ the node with redirect node | accounts for root and nodes with two children

<br>

**Find Min and Max**
- uses recursion to find min and max ( `recursive` )
- uses a while-loop to iterate through the tree to find min and max ( `iterative` )

<br>

**Recursive: Print PreOrder, InOrder, PostOrder**
- uses recursion to print ( `recursive` )
- uses a while-loop to iterate through the tree to print values ( `iterative` )



