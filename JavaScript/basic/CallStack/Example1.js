/*
JavaScript is a single-threaded language as it utilizes only one “Call Stack” for the management 
of the “Global” and “Function“ Execution Contexts. Call Stack in JavaScript is a type of 
data structure that maintains the tracks of invoked and executed functions.

Push, Pop, and Top are the three terms commonly used while discussing Call Stack in JavaScript. 

Call Stack is based on the Last In First Out (LIFO) principle, 
which signifies that the last function pushed to it will pop out first when the function returns or 
finishes its execution.

When the JavaScript engine executes this script, it places the global execution context
 (denoted by main() or global() function on the call stack.

 The call stack uses the stack data structure that works based on the LIFO (last-in-first-out) principle.

*/

/*
Stack overflow :

The call stack has a fixed size, depending on the implementation of the host environment, 
either the web browser or Node.js.

If the number of execution contexts exceeds the size of the stack, 
a stack overflow error will occur.

For example, when you execute a recursive function that has no exit condition, 
the JavaScript engine will issue a stack overflow error:
*/

function test() {
    test();
}

test(); // stack overflow