/*Hoisting is a JavaScript mechanism where variables and function declarations 
are moved to the top of their scope before code execution.

Hoisting affects differently:

variable declarations: using var, let, or const keywords
function declarations: using function <name>() {...} syntax
class declarations: using class keyword

*/

/*
Variables declared with var are hoisted to the top of the enclosing function scope. If the variable is accessed before the declaration, it evaluates to undefined.

*/

console.log(name); // Prints undefined, as only declaration was hoisted
var name = "John";
console.log(name); // Prints "John" 


function double(num) {
    console.log(myVariable); // => undefined
    var myVariable;
    return num * 2;
  }
  
console.log(double(3)); // => 6

/*
Suppose myVariable is accessed before declaration with var. In this situation the declaration is moved to the top of double() function scope and the variable is assigned with undefined:
*/

//Block scope variables: let

/*
The let statement creates and initializes variables inside the block scope: let myVar, myVar2 = 'Init'. By default a declared yet not initialized variable has undefined value.

let is scoped on a block statement (and function) level:

Hoisting and let-
=================

let variables are registered at the top of the block. But when the variable is accessed before the declaration, JavaScript throws an error: ReferenceError: <variable> is not defined.

function isTruthy(value) {
  if (value) {
      //temporal dead zone for myVariable
    // Throws ReferenceError: myVariable is not defined
    console.log(myVariable);
    let myVariable = 'Value 2';
    // end of temporary dead zone for myVariable
    console.log(myVariable); // => 'Value 2'
    return true;
  }
  return false;
}

isTruthy(1)


Hoisting and const :
====================

function double(number) {
   // temporal dead zone for TWO constant
   console.log(TWO); // ReferenceError: TWO is not defined
   const TWO = 2;
   // end of temporal dead zone
   return number * TWO;
}

double(5);

*/

console.log(square(5)); // 25

function square(n) {
    return n * n;
}


/*
This code runs without any error, despite the square() function being called before it's declared. This is because the JavaScript interpreter hoists the entire function declaration to the top of the current scope, so the code above is equivalent to:

// All function declarations are effectively at the top of the scope

Function hoisting only works with function declarations — not with function expressions and . The following code will not work:

console.log(squares(5)); // ReferenceError: Cannot access 'square' before initialization
const squares = function (n) {
  return n * n;
};

*/

//Function expressions, however are not hoisted.

expression(); //Output: "TypeError: expression is not a function

var expression = function() {
  console.log('Will this work?');
};

/*
JavaScript has hoisted the variable declaration.
 This is what the code above looks like to the interpreter:

var hoist;

console.log(hoist); // Output: undefined
hoist = 'The variable has been hoisted.';
*/

console.log(hoist); // Output: undefined

var hoist = 'The variable has been hoisted.';

//Note that the following is not a form of hoisting:a
{
    var x = 1;
}
console.log(x); // 1
  //There's no "access before declaration" here; it's simply because var declarations are not scoped to blocks.

  const y = 1;
  {
    console.log(y); // ReferenceError
    const y = 2;
  }

  //If the const y = 2 declaration is not hoisted at all (as in, it only comes into effect when it's executed), then the console.log(y) statement should be able to read the x value from the upper scope. However, because the const declaration still "taints" the entire scope it's defined in, the console.log(x) statement reads the y from the const y = 2 declaration instead, 
  //which is not yet initialized, and throws a ReferenceError. 