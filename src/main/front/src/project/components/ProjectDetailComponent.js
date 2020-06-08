import React from 'react';
import { Form, Input, Button, Select, Divider, PageHeader, Space } from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


const ProjectDetailComponent = (props, { history }) => {

    const { onProjectAction } = props;
    const { Option, OptGroup } = Select

    const layout = {
        labelCol: {
            span: 6,
        },
        wrapperCol: {
            span: 14,
        },
    };

    const tailLayout = {
        wrapperCol: {
            offset: 17
        },
    };

    //TODO 나중에 API류 목록을 가져오는 방식으로 변경해야됨
    const children = [];
    for (let i = 10; i < 36; i++) {
        children.push(<Option key={i.toString(36) + i}>{i.toString(36) + i}</Option>);
    }

    const onFinish = values => {
        onProjectAction(values);
    };


    return (
        
        <div style={{padding: 10}}>
            <PageHeader 
                className="site-page-header"
                title="프로젝트 생성"
                subTitle="프로젝트 / 팀원 관리"
            />

            <Divider />

            <Form
                {...layout}
                onFinish={onFinish}
            >
                <Form.Item
                    label="프로젝트 코드"
                    name="key"
                    rules={[
                        {
                            required: true,
                            message: '필수 정보입니다.'
                        }
                    ]}

                    hasFeedback
                >

                    <Input 
                        size="large"
                    />
                </Form.Item>

                <Form.Item
                    label="프로젝트 제목"
                    name="title"
                >

                    <Input 
                        size="large"
                    />
                </Form.Item>

                <Form.Item
                    label="프로젝트 설명"
                    name="description"
                >

                    <Input.TextArea
                        size="large"
                    />
                </Form.Item>


                <Form.Item
                    label="프로젝트 팀원"
                    name="users"
                >
                    <Select mode="multiple" size="large">
                        <OptGroup label="Manager">
                            {children}
                        </OptGroup>
                        <OptGroup label="Engineer">
                            <Option value="Yiminghe">yiminghe</Option>
                        </OptGroup>
                    </Select>
                </Form.Item>

                <Divider />

                <Form.Item {...tailLayout}>
                    <Space>
                        <Button type="primary" htmlType="submit">
                        생성
                        </Button>
                        <Button type="ghost">
                        취소
                        </Button>
                    </Space>
                </Form.Item>

            </Form>

        </div>
    );
}

export default ProjectDetailComponent