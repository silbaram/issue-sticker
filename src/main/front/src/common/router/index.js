import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import RoleRoute from "./RoleRouter";
import { Login, Join, Dashboard, ProjectDetail, PorjectList, NotFount } from '../pages'



function IssueRouter() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/security/login" exact component={Login}></Route> {/* 로그인화면 */}
                <RoleRoute path="/security/join" component={Join}></RoleRoute> {/* 회원가입화면 */}
                <RoleRoute path="/dashboard/:userId" component={Dashboard}></RoleRoute>
                <RoleRoute path="/projects" component={PorjectList}></RoleRoute> {/* 프로젝트 리스트 */}
                <RoleRoute tabIndex="4" path="/project/create" component={ProjectDetail}></RoleRoute> {/* 프로젝트 신규 */}
                <RoleRoute path="/project/:productCode" component={ProjectDetail}></RoleRoute> {/* 프로젝트 변경 */}
                <Route component={NotFount} />
            </Switch>
        </BrowserRouter>
    );
}

export default IssueRouter;