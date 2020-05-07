import React from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import {Form, Input, Button, Typography} from 'antd';
import styled from 'styled-components';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


const LoginComponent = () => {
    const { Title } = Typography;

    const StyledButton = styled(Button)`
        height: 40px;
        width: 450px;
    `;

    return (
        <div style={{ position: "relative", minHeight:200 }}>
            <div style={{ width: 450, margin: "0 auto", textAlign: "center" }}>
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
                                size="large"
                                prefix={<UserOutlined />}
                                placeholder="아이디"
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
                                size="large"
                                prefix={<LockOutlined />}
                                placeholder="비밀번호"
                            />
                        </Form.Item>

                        <Form.Item>
                            <StyledButton type="primary" htmlType="submit">
                            Login
                            </StyledButton>
                        </Form.Item>
                    </Form>
                </div>
                <hr style={{ width: 450 }} />
                <div>
                    <Button type="link">아이디 찾기</Button>
                    <Button type="link">비밀번호 찾기</Button>
                    <Button type="link" href="/join">회원가입</Button>
                </div>
            </div>
        </div>
    );
}

export default LoginComponent;