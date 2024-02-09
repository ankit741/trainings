# What is the state in React?
In simple terms, a state is simply an object that contains all your key-value pairs. The state determines how your components render and behave.

The state allows your components to be dynamic and interactive.

The state is not to be confused with props. The state is what is managed within the component, whereas props are what gets passed to the component.


# How do classes manage local state in React?


Class components come from ES6 classes and are the default method for managing the local state. They also allow side effects to occur through lifecycle methods.

To access and manage the state in a class, you have to initialize this. state as an object within your constructor(), name your local state as a key and set its initial value as the key’s value.

setState() is the default method for updating the state in a class, and this is what causes a component to re-render.

Furthermore, it is recommended to call setState() every time you want to modify the state correctly pre-hooks.
