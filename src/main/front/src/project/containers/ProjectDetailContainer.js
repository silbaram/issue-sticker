import React, { useState, useContext, useEffect } from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import ProjectDetailComponent from '../components/ProjectDetailComponent';
import { Modal, } from 'antd';
import { LoadingOutlined } from '@ant-design/icons';
import * as service from '../actions';
import debounce from 'lodash/debounce';
import { store } from '../../common/reducers/store/store';


/**
 * 프로젝트 상세
 * @param {*} props 
 */
const ProjectDetailContainer = (props) => {

    const { match, history } = props;
    const { productCode } = match.params;

    let handleChange = {
        value: [],
        data: [],
        fetching: null,
    };

    // 스토어 획득
    const globalStore = useContext(store);
    const [projectCodeOverlapCheck, setProjectCodeOverlapCheck] = useState(""); //회원 중복 체크 여부 상태값 : '', 'error', 'validating'
    const [projectUsersHandleChange, setProjectUsersHandleChange] = useState(handleChange);
    const [projectDetailData, setProjectDetailData] = useState("");


    useEffect(() => {
        if (productCode !== "" && productCode !== undefined) {
            service.projectDetailAction(productCode, globalStore.state.token)
            .then(response => {
                setProjectDetailData(response.data);
            })
            .catch(error => {
                console.log("error", error);
            });
        }
        
    }, [productCode, globalStore.state.token]);


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
        });
    }


    /**
     * 프로젝트에 권한 부여할 사용자 검색
     * @param {*} value 
     */
    const projectInUsersAction = value => {
        if (value === "") {
            return false;
        }

        setProjectUsersHandleChange({
            data: [],
            fetching: true
        });

        service.projectInUsersAction(value, globalStore.state.token)
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
            fetching: null,
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
        <LayoutContainer title="프로젝트 생성" subTitle="프로젝트 / 팀원 관리" tabIndex={props.tabIndex}>

            {productCode !== "" && productCode !== undefined && projectDetailData === "" ?
            <LoadingOutlined spin />
            :
            <ProjectDetailComponent 
                onProjectCodeCheckAction={projectCodeCheckAction}
                onProjectInUsersAction={debounce(projectInUsersAction, 300)}
                onProjectUsersHandleChangeInit={setProjectUsersHandleChangeInit}
                projectUsersHandleChange={projectUsersHandleChange}
                onProjectCreateAction={projectCreateAction}
                projectCodeOverlapCheck={projectCodeOverlapCheck}
                globalStore={globalStore}
                projectDetailData={projectDetailData}
                history={history}
            />
            }
        </LayoutContainer>
    );
}

export default ProjectDetailContainer;