import React, { useState } from 'react';
import { Modal } from 'antd';
import JoinComponent from '../components/JoinComponent';
import * as service from '../actions';


const JoinContainer = () => {

    const [joinSuccess, setJoinSuccess] = useState(false); //회원 가입 성공 여부
    const [idOverlapCheck, setIdOverlapCheck] = useState(""); //회원 중복 체크 여부 상태값 : '', 'error', 'validating'

    let checkInfo = {
        joinSuccess: joinSuccess,
        idOverlapCheck: idOverlapCheck
    }

    /**
     * 회원 가입 요청
     * @param {*} data 
     */
    const joinAction = data => {
        service.joinAction(data)
        .then(response => {
            setJoinSuccess(true);
        })
        .catch(error => {
            Modal.error({
                title: "회원 가입 실페",
                content: "계속 장애 발생시 운영자에게 연락 바랍니다."
            });
        });
    }

    /**
     * 회원 가입시 ID 중복 체크
     * @param {*} data 
     */
    const idCheckAction = data => {
        if (data === "") {
            setIdOverlapCheck("");
            return false;
        }
        
        service.idCheckAction(data)
        .then(response => {
            console.log("response.data", response.data);
            setIdOverlapCheck(response.data);
        });
    }

    return (
        <JoinComponent
            onJoinAction={joinAction}
            onIdCheckAction={idCheckAction}
            checkInfo={checkInfo}
        />
    );
}

export default JoinContainer;