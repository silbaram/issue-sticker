import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Button, Breadcrumb } from 'antd'
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <Button>Test</Button>
      <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>User</Breadcrumb.Item>
          <Breadcrumb.Item>Bill</Breadcrumb.Item>
      </Breadcrumb>
    </div>
  );
}

export default App;
