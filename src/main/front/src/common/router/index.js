import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Login, Join, NotFount } from '../../pages'



function IssueRouter() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login}></Route>
                <Route path="/join" component={Join}></Route>
                <Route component={NotFount} />
            </Switch>
        </BrowserRouter>
    );
}

export default IssueRouter;