# Counting Valleys

- seaLevel increases | decreases if 'U' | D
- logic: if at sea level 0, and going down, it is a valley

# Odd Numbers

- if there is no remainder, it's even!
- logic: `i % 2 != 0`

# Histogram 

- loop through words
- logic: hashmap | IF word does not exist, 1 ELSE add one

# Matching Pair

- loop through the array
- logic; use a hashmap, or hashset | if map or set contains sock pairing (for map, if value == 2, remove | for set, if it occurs again, remove)

# Jumping Cloud

- not my code, but demonstrates off by one
- shows i++ in the if condition to skip an iteration

# Repeated String

- pattern exploit
- counts 'a'
- logic: do NOT create the string, just use what you have
    - find repeated, and the remainder!
    - repeated = repeated * #ofAinString
    - remainder: iterate through loop and add on!
    
# Hour Glass

- not much of an algorithm
- logic: constructed the hourGlass schema
    - 2D array, off by 2 since hourGlass schema has '+ 2'
    - maxValue shall be the first hourGlass value to be compared
    
# Rotate Left

- transform the array from 12345 to 45123
- logic: a global counter and a new array
    - iterate through end and fill a new array, 45nullnullnull
    - another for loop to fill in, 45123
    
# Ransom Note

- similar to histogram
- logic: fill hashmap with magazine words
    - loop through `note` and remove as needed, no repeats!
    
# twoStrings

- really easy for some reason
- compares if there are any letters in string1 that is in string2
