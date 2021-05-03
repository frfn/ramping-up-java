# Binary Tree

A `binary tree` is data structure that has two children nodes and one parent node
- will have different find min/max functions, contains functions, etc.

A `binary search tree` is a _structured_ binary tree, where the data is sorted, left branch is less than right branch!
- will have different add/remove functions from binary tree  

# Overview

- BinaryTree shows a `binary search tree`, _NOT_ a binary tree
- To alter it, don't have logic to add the items
- Recursive Fns ( find min/max , print pre/in/post order ) -- good job!
- Iterative Fns
- `Stack` for iterative functions that mimics that `call stack`
- `Queue` for level order traversal

## `Node<X>`

`X` is of type generic, you can make it an integer, strings, an object, etc.

Contains
- `X` item
- `Node<X>` `parent`, `left`, `right`
- setters and getters

## Binary Search Tree

- constructor creates root and size is 0
- utility functions like `itIsEmpty()` and `getSize()` is coded

<br>

**Add Node**
>Recursion!

- A better approach, uses recursion to travel the tree till null!

>2 total functions

- `insert`, recursive logic to add the new node 
    - if _iterative_ approach is taken, `current = current.getLeft()` | `current = current.getRight()`
    
- `add` uses `insert`, starts at ROOT node and has the to be ADDED node as the second argument for `insert`

<br>

**Delete Node**
>Recursion
 
- A better approach, uses recursion till it finds the node, it handles all four cases!

>3 total functions

- `contains`, to traverse through the tree to see if item exists
- `redirectNode`, to set node connection, to change the pointer to the next node or to null, overs _both_, _left_ or _right_
- `delete`, logic to re-link and _skip_ the node with redirect node | accounts for root and nodes with two children

<br>

**Find Min and Max in BST**
- uses recursion to find min and max ( `recursive` )
- uses a while-loop to iterate through the tree to find min and max ( `iterative` )

<br>

**Print PreOrder, InOrder, PostOrder**
- uses recursion to print ( `recursive` )
- uses a while-loop to iterate through the tree to print values ( `iterative` )

Pre-order: Used to create a copy of a tree. For example, if you want to create a replica of a tree, put the nodes in an array with a pre-order traversal. Then perform an Insert operation on a new tree for each value in the array. You will end up with a copy of your original tree.

In-order: : Used to get the values of the nodes in non-decreasing order in a BST.

Post-order: : Used to delete a tree from leaf to root

<br>

**Level Order Traversal**
- printing item value level by level
- Created with `queue`
- `poll()` == `pop()`
- `offer()` == `add()`

<br>

**Find Height of BST**
- Depth vs Height
  - depth: number of edges from root to that whatever node
  - height: number of edges from the node to the longest path leaf node 