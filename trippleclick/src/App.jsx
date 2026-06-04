import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function App() {
  const [count, setCount] = useState(1
    
  )
  function handleClick() {    setCount(count + 1);
    if(count%3 == 0){setClicks(clicks * 2)}
  }
   const [clicks, setClicks] = useState(1)

  return (
    <>
       <h1>{clicks}</h1>
       <button onClick={handleClick}>Click me</button>
    </>
  )
}

export default App
