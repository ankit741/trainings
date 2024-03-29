# 1. You need to install Node.js for local development. You’ll need to have Node >= 14.0.0 and npm >= 5.6 on your machine. 
    https://nodejs.org/en/download

# 2. Create new project, you may choose one of the following methods:

NPX:
```
npx create-react-app my-app
   cd my-app
   npm start
```

(npx is a package runner tool that comes with npm 5.2+ and higher)

NPM :

```
npm init react-app my-app
   cd my-app
   npm start
```

(npm init is available in npm 6+)

Yarn:

```
yarn create react-app my-app
   cd my-app
   yarn start
```

(yarn create <starter-kit-package> is available in Yarn 0.25+)


It will create a directory called my-app inside the current folder.
Inside that directory, it will generate the initial project structure and install the transitive dependencies:
```
my-app
├── README.md
├── node_modules
├── package.json
├── .gitignore
├── public
│   ├── favicon.ico
│   ├── index.html
│   └── manifest.json
└── src
    ├── App.css
    ├── App.js
    ├── App.test.js
    ├── index.css
    ├── index.js
    ├── logo.svg
    └── serviceWorker.js
    └── setupTests.js

```

Open http://localhost:3000 to view it in the browser.


# 3. npm run build or yarn build
Builds the app for production to the build folder.
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.

Your app is ready to be deployed.



# Note :

The React team primarily recommends these solutions:

If you’re learning React or creating a new single-page app, use Create React App.
If you’re building a server-rendered website with Node.js, try Next.js.
If you’re building a static content-oriented website, try Gatsby.
If you’re building a component library or integrating with an existing codebase, try More Flexible Toolchains.
