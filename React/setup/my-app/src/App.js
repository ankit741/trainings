import './App.css';
import HelloWorld from './components/HelloWorld'
import Profile from './components/User'
import Clock from './components/Clock'
import Clock1 from './components/Clock1'

function App() {
  return (
    <div className="App">
        <HelloWorld/>
        <Profile/>
        <Clock date={new Date()} />
        <Clock1/>
    </div>
  );
}

export default App;
