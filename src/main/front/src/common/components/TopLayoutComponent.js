import React from 'react';
import { Layout, Menu, Breadcrumb } from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'
import '../style/index.css';


const { Header, Content, Footer } = Layout;

const LayoutComponent = ({children}) => {

    return (
        <Layout className="layout">
            <Header>
                <div className="logo" />
                <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                    <Menu.Item key="1">대시보드</Menu.Item>
                    <Menu.Item key="1">배포</Menu.Item>
                    <Menu.Item key="1">이슈</Menu.Item>
                </Menu>
            </Header>

            <Content style={{ padding: '0 50px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>Home</Breadcrumb.Item>
                    <Breadcrumb.Item>List</Breadcrumb.Item>
                    <Breadcrumb.Item>App</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-content">
                {children}
                </div>
            </Content>

            <Footer style={{ textAlign: 'center' }}>Issue Sticker ©2020 Created by PSJ</Footer>
        </Layout>
    );
}

export default LayoutComponent;