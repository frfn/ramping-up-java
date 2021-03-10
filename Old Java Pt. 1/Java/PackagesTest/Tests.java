package PackagesTest;

/*

Points to remember:
1. Sometimes class name conflict may occur.
For example: Lets say we have two packages abcpackage and xyzpackage and both the packages have a class with the same name, let it be JavaExample.java. Now suppose a class import both these packages like this:

import abcpackage.*;
import xyzpackage.*;

This will throw compilation error. To avoid such errors you need to use the fully qualified name method that I have shown above.
For example:
abcpackage.JavaExample obj = new abcpackage.JavaExample();
xyzpackage.JavaExample obj2 = new xyzpackage.JavaExample();
This way you can avoid the import package statements and avoid that name conflict error.

2. I have already discussed this above, let me mention it again here. If we create a class inside a package while importing another package then the package declaration should be the first statement, followed by package import.
For example:

package abcpackage;
import xyzpackage.*;

3. A class can have only one package declaration but it can have more than one package import statements.
For example:

package abcpackage; //This should be one
import xyzpackage;
import anotherpackage;
import anything;

4. The wild card import like package.* should be used carefully when working with subpackages.
For example: Lets say: we have a package abc and inside that package we have another package foo, now foo is a subpackage.

classes inside abc are: Example1, Example 2, Example 3
classes inside foo are: Demo1, Demo2

So if I import the package abc using wildcard like this:

import abc.*;
Then it will only import classes Example1, Example2 and Example3 but it will not import the classes of sub package.

To import the classes of subpackage you need to import like this:

import abc.foo.*;
This will import Demo1 and Demo2 but it will not import the Example1, Example2 and Example3.

So to import all the classes present in package and subpackage, we need to use two import statements like this:

import abc.*;
import abc.foo.*;

abc is the main package, foo is thje SUB package.

 */

// package import
import Leetcode.Easy_reverseInteger;
import Leetcode.Easy_romanInteger;

public class Tests {

    public static void main(String[] args) {
        // TESTING out packages
        Easy_reverseInteger reverseInteger = new Easy_reverseInteger();
        int rev = reverseInteger.reverse(61696);
        System.out.println(rev);

        // Using qualified name to avoid import statements
        Easy_romanInteger obj = new Easy_romanInteger();
        System.out.println(obj.romanToInt("III"));

    }

}
