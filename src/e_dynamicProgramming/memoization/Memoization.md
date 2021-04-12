# Memoization

- Memoization means saving a value and using it later
- 1 + 1 + 1 + 1 = 4 + 1? is 5. How do you know... we reused 4, and added 1!

# memoizationEx1

- shows what memoization is all about
- created an array NOT in the method because if we did, it will rewrite the array and give us undesired results
- logic: if `memo[index]` is not empty, return the value and don't calculate anything!

- The base cases are THE most important when it comes to recursion
- the first fibonacciMemoization call subtracts all the way till `if (num<=2) return 1` to return 1 for use!

The flow
- the recursion methods that are paused are put in the call stack
- go through the first recursion calls till it hits the base case 
- once it hits the base case, do the second call
- the return value is returned.. but no used
    - we only care about the value that will be returned when the function fully terminates!