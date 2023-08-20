
/*
Variables are Containers for Storing Data.

JavaScript Variables can be declared in 3 ways:

1. var (old-used in all JavaScript code from 1995 to 2015) 
2. let ( introduced in ES6 (2015)) 
3. const (introduced in ES6 (2015))

Notes :
=======
All JavaScript variables must be identified with unique names.
These unique names are called identifiers.
Variable names are case-sensitive in JavaScript.
ariable names can contain letters, digits, or the symbols $ and _.
A variable name cannot start with a digit 0-9.
A variable name cannot be a reserved keyword in JavaScript, e.g. var, function, return

When to Use var, let, or const?

1. Always declare variables

2. Always use const if the value should not be changed

3. Always use const if the type should not be changed (Arrays and Objects)

4. Only use let if you can't use const

5. Only use var if you MUST support old browsers.

*/

var name='Ankit'
console.log(name);
name='John doe';
console.log(name);

var greet;
console.log(greet);
greet='hello';
console.log(greet);

let str='Ankit'
console.log(str);
str='John doe';
console.log(str);

const val='const val'; 
console.log(val);
//al='welcome';


// when you use var, you can declare the same variable as many times as you like, 
//but with let you can't. The following would work:

var myName = "Chris";
var myName = "Bob";

//But the following would throw an error on the second line

let myName1 = "Chris";
//let myName = "Bob";

//Again, this is a sensible language decision.
//There is no reason to redeclare variables — it just makes things more confusing.




