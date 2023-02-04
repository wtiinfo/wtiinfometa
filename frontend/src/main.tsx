import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

// case dark screen in Netlify uncomment window.React = React

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
