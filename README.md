# Learning Classes

### Access Modifiers

- `Private`
- `Protected`: can be used in classes that are 
- `Public`: all classes can, this is default

### `Inheritance` VS `Composition`

`Is-A` relationship is `inheritance`

> when the class either has an implements or extends, it most likely is an IS-A relationship

- bus `IS-A` vehicle
- car `IS-A` vehicle
- potato `IS-A` vegetable

`Has-A` relationship is `composition`

> current class has a reference to an instance of another class, basically, the object will use another object ( same object or a different object )

- car `HAS-A` engine
- bike `HAS-A` engine
- dog `HAS-A` tail

# Encapsulation

- the idea of making things that are sensitive hidden. An example is declaring variables private

- `private String name;`
  - you can only access the `name` variable in the class it is in, you can create setters and getters to interact with it!

# Data Abstraction

It is the process of restricting and only showing important information to the user. Methods shall be filled in the subclasses that `extends` | `implements` the `abstract class` | `interface`

### `abstract` class and methods

- cannot be instantiated, must be inherited
- methods that are abstract shall be filled by the subclass
- variables may contain non-final variables

### `interface`

- complete abstraction
- it's a way to give behaviors to the class
- giveLight() from an interface can be used in lamp objects, etc.
- variables in an interface is final, public, and static

# Polymorphism

- many forms, it happens when we objects are related with each through inheritance

```
 Animal myAnimal = new Animal();  // Create a Animal object
 Animal myPig = new Pig();  // Create a Pig object
 Animal myDog = new Dog();  // Create a Dog object
 
 You can probably put the values in a list that's a type of Animal
```

# Final 

- `non-access modifier`, simplified means you can't change it, you can't access it and you can't override it
  
    - prevents method overloading
    - prevents variable modification
    - prevents inheritance

