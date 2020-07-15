import React from 'react';
import { Table, Row, Col } from 'antd';
import styled from 'styled-components';


const PorjectListComponent = (props) => {

    const { projectList } = props;

    const StyledTable = styled(Table)`
        box-shadow: 1px 4px 4px #CCCCCC;
        border: 1px solid #CCCCCC;
    `;

    const columns = [
        {
            title: '코드',
            dataIndex: 'code'
        },
        {
            title: '프로젝트명',
            dataIndex: 'title'
        },
        {
            title: '상세설명',
            dataIndex: 'description'
        },
        {
            title: "생성일",
            dataIndex: 'registeredDate'
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