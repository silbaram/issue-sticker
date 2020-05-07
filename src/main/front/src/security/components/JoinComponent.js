import React from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import {Form, Input, Button, Typography} from 'antd';
import styled from 'styled-components';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


const JoinComponent = () => {
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

                        <Form.Item name={'name'}>
                            <Input
                                size="large"
                                placeholder="이름"
                            >
                            </Input>
                        </Form.Item>

                        <Form.Item name={'email'}>
                            <Input
                                size="large"
                                addonAfter="@example.com"
                                placeholder="이메일"
                            >
                            </Input>
                        </Form.Item>

                        <Form.Item>
                            <StyledButton type="primary" htmlType="submit">
                            Join
                            </StyledButton>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        </div>
    );
}

export default JoinComponent;