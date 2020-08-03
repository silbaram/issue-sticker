import React, { useContext } from 'react';
import { Result, Button } from 'antd';
import 'antd/dist/antd.css';
import { store } from '../../common/reducers/store/store';


const NotFoundComponent = ({ history }) => {

    const globalStore = useContext(store);

    return (
        <Result
            status="404"
            title="404"
            subTitle="Sorry, the page you visited does not exist."
            extra={<Button type="primary" onClick={() => globalStore.state.isLogin ? history.goBack() : history.push("/security/login")}>Back Home</Button>}
        />
    );
}

export default NotFoundComponent;