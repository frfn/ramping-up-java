# IntBST ( Binary Search Tree )

A `binary search tree` is a data structure that is a binary tree but has a characteristic that makes it different from any other tree.
From the root node, the left value is smaller compared to the root value, and the right value is greater than the root value. 

### TreeNode

A very simple node class for the tree structure.
- data is `int`
- has `parent`, `left` and `right` TreeNode references

### Bubbling out through all the returned values?

- Yes, you do.

### add() and delete() similarities

- when you see `node.left = add(node.left, data);` or `node.right = delete(node.right, data)`
    - the value returned can either be a `TreeNode` **OR** `null`
    
### delete()

**1.** traverse the tree till you find data

**2.** if node has one child, you will return one of them

**3.** if node has two children, you will do another algorithm
- find the successor by going to the right subtree and finding the min
- replacing the current node's info with the successor's info
- delete the successor value!

### findHeight()

You're returning from the leaf node and incrementing by one.
- This is a **DFS** approach to finding the height

### findMaxInBT

This is for a binary tree, this is also a DFS approach

**1.** if null, return -1

**2.** temp variable, maxValue for the current node's data

**3.** `int left = findMaxInBT(node.left)` and `int right = findMaxInBT(node.right)`

**4.** compare if the temp variable is bigger than left or right
- if left is bigger, maxValue is left
- if right is bigger, maxValue is right

