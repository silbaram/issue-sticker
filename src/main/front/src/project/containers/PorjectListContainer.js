import React from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import PorjectListComponent from '../components/PorjectListComponent';


/**
 * 프로젝트 목록
 */
const PorjectListContainer = (props) => {

    return (
        <LayoutContainer title="프로젝트 리스트" subTitle="프로젝트 관리" tabIndex={props.tabIndex}>
            <PorjectListComponent />
        </LayoutContainer>
    );
}

export default PorjectListContainer;