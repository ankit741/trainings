/*
Expression functions are anonymous functions. After we create a function without a name and we assign it to a variable.
To return a value from the function we should call the variable.
*/

// Function expression
const square = function(n) {
    return n * n
  }
  
  console.log(square(2)) // -> 4