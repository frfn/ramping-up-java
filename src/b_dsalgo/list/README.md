# ArrayList

[Generic Array](https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java): The proper way to create!

# Overview

- An array list
- Manipulation of array index
- Amortized time
- Data Structure
- Big O(n)

Created my version of an array list

- add 
- add at index
- delete 
- delete at index

It is a generic Array List where X stands for any type.

## Constructor

- Initializes the array with `null` values
- Sets the `size` to 0

## Methods

Takeaways:

- increaseSize()
    - amortized time
    - if size == list.length, array will grow by 10!
    
- addAtIndex()
    - `off-by-one` in `for` loops / `while` loops
    - when to use `- 1` or `>=` | `<=` to avoid that issue
    
- Object.equals(object)
    - supports equality comparator!