import React from 'react';
import { Table, Row, Col } from 'antd';
import styled from 'styled-components';


const PorjectListComponent = () => {

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
            dataIndex: 'registered'
        }
    ];

    const data = [];
    for (let i = 0; i < 100; i++) {
        data.push({
            key: i,
            code: `CON_${i}`,
            title: `프로젝트 ${i}`,
            description: '프로젝트 상세 설명',
            registered: '2020-08-20',
        });
    }


    return (
        <div>
            <Row>
                <Col flex="20px" />
                <Col flex="auto">
                    <StyledTable 
                        columns={columns}
                        dataSource={data}
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