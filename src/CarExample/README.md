# Compare

An interface
- a way to achieve abstraction, what that means is that it only shows the important information to user.
- On top of that, it gives behaviors to a class
- anything inside the interface is final, static, and public
  
---
  
`boolean isFaster(Compare object)`
- `isFaster` takes in an object that is of type Compare
- returns boolean

# Car

Car Class, implements Compare and the in-house interface, ICarName

- `Composition` is shown here, it contains another instance, the engine object!
- `private` variables are declared ( great for **encapsulation**! )
- `constructor` initializes the declared varirables
- `toString()` for printing the object
- since a **subclass**, you must create the methods in the interface

# Honda 

- Uses an **`ArrayList`** to keep features
- Uses the **`super`** keyword since it extends Car!
- Uses **`Collections`** for adding an array of strings into the ArrayList
    - this was suggested, there are three other ways to do this. Neat.
  
- Uses **`toString()`** to pretty print object

# Engine

- Used to practice **`composition`**
- It is instantiated in the Car class!

# Main

- Instantiates two Car objects
- Using the features for the car
- Garage is instantiated to "park" cars

# Honda Garage Array

- Uses an array to keep cars
- Multiple functions to support garage application

# Honda Garage HashMap

- Uses a hash map
- For practice, constant time!
