/*

Primitives are compared by value, objects are compared by reference. 
If you compare two primitives having the same value, they are considered equal.

42 === 42 //true
'John' === 'John' //true


However, when comparing two objects, you need to be more careful. They are compared by their identity. That means it does not matter if the two objects have the same properties with the same values. They are equal only if they are the same instance. That is - if comparing two variables, they are equal only if they point to the very same object.

var john = {name: 'John', name: 'Doe'};
var stillJohn = john;
var evilTwin = {name: 'John', name: 'Doe'};

john === john //true
john === stillJohn //true
john === evilTwin //false

You can see that two variables can point to the same object. 
That is because a variable containing an object holds only a reference to that object. 
When you assign the reference to a new variable, now you have two variables holding the reference 
to the same object. That means changing the properties of the object stored in either of the variables 
will affect them both. This does not apply to primitives as they are not using references, 
their value is copied instead every time.




For certain primitives (number, boolean, string) JavaScript offers Wrapper objects, 
which can be used when an object is needed and provide some extra convenience methods. 
So what happens in the example above:

Javascript detects that you are trying to access a property of a string primitive.
It creates a wrapper object String to wrap the original string primitive.
It accesses the length and toUpperCase on the wrapper object instead of the original primitive.
It discards the wrapper object, frees the memory and continues.
This way you can use all the helpful methods on strings to make a substring, convert it to lowercase, split it and so on. Note that primitives are immutable so all these methods just return a new instance of the string and don't modify the original.

Manually creating wrappers:

In the example above, JavaScript creates wrapper objects automatically under the hood.
 There is also a way to create such objects explicitly.

new Number(4)
new String('Hi')
new Boolean(true)
These are not primitives anymore, but objects, which contain the primitive value and add some extra goodies.

typeof 4 //number
typeof 'Hi' //string
typeof true //boolean

typeof new Number(4) //object
typeof new String('Hi') //object
typeof new Boolean(true) //object
This has some serious implications. You cannot really compare wrapper objects and primitives:

'Hi' === new String('Hi') //false
Also, be aware that objects are considered truthy, that means that you need to watch for this:

if (false) {
    //This does not execute
}

if (new Boolean(false)) {
    //This executes
}

Because of this, explicitly creating wrappers using the new operator is considered a bad practice. On the other hand, calling the function without the new operator is perfectly valid as it just tries to convert the input into the corresponding primitive type and returns a primitive value.

typeof new Number('42') //object, not recommended
typeof Number('42') //number, safe
valueOf and toString
When you are working with objects, there are some cases when you would rather need a primitive representation of the object. Actually, javascript offers two methods for it which each object inherits:

valueOf() returns primitive representation of the object
toString() returns string representation of the object
A good example can be Date. toString() returns a human-readable description of the date, while valueOf() returns a number representing the date as the number of passed milliseconds since 1 January 1970 00:00:00 UTC and the date.

var date = new Date();
console.log(date.toString()); //Wed Jan 24 2018 14:12:07 GMT+0100 (Central Europe Standard Time)
console.log(date.valueOf()); //1516817671281
You rarely need to call valueOf() yourself, but javascript does it under the hood when a primitive is expected, for example when using + operator. You can even define your own implementation of valueOf() and toString():

var john = {
    firstName: 'John',
    lastName: 'Doe',
    age: 45,
    valueOf: function () {
        return this.age;
    },
    toString: function () {
        return `${this.firstName} ${this.lastName}, ${this.age}`
    }
};

console.log(john.toString()); //John Doe, 45
console.log(john + 1); //46
*/
