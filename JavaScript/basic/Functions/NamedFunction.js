//Named function, aka a function declaration
/*
Function declarations are hoisted, which means they are loaded into memory at compilation. 
*/

function areaOfCircle(r) {
  let area = Math.PI * r * r;
  return area;
}

console.log(areaOfCircle(10));

//parameter followed by spread operator (...)

function test(...args) {
  console.log(args);
}

test(2, 4, 6, 8);
test(1, 2);

//The arguments object example :

function add() {
  let sum = 0;
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
console.log(add(1, 2)); // 3
console.log(add(1, 2, 3, 4, 5)); // 15

//Function properties:

function sum(x, y) {
  return x + y;
}

console.log(sum.length); // 2
console.log(sum.prototype); // Object{}

let result = sum(5, 5); // Typically, you call a function normally like this

console.log(result);
