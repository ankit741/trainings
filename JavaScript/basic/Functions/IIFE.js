/*Immediately invoked function expression (IIFE):
If you want to create a function and execute it immediately after the declaration,
 you can declare an anonymous function */

//First, define a function expression:

// (function () {
//     console.log('Immediately invoked function execution');
// })

//Second, call the function by adding the trailing parentheses ():

(function () {
    console.log('Immediately invoked function execution');
})();

let person = {
    firstName: 'John',
    lastName: 'Doe'
};

//how to pass arguments

(function () {
    console.log(`${person.firstName}  ${person.lastName}`);
})(person);