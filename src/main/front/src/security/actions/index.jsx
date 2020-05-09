import axios from 'axios';
import { Modal, Button, Space } from 'antd';

const joinAction = data => {

    axios.post('/security/join', data)
    .then(function(response) {
        document.location.href = "/join-success";
    }).catch(function(error) {
        
        Modal.error({
            title: "회원 가입 실페",
            content: "계속 장애 발생시 운영자에게 연락 바랍니다."
        });
    });
}

export default joinAction;