import React, { useContext } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import ProjectDetailComponent from '../components/ProjectDetailComponent';
import { Modal } from 'antd';
import * as service from '../actions';
import { store } from '../../common/reducers/store/store';


/**
 * 프로젝트 생성 요청
 * @param {*} data 
 */
const projectAction = data => {
    service.projectAction(data)
    .then(response => {
        Modal.success({
            content: '프로젝트 생성이 완료 되었습니다.',
        });
    })
    .catch(error => {
        Modal.error({
            title: "프로젝트 생성 실페",
            content: "계속 장애 발생시 운영자에게 연락 바랍니다."
        });
    });
}


const ProjectDetailContainer = (props) => {

    const globalState = useContext(store);
    console.log("ProjectDetailContainer > globalState", globalState);

    return (
        <LayoutContainer tabIndex={props.tabIndex}>
            <ProjectDetailComponent onProjectAction={projectAction} />
        </LayoutContainer>
    );
}

export default ProjectDetailContainer;