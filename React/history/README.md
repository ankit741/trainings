# 1. What is React?

React(aka React.js or ReactJS) is an open-source front-end JavaScript library that is used for building composable user interfaces, especially for single-page applications. It is used for handling the view layer for web and mobile apps based on components in a declarative approach.

React was created by Jordan Walke, a software engineer working for Facebook. React was first deployed on Facebook's News Feed in 2011 and on Instagram in 2012.


# 2. What is the history behind React evolution?

The history of ReactJS started in 2010 with the creation of XHP. XHP is a PHP extension that improved the syntax of the language such that XML document fragments become valid PHP expressions and the primary purpose was to create custom and reusable HTML elements.

The main principle of this extension was to make front-end code easier to understand and to help avoid cross-site scripting attacks. The project was successful in preventing the malicious content submitted by the scrubbing user.

However there was a different problem with XHP in which dynamic web applications require many roundtrips to the server, and XHP did not solve this problem. Also, the whole UI was re-rendered for a small change in the application. Later, the initial prototype of React was created with the name FaxJ by Jordan inspired by XHP. Finally, after some time React has been introduced as a new library into the JavaScript world.

## Note: JSX comes from the idea of XHP


3. What are the major features of React?

The major features of React are:

- Uses JSX syntax, a syntax extension of JS that allows developers to write HTML in their JS code.
- It uses Virtual DOM instead of Real DOM considering that Real DOM manipulations are expensive.
- Supports server-side rendering which is useful for Search Engine Optimizations(SEO).
- Follows Unidirectional or one-way data flow or data binding.
- Uses reusable/composable UI components to develop the view.



# 4. What is JSX?

JSX stands for JavaScript XML and it is an XML-like syntax extension to ECMAScript. It just provides the syntactic sugar for React.createElement(type, props, ...children) function, giving us the expressiveness of JavaScript along with HTML-like template syntax.

In the example below, the text inside tag is returned as a JavaScript function to the render function.

```
export default function App() {
  return (
      <h1 className="greeting">{"Hello, this is a JSX Code!"}</h1>
  );
}
```

If you don't use JSX syntax then the respective JavaScript code should be written as below,

```
import { createElement } from 'react';

export default function App() {
  return createElement(
    'h1',
    { className: 'greeting' },
    'Hello, this is a JSX Code!'
  );
}

```
