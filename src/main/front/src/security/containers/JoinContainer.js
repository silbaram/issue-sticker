import React, { useState } from 'react';
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
    function joinAction(data) {
        let result = service.joinAction(data);
        if(result) {
            setJoinSuccess(result);
        }
    }

    /**
     * 회원 가입시 ID 중복 체크
     * @param {*} data 
     */
    function idCheckAction(data) {
        console.log("idCheckAction", data);
        // setIdOverlapCheck("validating");
        // setIdOverlapCheck("error");
        // setIdOverlapCheck("success");
        setIdOverlapCheck("");
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