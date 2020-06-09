import React, { useReducer } from 'react';
import LoginComponent from '../components/LoginComponent';
import { message } from 'antd';
import * as service from '../actions';
import * as userLoginInfo from '../../common/reducers/actions'


const LoginContainer = ({ history }) => {

    const [userInfo, dispatchUserInfo] = useReducer(userLoginInfo.tokenReducer, userLoginInfo.initialTokenState)

    const topMessage = messageText => {
        message.error(messageText);
    }
    
    const loginAction = data => {
        service.login(data)
        .then(response => {
            dispatchUserInfo({ type: userLoginInfo.SET_LOGIN_TOKEN, isLogin: true, token: response.data.token });
            console.log("userInfo 1", userInfo);
            // TODO 페이지 이동 임시로 프로젝트 상세로 변경
            // history.push("/dashboard/personal");
            // history.push("/project/detail");
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