import React, { useEffect, useContext } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import PorjectListComponent from '../components/PorjectListComponent';
import * as service from '../actions';
import { store } from '../../common/reducers/store/store';


/**
 * 프로젝트 목록
 */
const PorjectListContainer = (props) => {

    const globalStore = useContext(store);


    useEffect(() => {
        service.userInProjects(globalStore.state.token)
        .then(response => {
            console.log(response);
        })
        .catch(error => {
            console.log("error", error);
        });
    });


    return (
        <LayoutContainer title="프로젝트 리스트" subTitle="프로젝트 관리" tabIndex={props.tabIndex}>
            <PorjectListComponent />
        </LayoutContainer>
    );
}

export default PorjectListContainer;