# Learning Classes

### Access Modifiers for variables

- **`Private`**: can only be used in the current class, and not outside the class
- **`Protected`**: can be used in the current class and subclasses of the class
- **`Public`**: all classes can refer to this field, this is default

### `Inheritance` VS `Composition`

`Is-A` relationship is **`inheritance`**

Inheritance is important because it promotes code reuse, it also allows us to use another class as base which makes it easy to create other objects or apps!

> when the class either has an implements or extends, it most likely is an IS-A relationship

- bus `IS-A` vehicle
- car `IS-A` vehicle
- potato `IS-A` vegetable

---

`Has-A` relationship is **`composition`** <br>

**`Composition`** allows the reuse of the code, since Java doesn't support **multiple inheritance**, we can achieve it.

> current class has a reference to an instance of another class, basically, the object will use another object ( same object or a different object )

- car `HAS-A` engine
- bike `HAS-A` engine
- dog `HAS-A` tail

# Encapsulation

- the idea of making things that are sensitive **hidden**. An example is declaring variables **`private`**

- `private String name;`
  - you can only access the `name` variable in the class it is in, you can create setters and getters to interact with it!

# Data Abstraction

It is the process of **restricting** and only showing important information to the user. Methods shall be filled in the subclasses that `extends` | `implements` the `abstract class` | `interface`

### `abstract` class and methods

When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.

- cannot be instantiated, must be inherited
- methods that are abstract shall be filled by the subclass
- variables may contain non-final variables

### `interface`

When we talk about an interface and define capabilities that we promise to provide, we are talking about establishing a contract about what the object can do.

- complete abstraction
- it's a way to give behaviors to the class
- giveLight() from an interface can be used in lamp objects, etc.
- variables in an interface is final, public, and static

# Polymorphism

Polymorphism is important because even though objects are implemented and created differently, you can interact with the objects as if it were just one object. Through inheritance, they will be related.

- many forms, it happens when objects are related with each other through inheritance

```
 Animal myAnimal = new Animal();  // Create a Animal object
 Animal myPig = new Pig();  // Create a Pig object
 Animal myDog = new Dog();  // Create a Dog object
 
 You can probably put the values in a list that's a type of Animal
```

# Final 

- **`non-access modifier`**, simplified means you can't change it, you can't access it and you can't override it
  
    - prevents method overloading
    - prevents variable modification
    - prevents inheritance

# HashMap

A hash map is a **collection** of items, mostly known for its constant time, and key/pair value design!

```
HashMap<Integer, Car> = new HashMap<Integer, Car>();
```
- `.get()` to access an item
- `.remove()` to remove an item
- `.clear()` to remove all items

[All the functions of HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

To print out **`keys`** in the HashMap
```
// Print keys
for (String i : capitalCities.keySet()) {
  System.out.println(i);
}
```

To print out **`values`** in the HashMap
```
// Print values
for (String i : capitalCities.values()) {
  System.out.println(i);
}
```

To print out both
```
// Print keys and values
for (String i : capitalCities.keySet()) {
  System.out.println("key: " + i + " value: " + capitalCities.get(i));
}
```

# StringBuilder

Create a mutable string!
```
StringBuilder string = new StringBuilder();
```
- `.append(string)`
- `.insert(index, string)`
- `.reverse()`
- `.charAt()`
- `.substring(beginningIndex, endIndex)`