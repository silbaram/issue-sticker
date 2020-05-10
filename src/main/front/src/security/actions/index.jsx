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
 */
export function idCheckAction(data) {

}
