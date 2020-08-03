import React from 'react';
import { Table, Row, Col } from 'antd';
import styled from 'styled-components';


const StyledTable = styled(Table)`
    box-shadow: 1px 4px 4px #CCCCCC;
    border: 1px solid #CCCCCC;
`;


const PorjectListComponent = (props) => {

    const { projectList, history } = props;

    const columns = [
        {
            title: '코드',
            dataIndex: 'code',
            width: '10%',
            render: text => <a href="#;" onClick={() => history.push("/project/" + {text}.text)}>{text}</a>
        },
        {
            title: '프로젝트명',
            dataIndex: 'title',
            width: '20%',
        },
        {
            title: '상세설명',
            dataIndex: 'description',
            width: '40%',
        },
        {
            title: "생성일",
            dataIndex: 'registeredDate',
            width: '20%',
        }
    ];


    return (
        <div>
            <Row>
                <Col flex="20px" />
                <Col flex="auto">
                    <StyledTable 
                        columns={columns}
                        dataSource={projectList}
                        bordered
                        title={() => '프로젝트 목록'}
                        size="small"
                    />
                </Col>
                <Col flex="20px" />
            </Row>
        </div>
    );
}

export default  PorjectListComponent;