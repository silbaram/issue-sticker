import React from 'react';
import { Route } from "react-router-dom";
import { Login } from "../pages"


const RoleRouter = ({ component: Component, ...rest }) => {

    return (
        <Route
            {...rest}
            render={props => {
                if (false) {
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