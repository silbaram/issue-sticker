import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import Login from './security/routers/login';
import Join from './security/routers/join';
import NotFoundContainer from './common/containers/notFoundContainer'


function App() {

    return (
      <BrowserRouter>
        {/* <Switch> */}
          <Login />
          <Join />
          {/* <Redirect path="*" to="/" /> */}
          {/* <Route component={NotFoundContainer} /> */}
        {/* </Switch> */}
      </BrowserRouter>
    );
}

export default App;
