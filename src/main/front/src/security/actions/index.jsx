import { Modal } from 'antd';
import axios from 'axios';


/**
 * 회원 가입 요청
 * @param {*} data 
 */
export function joinAction(data) {

    let result;

    axios.post('/security/join', data)
    .then(function(response) {
        result = true;
    }).catch(function(error) {
        Modal.error({
            title: "회원 가입 실페",
            content: "계속 장애 발생시 운영자에게 연락 바랍니다."
        });

        result = false;
    });

    return result;
}


/**
 * 회원 가입시 ID 중복 체크
 * @param {*} data 
 * @return true:중복, false:사용가능
 */
export function idCheckAction(data) {

    // let result;

    // axios.get('/security/check/'+data)
    // .then(function(response) {
    //     console.log("response", response);
    //     console.log("response.data", response.data);
    //     if(response.data) {
    //         result = "success"; //사용가능
    //     } else {
    //         result = "error";   //중복
    //     }    
    // }).catch(function(error) {
    //     Modal.error({
    //         title: "아이디 중족 체크 실페",
    //         content: "계속 장애 발생시 운영자에게 연락 바랍니다."
    //     });

    //     result = ""; //체크가 안됨
    // });

    // return result;

    return "error";
}
