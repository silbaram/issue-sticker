import React from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import {Form, Input, Button, Typography} from 'antd';
import styled, { css } from 'styled-components';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


function JoinContainer() {
    const { Title } = Typography;

    const paddingTop = css`
        padding-top: 13px;
    `;
    const commonHeightWidth = css`
        height: 50px;
        width: 450px;
    `;
    const StyledUserOutlined = styled(UserOutlined)`
        ${paddingTop}
    `;
    const StyledLockOutlined = styled(LockOutlined)`
        ${paddingTop}
    `;
    const StyledButton = styled(Button)`
        ${commonHeightWidth}
    `;
    const StyleInput = styled(Input)`
        ${commonHeightWidth}
    `;
    const StyleInputPassword = styled(Input.Password)`
        ${commonHeightWidth}
    `;

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
                            <StyleInput 
                                prefix={<StyledUserOutlined />}
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
                            <StyleInputPassword
                                prefix={<StyledLockOutlined />}
                                placeholder="비밀번호"
                                style={{ height: 50, width: 450 }}
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
                </div>
            </div>
        </div>
    );
}

export default JoinContainer;