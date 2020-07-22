import React from 'react';
import { Form, Input, Button, Select, Divider, Space, Spin, Empty } from 'antd';
import 'antd/dist/antd.css';


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


const ProjectDetailComponent = (props) => {

    const { onProjectCodeCheckAction,
            onProjectInUsersAction,
            onProjectUsersHandleChangeInit,
            projectUsersHandleChange,
            onProjectCreateAction,
            projectCodeOverlapCheck,
            projectDetailData,
            history } = props;
    const { Option } = Select
    const [form] = Form.useForm();


    form.setFieldsValue({
        code: projectDetailData.code,
        title: projectDetailData.title
    });

    const onFinish = values => {
        if(projectCodeOverlapCheck === "success") {
            onProjectCreateAction(values);
        }
    };


    return (
        
        <div style={{padding: 10}}>

            <Form
                {...layout}
                name="projectForm"
                form={form}
                onFinish={onFinish}
            >

                {projectCodeOverlapCheck === "" 
                ? 
                inputNoValidateStatusTag(onProjectCodeCheckAction, projectCodeOverlapCheck)
                :
                inputValidateStatusTag(onProjectCodeCheckAction, projectCodeOverlapCheck)}
                
                <Form.Item
                    label="프로젝트 제목"
                    name="title"
                >

                    <Input 
                        size="large"
                        type="text"
                        value={props.projectDetailData.title}
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
                        value={projectUsersHandleChange.value}
                        placeholder="프로젝트 참여 사용자를 선택하세요."
                        notFoundContent={projectUsersHandleChange.fetching == null ? null : projectUsersHandleChange.fetching ? <Spin size="small" /> : <Empty />}
                        size="large"
                        filterOption={false}
                        onSearch={onProjectInUsersAction}
                        onChange={onProjectUsersHandleChangeInit}
                        onFocus={() => null}
                        style={{ width: '100%' }}
                    >
                        {projectUsersHandleChange.data.map(userInfo => (
                            <Option key={userInfo.idx}>{userInfo.username}</Option>
                        ))}
                    </Select>
                </Form.Item>

                <Divider />

                <Form.Item {...tailLayout}>
                    <Space>
                        <Button type="primary" htmlType="submit">
                        생성
                        </Button>
                        <Button type="ghost" onClick={() => history.push("/projects")}>
                        취소
                        </Button>
                    </Space>
                </Form.Item>

            </Form>

        </div>
    );
}

export default ProjectDetailComponent