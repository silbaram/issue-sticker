import React, { useContext } from 'react';
import LoginComponent from '../components/LoginComponent';
import { message } from 'antd';

import * as service from '../actions';

import * as storeAction from "../../common/reducers/action/action"
import { store } from '../../common/reducers/store/store';


const LoginContainer = ({ history }) => {

    const globalStore = useContext(store);
    const { dispatch } = globalStore;
    const topMessage = messageText => {
        message.error(messageText);
    }


    /**
     * 서버에 로그인 요청
     * @param {*} data 
     */
    const loginAction = data => {
        service.login(data)
        .then(response => {

            dispatch({type: storeAction.SET_LOGIN_TOKEN, token: response.data.token});

            // TODO 페이지 이동 임시로 프로젝트 상세로 변경
            // history.push("/dashboard/personal");
            history.push("/projects");
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