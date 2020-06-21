import React from 'react';
import { Form, Input, Button, Select, Divider, PageHeader, Space, Spin } from 'antd';
import 'antd/dist/antd.css';


const inputNoValidateStatusTag = (onProjectCodeCheckAction, projectCodeOverlapCheck) => (
    <Form.Item
        label="프로젝트 코드"
        name="code"
        rules={[
            {
                required: true,
                message: projectCodeOverlapCheck === 'error' ? '중복된 아이디가 존재 합니다.' : '필수 정보입니다.'
            }
        ]}

        hasFeedback
    >

        <Input 
            size="large"
            onBlur={ () => onProjectCodeCheckAction(document.getElementById("projectForm_code").value)}
        />
    </Form.Item>
);

const inputValidateStatusTag = (onProjectCodeCheckAction, projectCodeOverlapCheck) => (
    <Form.Item
        label="프로젝트 코드"
        name="code"
            rules={[
                {
                    required: true,
                    message: '필수 정보입니다.'
                }
            ]}
            
            validateStatus={projectCodeOverlapCheck}
            help={projectCodeOverlapCheck === "success" ? "사용 가능한 코드 입니다." : "중복된 코드가 존재 합니다."}
            hasFeedback
        >

        <Input 
            size="large"
            onBlur={ () => onProjectCodeCheckAction(document.getElementById("projectForm_code").value)}
        />
    </Form.Item>
);


const ProjectDetailComponent = (props, { history }) => {

    const { onProjectCodeCheckAction,
            onProjectInUsersAction,
            projectUsersHandleChange,
            onProjectCreateAction,
            projectCodeOverlapCheck } = props;
    const { Option } = Select

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
        if(projectCodeOverlapCheck === "success") {
            onProjectCreateAction(values);
        }
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
                name="projectForm"
                onFinish={onFinish}
            >

                {projectCodeOverlapCheck === "" ? inputNoValidateStatusTag(onProjectCodeCheckAction, projectCodeOverlapCheck) : inputValidateStatusTag(onProjectCodeCheckAction, projectCodeOverlapCheck)}
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
                    <Select 
                        mode="multiple"
                        labelInValue
                        notFoundContent={projectUsersHandleChange.fetching ? <Spin size="small" /> : null}
                        size="large"
                        onSearch={onProjectInUsersAction}
                    >
                        {/* <OptGroup label="Manager">
                            {children}
                        </OptGroup>
                        <OptGroup label="Engineer">
                            <Option value="Yiminghe">yiminghe</Option>
                        </OptGroup> */}
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