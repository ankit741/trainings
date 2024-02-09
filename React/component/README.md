# Defining a component :

A React component is a self-contained piece of code that defines a specific piece of the user interface. React components are the building blocks of React applications by allowing us to couple markup (HTML), logic (JS), and styles (CSS) within them.

Traditionally when creating web pages, web developers marked up their content and then added interaction by sprinkling on some JavaScript. This worked great when interaction was a nice-to-have on the web. Now it is expected for many sites and all apps. React puts interactivity first while still using the same technology: a React component is a JavaScript function that you can sprinkle with markup.

React components can be of two types – It can be either class or function components. You might have heard different terms to describe these types, i.e. stateless and stateful. This state can be modified according to user action or other factors. 

# Step 1: Export the component 

The export default prefix is a standard JavaScript syntax (not specific to React). It lets you mark the main function in a file so that you can later import it from other files. (More on importing in Importing and Exporting Components!)

# Step 2: Define the function 

With function Profile() { } you define a JavaScript function with the name Profile.

Note: React components are regular JavaScript functions, but their names must start with a capital letter or they won’t work!

# Step 3: Add markup 

The component returns an <img /> tag with src and alt attributes. <img /> is written like HTML, but it is actually JavaScript under the hood! This syntax is called JSX, and it lets you embed markup inside JavaScript.

Return statements can be written all on one line, as in this component:

```
return <img src="https://abc.com/xyz.jpg" alt="cat" />;
```

ex. 
```
return (
  <div>
     <img src="https://abc.com/xyz.jpg" alt="cat" />
  </div>
);
```

# 1 Functional Components :

As the React docs tell us, “The simplest way to define a component is to write a JavaScript function”. This is a normal JavaScript function except that it returns a JSX React element. JSX, if you’re not familiar, is just a special type of HTML that is adapted for JavaScript.

```
function Banner(){
  return <div> Hello World </div>;
}
```

# 2 Creating components with styled-components:

So how do we style our new React component? Well, there are 3 ways to style a component as well. You can inline style, like so:

```
function Banner(){
  return <div style={{border: '1px solid red'}}> Hello World </div>;
}
```

You can also add a CSS class with the className attribute, which is the JSX alias for the HTML class attribute. We can’t type class because it's already a reserved word in JS. Anyway, adding a CSS class looks like this:

```
function Banner(){
  return <div className="border-red"> Hello World </div>;
}


// App.css
.border-red {
  border: 1px solid red; 
}
```

The third way, which is to use styled components. Here, we don’t need to add any CSS files or class names, we just define the CSS directly in the component definition.


# 3 Class components:

Before React Hooks, Class components were the recommended way of creating React components with full life-cycle methods and state. This uses the ES6 Class methods. Here is an example of a class component:
```
import React from 'react'
class Banner extends React.Component {
  render(){
    return <div> Hello World </div> 
  }
}
```
 
Class components are not deprecated and will continue to live on for the foreseeable future, so they are important to learn.
