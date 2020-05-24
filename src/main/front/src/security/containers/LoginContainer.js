import React from 'react';
import LoginComponent from '../components/LoginComponent';
import {message} from 'antd';
import * as service from '../actions';


const LoginContainer = () => {

    const topMessage = messageText => {
        message.error(messageText);
    }
    
    const loginAction = data => {
        service.login(data)
        .then(response => {
            // TODO 페이지 이동 추가
            console.log(response);
            window.location.href = "/dashboard/personal";
        })
        .catch(error => {
            topMessage("가입 승인 대기 중이거나 잘못된 로그인 정보입니다.");
        });
    }

    return (
        <LoginComponent onLoginAction={loginAction} />
    );
}

export default LoginContainer;