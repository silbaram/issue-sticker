import React from 'react';
import { BrowserRouter, Switch, Route, Link } from "react-router-dom";
import { Login, Join, NotFount } from './pages/'


function App() {

    return (
      <BrowserRouter>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/join">Join</Link>
        </li>
      </ul>


        <Switch>
          {/* <Login /> */}
          {/* <Join /> */}
          <Route path="/" exact component={Login}></Route>
          <Route path="/join" component={Join}></Route>
          <Route component={NotFount} />
        </Switch>
      </BrowserRouter>
    );
}

export default App;
