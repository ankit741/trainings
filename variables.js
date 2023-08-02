// var (old) , let ( was introduced in ES6 (2015)) and const

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
const a;
console.log(a); //'const' declarations must be initialized.
*/


const fruit = 'Mango';

/*

fruit='Banana'; //Assignment to constant variable not allowed.

*/
console.log(fruit);


