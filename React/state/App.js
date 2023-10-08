import './App.css';
import Clock from './components/Clock'
import Clock1 from './components/Clock1'

function App() {
  return (
    <div className="App">
        <Clock date={new Date()} />
        <Clock1/>
    </div>
  );
}

export default App;
