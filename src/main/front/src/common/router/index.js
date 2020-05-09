import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Login, Join, JoinSuccess, NotFount } from '../pages'



function IssueRouter() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login}></Route> {/* 로그인화면 */}
                <Route path="/join" component={Join}></Route> {/* 회원가입화면 */}
                <Route path="/join-success" component={JoinSuccess}></Route> {/* 회원가입 성공화면 */}
                <Route component={NotFount} />
            </Switch>
        </BrowserRouter>
    );
}

export default IssueRouter;