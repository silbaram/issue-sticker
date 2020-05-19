import React from 'react';
import LoginComponent from '../components/LoginComponent';
import * as service from '../actions';


const LoginContainer = () => {

    const loginAction = data => {
        service.login(data)
        .then(response => {
            console.log(response);
        }).catch(error => {
            console.log(error);
        });
    }

    return (
        <LoginComponent onLoginAction={loginAction} />
    );
}

export default LoginContainer;