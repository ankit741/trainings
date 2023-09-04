/*

Primitives are compared by value, objects are compared by reference. 
If you compare two primitives having the same value, they are considered equal.

42 === 42 //true
'John' === 'John' //true


However, when comparing two objects, you need to be more careful. They are compared by their identity. That means it does not matter if the two objects have the same properties with the same values. They are equal only if they are the same instance. That is - if comparing two variables, they are equal only if they point to the very same object.

var john = {name: 'John', name: 'Doe'};
var stillJohn = john;
var evilTwin = {name: 'John', name: 'Doe'};

john === john //true
john === stillJohn //true
john === evilTwin //false

You can see that two variables can point to the same object. 
That is because a variable containing an object holds only a reference to that object. 
When you assign the reference to a new variable, now you have two variables holding the reference 
to the same object. That means changing the properties of the object stored in either of the variables 
will affect them both. This does not apply to primitives as they are not using references, 
their value is copied instead every time.
*/
