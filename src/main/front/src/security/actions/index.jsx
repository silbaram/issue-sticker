import { Modal } from 'antd';
import axios from 'axios';


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
