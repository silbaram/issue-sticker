import React, { useState } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import ProjectDetailComponent from '../components/ProjectDetailComponent';
import { Modal } from 'antd';
import * as service from '../actions';


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

    const [projectCodeOverlapCheck, setProjectCodeOverlapCheck] = useState(""); //회원 중복 체크 여부 상태값 : '', 'error', 'validating'


    /**
     *  프로젝트 생성시 프로젝트 코드 중복 체크
     * @param {*} data 
     */
    const projectCodeCheckAction = (data, userToken) => {
        if (data === "") {
            setProjectCodeOverlapCheck("");
            return false;
        }
        
        service.projectCodeCheckAction(data, userToken)
        .then(response => {
            setProjectCodeOverlapCheck(response.data);
        });
    }


    return (
        <LayoutContainer tabIndex={props.tabIndex}>
            <ProjectDetailComponent 
            onProjectAction={projectAction}
            onProjectCodeCheckAction={projectCodeCheckAction}
            projectCodeOverlapCheck={projectCodeOverlapCheck} />
        </LayoutContainer>
    );
}

export default ProjectDetailContainer;