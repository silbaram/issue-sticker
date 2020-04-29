import React from 'react';
import { Route } from "react-router-dom";
import JoinContainer from '../containers/JoinContainer';


const Join = () => {
    return (
        <Route path="/join" component={JoinContainer} />
    );
}

export default Join;