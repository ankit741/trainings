/*
ES6 introduced arrow function expressions that provide a shorthand for declaring anonymous functions:
Arrow function is an alternative to write a function, 
however function declaration and arrow function have some minor differences.

Arrow function uses arrow instead of the keyword function to declare a function. 
*/

// This is how we write normal or declaration function
// Let us change this declaration function to an arrow function
function square1(n) {
    return n * n
  }
  
  console.log(square1(4)) // 16
  
  const square2 = n => {
    return n * n
  }
  
  console.log(square2(2))  // -> 4
  
  // if we have only one line in the code block, it can be written as follows, explicit return
  const res = n => n * n  // -> 4

  console.log(res(5));


  
  const printFullName = (firstName, lastName) => {
    return `${firstName} ${lastName}`
  }
  
  console.log(printFullName('Ankit', 'Rawat'))