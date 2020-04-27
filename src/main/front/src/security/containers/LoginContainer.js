import React from 'react';
import { UserOutlined } from '@ant-design/icons';
import {Layout, Form, Input, Button, Card} from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


function LoginContainer() {
    const { Header, Footer, Content } = Layout;

    return (
        <div>
        <Layout>
            <Content>
                <Card title="Login" style={{ width: 500, top: 150 }}>
                    <Form
                        name="loginForm"
                        initialValues={{ remember: true }}
                    >
                        <Form.Item
                            label="User Email"
                            name="username"
                            rules={[
                            {
                                required: true,
                                message: 'Please input your username!',
                            },
                            ]}
                        >
                            <Input 
                                prefix={<UserOutlined className="site-form-item-icon" />}
                            />
                        </Form.Item>

                        <Form.Item
                            label="Password"
                            name="password"
                            rules={[
                            {
                                required: true,
                                message: 'Please input your password!',
                            },
                            ]}
                        >
                            <Input.Password />
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit">
                            Login
                            </Button>
                        </Form.Item>
                    </Form>
                </Card>
            </Content>
        </Layout>
        </div>
    );
}

export default LoginContainer;