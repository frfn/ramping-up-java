# Two Sum

- finds a pairing that will be the targeted sum
- logic: must be a hashmap, key will be number while value is the index
    - if the target - current value is in the map, return current index and the index of the value in the map!
    
# Reverse Integer

- reversing an integer in a mathematical way
- logic:
    - pop = x % 10
    - x /= 10 to get rid of last digit  
    - rev = rev * 10 + pop
    
# Palindrome Integer

- Use reverse integer and see if original number == reverse

# Roman Integer

- gives numerical value from ROMAN INTEGERS
- logic: if i-1 value is less than current value
            - subtract i-1 value -> current value - (i-1) value
         else 
            - add current value
  
# The Longest Common Prefix

- Vertical Scanning is the most understandable for me
- logic: use the first word as the base
    - will go through letter by letter
    - sees if word is the same length as another word OR if theyre not the same, its false
    - will return the substring!
    
# Valid Parenthesis

- Sees if the symbols are ({[]}) are valid!
- logic: hashmap to store the symbols
         stack to push the symbols in through loop
         iterates through each one
            - if the stack is empty and sees a closing symbol, it is false
            - if the current char is not the same as the value of first value in stack, it is false
  
# Max Price ( Stocks )

- logic: keep track minimum value
    - use min value and subtract to current price through iterating
    - keep track of max profit!
    
# Palindrome

- logic: `i < word.length / 2`
        - `word i == word length - 1 - i`
  
# Remove Dupes from Sorted Array

- solving for in place algorithm
- logic: use global counter for index and add to array

# Merge Sorted Array ( Using one array to hold as well as reversed process )

- merges from the end to the beginning
- uses the merge sort algorithm but reversed!

# Remove Element From Unsorted Array

- iterate through the whole array
- the algorithm is if the current value through the iteration is NOT the target value
    - then `arr[pointer++] = arr[i]`
    
# strStr

- needle in a haystack problem
- iterate through the array
- logic: if the `haystack.substring(i, i + needle.length()).equals(needle)`

# Search Insert Position

- iterate through the array
- if the current number is greater than the target, return the counter

# Length of Last Word

- either use split() but this will cost you some time
- logic for faster solution: 
    - first strip() all the trailing white spaces
    - iterate from the end of array
    - if `current value == ' '`, return counter value
    
# Maximum Sub Array

- O(n^2), use two for loops to iterate through the array and add, while collecting the largst sum
- O(n), use Kadane's Algorithm - if current value is larger than the running sum, use the larger value
    - now see if the largestSum is bigger than the current value
    
# Plus One

- adding one to the array 
    - {1, 2, 3} == {1, 2, 4}
    - {9, 9}    == {1, 0, 0}
    
- logic: if the digit is LESS than 9, `digits[i]++; return digits;`
    - if `digits[i] is 9` then at current value, `digits[i] =  0`;
    - since we are looping through, it will iterate through the array and return when condition is met