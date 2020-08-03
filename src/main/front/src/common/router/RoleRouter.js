import React, { useContext } from 'react';
import { Route } from "react-router-dom";
import { Login } from "../pages"
import { store } from '../../common/reducers/store/store';


const RoleRouter = ({ component: Component, ...rest }) => {

    const globalStore = useContext(store);

    return (
        <Route
            {...rest}
            render={props => {
                if (globalStore.state.isLogin === false) {
                    return <Login />;
                }
        
                if (Component) {
                    return <Component {...props} {...rest}/>;
                }
    
                return null;
            }}
        />
    );
};

export default RoleRouter;