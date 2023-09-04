/*
A function is a reusable block of code or programming statements designed to perform a certain task.
A function is declared by a function key word followed by a name, followed by parentheses ().

In JavaScriptb, all functions are objects. They are the instances of the Function type. 
Because functions are objects, they have properties and methods like other ojects.

Every function in JavaScript implicitly returns undefined unless you explicitly specify a return value

A function can be declared or created in couple of ways:

Named function
Expression functions
Anonymous functions
Arrow functions
Immediately invoked function expression (IIFE)
High order functions
constructor functions
*/


//Function properties:

/*
Each function has two important properties: length and prototype.

The length property determines the number of named arguments specified in the function declaration.
The prototype property references the actual function object.
*/

//The arguments object : Arrow function does not have the function scoped arguments object.


/*Inside a function, you can access an object called arguments 
that represents the named arguments of the function.*/

//Function with default parameters :
//Sometimes we pass default values to parameters, when we invoke the function if we do not pass an argument the default value will be used. 
//Both function declaration and arrow function can have a default value or values.


function functionName(param = value) {
  //codes
}

// Calling function
functionName()
functionName(arg)