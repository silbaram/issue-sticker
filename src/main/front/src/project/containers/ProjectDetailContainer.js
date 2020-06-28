import React, { useState, useContext } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import ProjectDetailComponent from '../components/ProjectDetailComponent';
import { Modal } from 'antd';
import * as service from '../actions';
import debounce from 'lodash/debounce';
import { store } from '../../common/reducers/store/store';



const ProjectDetailContainer = (props) => {

    let handleChange = {
        value: [],
        data: [],
        fetching: false,
    };

    // 스토어 획득
    const globalStore = useContext(store);
    const [projectCodeOverlapCheck, setProjectCodeOverlapCheck] = useState(""); //회원 중복 체크 여부 상태값 : '', 'error', 'validating'
    const [projectUsersHandleChange, setProjectUsersHandleChange] = useState(handleChange);

    /**
     *  프로젝트 생성시 프로젝트 코드 중복 체크
     * @param {*} data 
     */
    const projectCodeCheckAction = (data) => {
        if (data === "") {
            setProjectCodeOverlapCheck("");
            return false;
        }
        
        service.projectCodeCheckAction(data, globalStore.state.token)
        .then(response => {
            setProjectCodeOverlapCheck(response.data);
        })
        .catch(error => {
            console.log("error", error);
        });;
    }


    /**
     * 프로젝트에 권한 부여할 사용자 검색
     * @param {*} value 
     */
    const projectInUsersAction = value => {
        setProjectUsersHandleChange({
            data: [],
            fetching: true
        });

        service.projectInUsersAction(globalStore.state.token, value)
        .then(response => {
            if (response.data.length > 0) {
                setProjectUsersHandleChange({
                    data: response.data,
                    fetching: false
                });
            } else {
                setProjectUsersHandleChange({
                    data: [],
                    fetching: false
                });
            }
        })
        .catch(error => {
            console.log("error", error);
        });
    }


    const setProjectUsersHandleChangeInit = (value) => {
        setProjectUsersHandleChange({
            value: value,
            data: [],
            fetching: false,
        });
    }


    /**
     * 프로젝트 생성 요청
     * @param {*} data 
     */
    const projectCreateAction = data => {

        service.projectCreateAction(data, globalStore.state.token)
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


    return (
        <LayoutContainer tabIndex={props.tabIndex}>
            <ProjectDetailComponent 
                onProjectCodeCheckAction={projectCodeCheckAction}
                onProjectInUsersAction={debounce(projectInUsersAction, 300)}
                onProjectUsersHandleChangeInit={setProjectUsersHandleChangeInit}
                projectUsersHandleChange={projectUsersHandleChange}
                onProjectCreateAction={projectCreateAction}
                projectCodeOverlapCheck={projectCodeOverlapCheck}
                globalStore={globalStore}
            />
        </LayoutContainer>
    );
}

export default ProjectDetailContainer;