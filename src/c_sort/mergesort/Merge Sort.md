# Mergesort

Important takeaway:

- Splitting the initial array in half and populating arrays!
- You must make `left` and `right` arrays!
- `left` will be the size of `middle` | `right` will be the size of `length-middle`

# Populating the Arrays
- for(int i = 0; i < left | right.length; i++) 
    - for left: `left[i] = arr[i]`
    - for right: `right[i] = arr[i + middle]`
    
# Base Case

- it is recursive, so have a base case!
    - if `arr.length == 1`, `return`!