import React from 'react';
import { Link } from "react-router-dom";
import { Result, Button } from 'antd';


const JoinSuccess = () => {

    return (
        <div style={{paddingTop:200}}>
        <Result
            status="success"
            title="회원 가입 완료!"
            subTitle="회원 가입 승인 대기 상태 입니다. 승인 완료 후 서비스 이용 가능 합니다."
            extra={[
                <Button type="primary" key="console">
                    <Link to="/security/login">로그인</Link>
                </Button>,
            ]}

        />
        </div>
    );
}

export default JoinSuccess;