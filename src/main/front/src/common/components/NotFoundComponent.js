import React from 'react';
import { Result, Button } from 'antd';
import 'antd/dist/antd.css';  // or 'antd/dist/antd.less'


const NotFoundComponent = () => {
    return (
        <Result
            status="404"
            title="404"
            subTitle="Sorry, the page you visited does not exist."
            extra={<Button type="primary">Back Home</Button>}
        />
    );
}

export default NotFoundComponent;