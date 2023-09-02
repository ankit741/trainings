/*
JavaScript is a dynamically typed language. 
It means that a variable doesn’t associate with a type. In other words, a variable can hold a value of different types.
types are associated with values not variables.

There are eight basic data types in JavaScript. 

Primitive :

1. String
2. Number
3. Bigint (available from ES2020)
4. Boolean
5. Undefined
6. Null
7. Symbol (available from ES2015)

Almost all javascript values have properties. excetpt null and undefined.


Reference :

8. Object data type can contain:
1. An object
2. An array
3. A date
4.function

typeof() helps you identify  the type of value that the variable stores.

*/

//primitive types :

let age = 120; // age is a number
console.log(typeof age);
age = false;   // age is now a boolean
console.log(typeof age);
age = 'hello';   // age is now a string
console.log(typeof age);

age = null; // age is now null 
/*
The typeof null returns object is a known bug in JavaScript. A proposal to fix this was proposed but rejected. 
The reason was the that fix would break a lot of existing sites.
*/
console.log(typeof age); // it's primitive though

age = undefined;
console.log(typeof age);// age is now undefined
age = Symbol();
console.log(typeof age);// age is now symbol
age = BigInt(30);
console.log(typeof age); // age is now bigint



//String

let name="ankit";
console.log(typeof name);
console.log(name.toUpperCase());
console.log(name.length);

let dog='This is a \'dog\'.';
console.log(dog);

let cat="This is a \"cat\"." //escaping(\) marker that tells interpreter that next char is special.
console.log(cat);

let newLine='hello\n world!';
console.log(newLine);

//Number


let a =0.1+0.2;  // is not equal to 0.3
console.log(a);

/*
 why 0.1 + 0.2 does not equal to 0.3?

Binary floating point math is like this. In most programming languages, it is based on the IEEE 754 standard. The crux of the problem is that numbers are represented in this format as a whole number times a power of two; rational numbers (such as 0.1, which is 1/10) whose denominator is not a power of two cannot be exactly represented.

It’s actually rather interesting. When you have a base-10 system (like ours), it can only express fractions that use a prime factor of the base. The prime factors of 10 are 2 and 5. So 1/2, 1/4, 1/5, 1/8, and 1/10 can all be expressed cleanly because the denominators all use prime factors of 10. In contrast, 1/3, 1/6, 1/7 and 1/9 are all repeating decimals because their denominators use a prime factor of 3 or 7.

In binary (or base-2), the only prime factor is 2, so you can only cleanly express fractions whose denominator has only 2 as a prime factor. In binary, 1/2, 1/4, 1/8 would all be expressed cleanly as decimals, while 1/5 or 1/10 would be repeating decimals. So 0.1 and 0.2 (1/10 and 1/5), while clean decimals in a base-10 system, are repeating decimals in the base-2 system the computer uses. When you perform math on these repeating decimals, you end up with leftovers which carry over when you convert the computer’s base-2 (binary) number into a more human-readable base-10 representation.

Do not do if (x == y) { ... }

Instead do if (abs(x - y) < myToleranceValue) { ... }.
*/

/*
javaScript numbers are always store as double floating point number.(double precision 64 -bit)
32 bits (single precision) and 64 bits (double precision).
number is broken into two categories :
-actual number 
-location of decimal(or point)
ex-
0.005

5.0 is most significant number(may represent a number or fractional part) also known as mentissa.
10^-3 to know where decimal point belongs (-3 here is exponent)


Scientific notation is a way of writing very large or very small numbers. 
==================

0.0000000000000976 => 9.76*10^-14
976,000,000,000,000 => 9.76*10^14

Representation:
=================
sign, exponent, significand:
(–1)sign × significand × 2exponent 

more bits for significand gives more accuracy
more bits for exponent increases range

single precision 32 bit :
=========================

          S  EEEEEEEE   MMMMMMMMMMMMMMMMMMMMMMM
bits:    31 30      23 22                     0

1 bit for the sign, S
8 bits for the exponent, 'E'
24 bits for the fraction, also called mantissa

A double precision 64 bit:
==========================

1 bit for the sign, S
11 bits for the exponent, 'E'
53 bits for the fraction / mantissa / coefficient (even though only 52 are represented), 'M'
Representation:

           S  EEEEEEEEEEE   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
bits:     63 62         52 51   
*/


