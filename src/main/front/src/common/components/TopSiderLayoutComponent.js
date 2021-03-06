import React, { useState }  from 'react';
import { Layout, Menu } from 'antd';
import 'antd/dist/antd.css';
import '../style/index.css';
import {
    DashboardFilled,
    FileTextFilled,
    ProjectFilled,
    ScheduleFilled,
    ToolFilled,

    DesktopOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
} from '@ant-design/icons';


const { Header, Content, Sider, Footer } = Layout;
const { SubMenu } = Menu;

const LayoutComponent = ({children}) => {

    const [collapsed, setCollapsed] = useState(false);

    const onCollapse = collapsed => {
        setCollapsed(collapsed);
    };

    return (
        <Layout style={{ minHeight: '100vh' }}>
            <Header className="header">
                <div className="logo" />
                <Menu theme="dark" mode="horizontal" defaultSelectedKeys={["1"]}>
                    <Menu.Item key="1" icon={<DashboardFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>대시보드</Menu.Item>
                    <Menu.Item key="2" icon={<FileTextFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>이슈</Menu.Item>
                    <Menu.Item key="3" icon={<ScheduleFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>배포</Menu.Item>
                    <Menu.Item key="4" icon={<ProjectFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>프로젝트</Menu.Item>
                    <Menu.Item key="3" icon={<ToolFilled style={{ fontSize: '20px'}} />} style={{ width: '120px', textAlign: 'center'}}>관리</Menu.Item>
                </Menu>
            </Header>

            <Layout style={{margin: 0, padding: 0}}>
                <Sider collapsible collapsed={collapsed} onCollapse={onCollapse}>
                    <Menu
                        mode="inline"
                        defaultSelectedKeys={['1']}
                        defaultOpenKeys={['sub1']}
                        style={{ height: '100%', borderRight: 0 }}
                    >
                        <Menu.Item key="1" icon={<DesktopOutlined />}>
                            Option 1
                        </Menu.Item>
                        <Menu.Item key="2" icon={<DesktopOutlined />}>
                            Option 2
                        </Menu.Item>
                            <SubMenu key="sub1" icon={<UserOutlined />} title="User">
                                <Menu.Item key="3">Tom</Menu.Item>
                                <Menu.Item key="4">Bill</Menu.Item>
                                <Menu.Item key="5">Alex</Menu.Item>
                            </SubMenu>
                            <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
                                <Menu.Item key="6">Team 1</Menu.Item>
                                <Menu.Item key="8">Team 2</Menu.Item>
                            </SubMenu>
                        <Menu.Item key="9" icon={<FileOutlined />} />
                    </Menu>
                </Sider>

                <Layout style={{ padding: '0 24px 24px' }}>

                    <Content
                        className="site-layout-background"
                        style={{
                            padding: 0,
                            margin: '16px 0',
                            minHeight: 280,
                        }}
                    >

                        {children}

                    </Content>

                    <Footer style={{ textAlign: 'center', padding: 0 }}>Issue Sticker ©2020 Created by PSJ</Footer>
                </Layout>
            </Layout>
        </Layout>
    );
}

export default LayoutComponent;