import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Login, Join, Dashboard, ProjectDetail, NotFount } from '../pages'



function IssueRouter() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/security/login" exact component={Login}></Route> {/* 로그인화면 */}
                <Route path="/security/join" component={Join}></Route> {/* 회원가입화면 */}
                <Route path="/dashboard/:userId" component={Dashboard}></Route>
                <Route path="/project" render={() => <ProjectDetail tabIndex="4" />}></Route> {/* 프로젝트 신규 */}
                <Route path="/project/:productCode" component={ProjectDetail}></Route> {/* 프로젝트 변경 */}
                <Route component={NotFount} />
            </Switch>
        </BrowserRouter>
    );
}

export default IssueRouter;