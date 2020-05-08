import React from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { Form, Input, Button, Typography } from 'antd';
import styled from 'styled-components';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


const JoinComponent = (props) => {
    const { onJoinAction } = props;
    
    const { Title } = Typography;
    const StyledButton = styled(Button)`
        height: 40px;
        width: 450px;
    `;

    const onFinish = values => {
        onJoinAction(values);
    };

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
                    onFinish={onFinish}
                    >
                        <Form.Item
                            name="userid"
                            rules={[
                                {
                                    required: true,
                                    message: '필수 정보입니다.',
                                }
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
                                    message: '8~16자 영문, 숫자, 특수문자를 사용하세요.',
                                    // pattern: /(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
                                }
                            ]}
                        >
                            <Input.Password
                                size="large"
                                prefix={<LockOutlined />}
                                placeholder="비밀번호"
                            />
                        </Form.Item>

                        <Form.Item
                            name="confirm"
                            dependencies={['password']}
                            hasFeedback
                            rules={[
                                {
                                    required: true,
                                    message: '필수 정보입니다.',
                                },
                                ({ getFieldValue }) => ({
                                    validator(rule, value) {
                                        if (!value || getFieldValue('password') === value) {
                                            return Promise.resolve();
                                        }

                                        return Promise.reject('비밀번호가 일치하지 않습니다.');
                                    },
                                })
                            ]}
                        >

                            <Input.Password
                                size="large"
                                prefix={<LockOutlined />}
                                placeholder="비밀번호 재확인"
                            />
                        </Form.Item>

                        <Form.Item name={'name'}>
                            <Input
                                size="large"
                                placeholder="이름"
                            >
                            </Input>
                        </Form.Item>

                        <Form.Item 
                            name={'email'}
                            rules={[
                                {
                                    type: 'email',
                                    message: 'E-mail 형식이 잘못되었습니다.',
                                },
                                {
                                    required: true,
                                    message: '필수 정보입니다.',
                                }
                            ]}
                        >
                            <Input
                                size="large"
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