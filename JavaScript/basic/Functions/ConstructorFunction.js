/*
Alternatively, you can create an object with these two steps:
Define the object type by writing a constructor function. 
There is a strong convention, with good reason, to use a capital initial letter.
Create an instance of the object with new.
*/

//To define an object type, create a function for the object type that specifies its name, properties, and methods.

function Car(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;
}

/*
When a function is executed with new, it does the following steps:

A new empty object is created and assigned to this.
The function body executes. Usually it modifies this, adds new properties to it.
The value of this is returned.

function User(name) {
  // this = {};  (implicitly)

  // add properties to this
  this.name = name;
  this.isAdmin = false;

  // return this;  (implicitly)
}

let user = new User();

console.log(User.prototype.constructor === User); // true
console.log(user.constructor === User); // true
console.log(Object.getPrototypeOf(user) === User.prototype); // true


When user is created by calling new User(), one of the things that happens 
is that user object gets an internal [[Prototype]] link to the object that User.prototype is pointing at.

*/
/*
The new operator
Let's consider the following example:

var Person = function (firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
};

var john = new Person('John', 'Doe');
The Person is a constructor function. Its whole purpose is to create new objects which represent different persons. We can be sure that each person will have the first name and the last name, which are provided as parameters to this function. Notice that unlike regular functions, constructors begin by convention with a capital letter. This way you can easily tell them apart from ordinary functions.

Then we are creating a specific person instance called john with firstName 'John' and lastName 'Doe'. Notice that there is a new keyword before the Person constructor function call. It is actually an operator and it is responsible for all the magic when creating new persons. It does actually quite a lot:

It creates a new blank object.
It makes this to point to this newly created object inside the constructor function
It sets the prototype of the newly created object to the constructor function's prototype.
It makes the constructor function return the newly created object IF it is not returning anything.
That is the reason why John is created even though the function Person does not have an explicit return statement. That's the reason why using this.firstName=firstName; sets the first name provided to the new object. Without the new keyword, this would point to the global object in our case and not to the newly created instance.
*/


/*

What if I forget to include new?

There are some serious problems when using the new operator. In languages such as Java, it is strictly limited how you can use the new keyword. It can be used only to invoke methods, which are explicitly marked as constructors. Constructors are guaranteed to return a new instance of the class, performing all the required initialization. Constructors can be invoked only using the new keyword and the new keyword can be used only to invoke constructors.

In javascript, the situation is unfortunately not so strict.

You can use new operator on ANY function
You can call function intended as constructor WITH or WITHOUT the new keyword
So, calling function not designed as constructor will not result in an error. What's more, you'll get different behavior based on whether you call the constructor with or without the new keyword. And it is really easy to forget to include new. After all, there is no compile-time check as in Java. Let's look at an example.

var Person = function (firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
};

var john = new Person('John', 'Doe');
var jane = Person('Jane', 'Doe');
First, there is a constructor function Person and then it is called twice. Once with new and once without. Can you guess what each variable contains?

console.log(john); // Person {firstName: 'John' , lastName: 'Doe'}
console.log(jane); // undefined
console.log(window) // Oh dear! The global object now has firstName and lastName!
What just happened? Looks like John is doing well, but poor Jane is undefined. What's worse, it looks like firstName and lastName got stored on the global object (window in case of running in a browser). So my precious new object is undefined and I am polluting the global object instead. Nasty.

The reason why is that one of the actions new operator does is changing this, so it points to the newly created object. When new is not specified, the constructor is considered an ordinary function call and this remains the same as usual. In our case, when I just declared a function on the top level and called it from the top level, this is pointing to the global object. Global object differs in each environment (browser vs server side javascript), but in a browser it is window. That means I am now storing my properties directly on the window object.

Another action that new operator does is that makes the newly created object result of the whole new expression if the function does not return object specifically. It is the case here as you can see that the Person constructor does not explicitly call return (and yet, John is successfully created). When called without new, it is just a regular function call. And functions without explicit return statement return undefined.

Protecting against forgetting to include new
Alright, forgetting the new operator can have pretty nasty consequences. So what can you do to prevent such cases?

Capital letter convention
You should always stick to the convention that constructor functions start with a capital letter and regular functions with a lowercase letter. This way you can immediately see that something is fishy when encountering a situation such as:

var person = Person('John', 'Doe'); // capital letter, I should use new
It is also helpful when constructor names are nouns and regular functions are verbs:

var size = new computeSize(); // lowercase letter;  computeSize doesn't sound like noun
Explicit check of this
Remember how one of the things new operator does is changing this to the newly created object and setting the prototype? One of the ways how to defend against the accidental omission of the new operator is checking what actually this points to in the constructor function.

var Person = function (firstName, lastName) {

    if (!(this instanceof Person)) {
        return new Person(firstName, lastName);
    }

    this.firstName = firstName;
    this.lastName = lastName;
}
This way if this is not an instance of Person, we can detect it and properly call the constructor again and make sure we add the new keyword to the call. The result is same no matter whether you use the new keyword for your constructor or not.

The disadvantage is that it encourages developers to not worry about using new as it is still safe. Building such habit is not good as not all the code you'll work with will always have such safeguards. It is much better to stick to the convention of always using new instead of just sometimes and have the usage inconsistent across the codebase. As an alternative, you may consider using the check but to throw an error to fail fast and discover improper usage of your constructors early on.


*/


/*

Classes
In ECMAScript 6, there is a new concept of classes, which aims to replace constructor functions and addresses its issues. The person from our examples above as a class would look like this.

class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
You can create new persons as usual:

var john = new Person('John', 'Doe');

What's really cool is that if you accidentally forget to include the new keyword when creating a new instance it results in an error instead of silently altering the global object.

var john = new Person('John', 'Doe'); // Person { firstName: 'John', lastName: 'Doe' }
var jane = Person('Jane', 'Doe'); // TypeError: Class constructor Person cannot be invoked witho
*/