let x=10,y=10.000;
console.log(x==y);

let n=3e2;
console.log(n);

let bigNumber=1000e1000; //A number reaches Infinity/-Infinity when it exceeds the upper/lower limit for a number:
console.log(bigNumber);

console.log(typeof Infinity);

console.log(1+Infinity);
console.log(1/Infinity);

console.log(Infinity/Infinity);
console.log(Infinity % 2);

console.log(Number.isFinite(100));

//NaN

console.log(Number.NaN);

console.log(NaN>1);
console.log(NaN<1);
console.log(NaN==NaN);
console.log(isNaN(NaN));

//Boolean

let isTrue=true;
let isFalse=false;

console.log(typeof isTrue);

var IsLoggedIn = new Boolean(0); // false
var IsLoggedIn = new Boolean(NaN); // false
var IsLoggedIn = new Boolean("Foo"); // true
var IsLoggedIn = new Boolean(1); // true

//Null

console.log(typeof null);
console.log(1+null); // null type casted to 0


//Undefined
let v;
console.log(v);
console.log(v+5); //NaN



//reference types :

let nameArr = ["Chris", "Bob", "Jim"];
console.log(typeof nameArr); //object
console.log(nameArr);

let nums = [1, 2, 3, 4, 5, 6];
console.log(typeof nums); //object
console.log(nums);
//ftech value from 0th index.
console.log(nums[0]);

const today = new Date();
console.log(typeof today)
console.log(today)

//Creating new objects:

//Object literal

/*The object literal is one of the most popular patterns for creating objects in JavaScript because of its simplicity
Objects created with initializers are called plain objects,
because they are instances of Object, but not any other object type.*/

let person = {
    name: 'john', // property name may be an identifier
    age: 30,
    address: {
        city: 'Delhi',
        pin: 122010
    },
    print: function func() { return 'hello' },
    printAge() {
        console.log(this.age);
    }
};

console.log(typeof person) //object
console.log(person)
console.log(person["age"]) // another way to access the value
console.log(person.name)
console.log(person.address.city)
console.log(person.print())
person.printAge();




//Using a constructor function :

/*
Alternatively, you can create an object with these two steps:
Define the object type by writing a constructor function. 
There is a strong convention, with good reason, to use a capital initial letter.
Create an instance of the object with new.
*/

//To define an object type, create a function for the object type that specifies its name, properties, and methods.

function Car(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;
}

/*
When a function is executed with new, it does the following steps:

A new empty object is created and assigned to this.
The function body executes. Usually it modifies this, adds new properties to it.
The value of this is returned.

function User(name) {
  // this = {};  (implicitly)

  // add properties to this
  this.name = name;
  this.isAdmin = false;

  // return this;  (implicitly)
}
*/
const myCar = new Car("Eagle", "Talon TSi", 1993);

console.log(myCar);
console.log(myCar.year);
console.log(typeof myCar)

const yourCar = Car("Eagle1", "Talon TSi1", 1993);

console.log(yourCar);
// console.log(yourCar.year);
// console.log(typeof yourCar)

function Bike(name,price){
    if (!new.target) { // if without new
        return new Bike(name,price); //  will add new for you
      }
    this.name = name;
    this.price=price;
    this.getPrice=function(){
        return this.price;
    }
}
const bike=Bike("apache",150000);
console.log(bike.name);
console.log(bike.getPrice());

//With new we all know that the new object is being created.

//function expression.

let Student= function(name,age){
    this.name=name;
    this.age=age;
    }
    
    let ankit=new Student('ANKIT',20);
    console.log(ankit.name);
    console.log(ankit.age);


//Object.create() method

/*
Objects can also be created using the Object.create() method. 
This method can be very useful, because it allows you to choose the prototype object for the object you want to create, without having to define a constructor function.
*/

// Animal properties and method encapsulation
const Animal = {
    type: "Invertebrates",
    displayType() {
        // Method which will display type of Animal
        console.log(this.type);
    },
};

// Create new animal type called animal1
const animal1 = Object.create(Animal);
animal1.displayType(); // Logs: Invertebrates

