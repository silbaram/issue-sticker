import React, { useContext } from 'react';
import LoginComponent from '../components/LoginComponent';
import { message } from 'antd';
import * as service from '../actions';
import { store } from '../../common/reducers/store/store';
import * as storeAction from "../../common/reducers/action/action"

const LoginContainer = ({ history }) => {

    const globalState = useContext(store);
    const { dispatch } = globalState;

    const topMessage = messageText => {
        message.error(messageText);
    }
    
    const loginAction = data => {
        service.login(data)
        .then(response => {
            dispatch({type: storeAction.SET_LOGIN_TOKEN, token: response.data.token});

            // TODO 페이지 이동 임시로 프로젝트 상세로 변경
            // history.push("/dashboard/personal");
            history.push("/project/detail");
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