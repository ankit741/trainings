# The origin of React hooks
Originally, React mainly used class components, which can be strenuous at times as you always had to switch between classes, higher-order components, and render props. With React hooks, you can now do all these without switching, using functional components. Hooks make React so much better because you have simpler code that implements similar functionalities faster and more effectively. You can also implement React state and lifecycle methods without writing classes.

Below are code examples to illustrate React class and functional components.

```
import React, { Component } from 'react'
 
export default class Hello extends Component {
    render() {
        return(
            <div>
            Hello World!
            </div>
        )
    }
}
```

The code above is a class component that prints “Hello World” in the DOM.

```
import React from 'react'
 
export default function Hello() {
    return (
        <div>
            Hello World!
        </div>
    )
}
```
The code above is a functional component that prints “Hello World” on the DOM.

Comparing both sets of code above, the functional component has significantly simpler code that performs the same function; there’s no need to allocate space to a class instance, and then call a render() function, you just call the function. React hooks have so many benefits and functions they perform, but one of the big ones is to make the React lifecycle methods easier.

NOTE: You cannot use React hooks on class components.

# How have hooks made the React lifecycle easier?
The various lifecycle methods in React include mounting, updating, and unmounting.

Mounting inserts elements into the DOM.
Updating as the name implies, updates elements in the DOM.
Unmounting removes elements from the DOM.
Below is an illustration of the various React lifecycle methods:

Initially, you could only use these lifecycle methods with class components, which usually comprise a lot of carefully engineered code that is more difficult to write or understand than when you use hooks to implement them as functional components.

Take, for instance, if you try to fetch user data using a componentDidMount() in a class component like in the code below:

```
import React, { Component } from 'react'
import Axios from 'axios'
 
export default class Hello extends Component {
 
    constructor(props) {
        super(props);
        this.state = { name: ""};
    }
 
    componentDidMount() {
        Axios.get('/api/user/name')
        .then(response => {
            this.setState({ name: response.data.name })
        })
    }
 
    render() {
        return (
            <div>
                My name is {this.state.name}
            </div>
        )
    }
}
```
Now let’s compare it to doing the same thing with a functional component by using the useState and useEffect hooks in the code below:
```
import React, { useEffect, useState } from 'react'
import Axios from 'axios'
 
export default function Hello() {
 
    const [Name, setName] = useState("")
 
    useEffect(() => {
        Axios.get('/api/user/name')
        .then(response => {
            setName(response.data.name)
        })
    }, [])
 
    return (
        <div>
            My name is {Name}
        </div>
    )
}
```
The code above collects user data by using the Axios API and prints it on the DOM. The useEffect and useState hooks make for more straightforward and concise code that is easy to understand and work on than the class components. When using lifecycle in class components, the componentDidMount(), componentDidUpdate(), componentWillUnmount() methods are handled individually, but when using React hooks, you can just do everything through the useEffect hook.
