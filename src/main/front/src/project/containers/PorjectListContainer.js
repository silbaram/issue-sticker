import React, { useEffect, useContext, useState } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import PorjectListComponent from '../components/PorjectListComponent';
import * as service from '../actions';
import { store } from '../../common/reducers/store/store';


/**
 * 프로젝트 목록
 */
const PorjectListContainer = (props) => {
    const { history} = props;

    const globalStore = useContext(store);
    const [ projectList, setProjectList] = useState([]);

    useEffect(() => {
        service.userInProjects(globalStore.state.token)
        .then(response => {
            setProjectList(response.data);
        })
        .catch(error => {
            console.log("error", error);
        });
    }, [globalStore.state.token]);


    return (
        <LayoutContainer title="프로젝트 리스트" subTitle="프로젝트 관리" tabIndex={props.tabIndex}>
            <PorjectListComponent projectList={projectList} history={history} />
        </LayoutContainer>
    );
}

export default PorjectListContainer;