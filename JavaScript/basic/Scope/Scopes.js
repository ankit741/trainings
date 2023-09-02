/*
In JavaScript, scope refers to the visibility of a variable or how it can be used after it is declared. 
The scope of a variable depends on the keyword that was used to declare it.

The three types of Scope are Global Scope, Function Scope, and Block Scope. 
Before ES6 (2015), JavaScript had only Global Scope and Function Scope with the var keyword.
ES6 introduced let and const which allow Block Scope in JavaScript.

var, let and const all provide global Scope.

Function Scope: Variables declared within a function can only be used within that same function. 
Outside that function, they are undefined. var, let and const all provide this Scope.

Block Scope: A block is any part of JavaScript code bounded by ’{}‘. Variables declared within a block can not be accessed outside that block. 
This Scope is only provided by the let and const keywords.
*/

//block scope
{
    let x = 2;
  }
  // x can NOT be used here
 
  {
    var x = 2;
  }
  // x CAN be used here as var doesn't support block scope
 
  //function scope-Variables declared within a JavaScript function, become LOCAL to the function.
  //Local variables are created when a function starts, and deleted when the function is completed.
  
 /*Each function creates a new scope.
 
 Variables defined inside a function are not accessible (visible) from outside the function.
 
 Variables declared with var, let and const are quite similar when declared inside a function.*/
 
 // code here can NOT use carName
 
 function myFunction() {
    let carName = "Volvo";
    // code here CAN use carName
  }
  
  // code here can NOT use carName
 
 
  //global scope : A variable declared outside a function, becomes GLOBAL.
  //All scripts and functions on a web page can access it. 
 
  let carName = "Volvo";
 // code here can use carName
 
 function myFunction() {
 // code here can also use carName
 }
 
 
 //Automatically Global :
 //In "Strict Mode", undeclared variables are not automatically global.
 
 myFunction();
 
 // code here can use carName
 
 function myFunction() {
   carName = "Volvo";
 }
 
 
 // It will not bother from whatever it is being called(the global scope/from within another function even), 
 //that's why global scope value I am global will not be printed.
 // This is called lexical scoping where "functions are executed using the scope chain that was in effect 
 //when they were defined"
 
 var scope = "I am global";
 function whatismyscope(){
    var scope = "I am just a local";
    function func() {return scope;}
    return func;
 }
 console.log(whatismyscope()());