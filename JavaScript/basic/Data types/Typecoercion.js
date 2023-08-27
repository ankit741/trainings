/*
Type coercion is the  conversion of values from one data type to another (such as strings to numbers). 
1. automatic or implicit
2. Explicit

*/

/*
String:
how to combine string with numbers?
simple way to is to use + operator
whenever we use + or - data types must be same.*/

//String-Implicit


console.log("50" - 40); // when there are different data types around - operator the interpreter coerce both data types to numbers.
console.log("20" / 10);

//String-Explicit

let x = String(10);
console.log(x);

//Boolean -Implicit

console.log(1 > 2);
console.log(1 == 1);

//Boolean-Explicit

let isTrue = Boolean(1);
console.log(isTrue);

//Number- Implicit

console.log(5 < 4 < 3); //operate from left to right 5<4= false then false<3 = true as false coerces to number 0

let m = 4 > "3";
console.log(m);

//Number -Explicit

let num1 = "10";
let num2 = "20";
console.log(+num1 + +num2);
console.log(Number(num1) + Number(num2));

//Equality:
/* whenever we compare two values using == JS does coercion
 strict equality === js won't use coercion */

 let a=40;
 let b='40';
 console.log(a==b);
 console.log(a===b);
