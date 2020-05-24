import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Login, Join, Dashboard, NotFount } from '../pages'



function IssueRouter() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/security/login" exact component={Login}></Route> {/* 로그인화면 */}
                <Route path="/security/join" component={Join}></Route> {/* 회원가입화면 */}
                <Route path="/dashboard/personal" component={Dashboard}></Route>
                <Route component={NotFount} />
            </Switch>
        </BrowserRouter>
    );
}

export default IssueRouter;