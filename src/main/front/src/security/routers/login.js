import React from 'react';
import { Route } from "react-router-dom";
import LoginContainer from '../containers/LoginContainer';


const Login = () => {
    return (
        <Route exact path="/" component={LoginContainer} />
    );
}

export default Login;