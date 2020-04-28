import React from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import {Form, Input, Button, Typography} from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


function LoginContainer() {
    const { Title } = Typography;

    return (
        <div style={{ position: "relative", minHeight:200 }}>
            <div style={{ width: 750, margin: "0 auto", textAlign: "center" }}>
                <div style={{ position: "relative", paddingTop: 150, boxSizing: 168 }}>
                    <Title>Issue Sticker</Title>
                </div>  
                <div style={{ paddingTop: 50 }}>
                    <Form
                        name="loginForm"
                        initialValues={{ remember: true }}
                    >
                        <Form.Item
                            name="useremail"
                            rules={[
                            {
                                required: true,
                                message: '아이디를 입력해주세요.',
                            },
                            ]}
                        >
                            <Input 
                                prefix={<UserOutlined className="site-form-item-icon" />}
                                placeholder="아이디"
                                style={{ height: 50, width: 450 }}
                            />
                        </Form.Item>

                        <Form.Item
                            name="password"
                            rules={[
                            {
                                required: true,
                                message: '비밀번호를 입력해주세요.',
                            },
                            ]}
                        >
                            <Input.Password 
                            prefix={<LockOutlined type="auto" className="site-form-item-icon" />}
                                placeholder="비밀번호"
                                style={{ height: 50, width: 450 }}
                            />
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit" style={{ height: 50, width: 450 }}>
                            Login
                            </Button>
                        </Form.Item>
                    </Form>
                </div>
                <hr style={{ width: 450 }} />
                <div>
                    <Button type="link">아이디 찾기</Button>
                    <Button type="link">비밀번호 찾기</Button>
                    <Button type="link">회원가입</Button>
                </div>
            </div>
        </div>
    );
}

export default LoginContainer;