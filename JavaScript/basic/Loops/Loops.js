/*

These are the different loops in JS

while loop
do while loop
for loop
for in
for of loop

while loops :
=============
The first loop we will discuss is the while loop. A while loop executes a certain block of code as long as an expression evaluates to true. The snippet below demonstrates the syntax of the while loop:

while (condition) {
  // code that gets executed as long as the condition is true
}

let i = 0;
while (i < 10) {
  console.log(i);
  i++;
}

do while loops:
================
In some cases, you really need the code block to be executed at least once. For example, if you need valid user input, you need to ask at least once. The same goes for trying to connect with a database or some other external source:

do {
  // code to be executed if the condition is true
} while (condition);

let number;
do {
  number = prompt("Please enter a number between 0 and 100: ");
} while (!(number >= 0 && number < 100));


for loops:
==========

for loops are special loops. The syntax might be a little bit confusing at first, but you will find yourself using them soon, because they are very useful.

Here is what the syntax looks like:

for (initialize variable; condition; statement) { 
  // code to be executed
}

for (let i = 0; i < 10; i++) {
  console.log(i);
}

for of loop:
============
There is another loop we can use to iterate over the elements of an array: the for of loop. It cannot be used to change the value associated with the index as we can do with the regular loop, but for processing values it is a very nice and readable loop.

Here is what the syntax looks like:

let arr = [some array];
for (let variableName of arr) {
  // code to be executed
  // value of variableName gets updated every iteration
  // all values of the array will be variableName once
}


for in loop:
=============
Manipulating objects with loops can also be done with another variation of the for loop, the for in loop. The for in loop is somewhat similar to the for of loop. Again here, we need to specify a temporary name, also referred to as a key, to store each property name in. We can see it in action here:

let car = {
  model: "Golf",
  make: "Volkswagen",
  year: 1999,
  color: "black",
};

for (let prop in car){
  console.log(car[prop]);
}

As you can see, all the names of the properties get printed, and not the values. This is because the for in loop is getting the property names (keys) and not the values. The for of is doing the opposite; it is getting the values and not the keys.

This for in loop can also be used on arrays, but it is not really useful. It will only return the indices, since these are the "keys" of the values of the arrays. 

*/