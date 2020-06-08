import React from 'react';
import { Link } from "react-router-dom";
import { Layout, Menu } from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'
import '../style/index.css';
import {
    DashboardFilled,
    FileTextFilled,
    ProjectFilled,
    ScheduleFilled,
    ToolFilled
} from '@ant-design/icons';


const { Header, Content, Footer } = Layout;

const LayoutComponent = ({children, tabIndex}) => {

    console.log("LayoutComponent", tabIndex);
    return (
        <Layout className="layout" style={{ minHeight: '100vh' }}>
            <Header>
                <div className="logo" />
                <Menu theme="dark" mode="horizontal" defaultSelectedKeys={[{tabIndex}]}>
                    <Menu.Item key="1" icon={<DashboardFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>대시보드</Menu.Item>
                    <Menu.Item key="2" icon={<FileTextFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>이슈</Menu.Item>
                    <Menu.Item key="3" icon={<ScheduleFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>배포</Menu.Item>
                    <Menu.Item key="4" icon={<ProjectFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}> <Link to="/projects">프로젝트</Link> </Menu.Item>
                    <Menu.Item key="5" icon={<ToolFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>관리</Menu.Item>
                </Menu>
            </Header>

            <Layout style={{ padding: '0 24px 24px' }}>

                <Content
                    className="site-layout-background"
                    style={{
                        padding: 0,
                        margin: '16px 0',
                        minHeight: '500px'
                    }}
                >
                    {children}

                </Content>

                <Footer style={{ textAlign: 'center', padding: 0 }}>Issue Sticker ©2020 Created by PSJ</Footer>
            </Layout>
        </Layout>
    );
}

export default LayoutComponent;