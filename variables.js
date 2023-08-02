
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


console.log('******************************VAR******************************************');
{
    var a = 123;
};

console.log(a); //no ReferenceError as var keyword are scoped to the immediate function body (hence the function scope) 


var start;
console.log(start); // prints undefined

var name = 'John';
name = 'John Doe';
console.log(name);

/*
Variables defined with var can be redeclared
*/
var name = 'Jhon';
console.log(name);

console.log('******************************LET******************************************');

/*
{
    let a = 123;
  };
  
console.log(a); //ReferenceError : a is not defined error as let scoped to the immediate enclosing block denoted by { } (hence the block scope).

*/

let num;
console.log(num);  // prints undefined

let word = 'Hello';
word = 'Hello world'; // doesn't work in strict mode.
console.log(word);

/*

let word = 'Hi'; //Variables defined with let can't be redeclared

*/

console.log('******************************CONST******************************************');

/*
{
    const b = 123;
};
  
console.log(b); //Uncaught ReferenceError: b is not defined error as const scoped to the immediate enclosing block denoted by { } (hence the block scope).

*/

/*
const a;
console.log(a); //'const' declarations must be initialized.
*/


const fruit = 'Mango';

/*

fruit='Banana'; //Assignment to constant variable not allowed.

*/
console.log(fruit);



