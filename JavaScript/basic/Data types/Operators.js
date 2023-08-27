
//Arithmetic Operation :

{

    let x = 5, y = 10;

    let z = x + y; //performs addition and returns 15

    z = y - x; //performs subtraction and returns 5

    z = x * y; //performs multiplication and returns 50

    z = y / x; //performs division and returns 2

    z = x % 2; //returns division remainder 1

}

//Post and Pre Increment/Decrement :

{
    let x = 5;

    x++; //post-increment, x will be 5 here and 6 in the next line

    ++x; //pre-increment, x will be 7 here  

    x--; //post-decrement, x will be 7 here and 6 in the next line

    --x; //pre-decrement, x will be 5 here
}

//String Concatenation
//The + operator performs concatenation operation when one of the operands is of string type
{
    let a = 5, b = "Hello ", c = "World!", d = 10;

    a + b; //returns "5Hello "

    b + c; //returns "Hello World!"

    a + d; //returns 15

    b + true; //returns "Hello true"

    c - b; //returns NaN; - operator can only used with numbers
}


//Comparison Operators

{
    let a = 5, b = 10, c = "5";
    let x = a;

    a == c; // returns true

    a === c; // returns false

    a == x; // returns true

    a != b; // returns true

    a > b; // returns false

    a < b; // returns true

    a >= b; // returns false

    a <= b; // returns true
}

//Logical Operators

{
    let a = 5, b = 10;

    (a != b) && (a < b); // returns true

    (a > b) || (a == b); // returns false

    (a < b) || (a == b); // returns true

    !(a < b); // returns false

    !(a > b); // returns true
}

//Assignment Operators

{
    let x = 5, y = 10, z = 15;

    x = y; //x would be 10

    x += 1; //x would be 6

    x -= 1; //x would be 4

    x *= 5; //x would be 25

    x /= 5; //x would be 1

    x %= 2; //x would be 1
}

//Ternary Operator
{
let a = 10, b = 5;

let c = a > b? a : b; // value of c would be 10
let d = a > b? b : a; // value of d would be 5
}




//The precedence of operators determines the order they are applied when evaluating an expression.

const x = 1 + 2 * 3;
const y = 2 * 3 + 1;

//Despite * and + coming in different orders, both expressions would result in 7 
//because * has precedence over +, so the *-joined expression will always be evaluated first.

