import axios from 'axios';


/**
 * 프로젝트 생성시 프로젝트 코드 중복 체크
 * @param {*} data 
 * @return true:중복, false:사용가능
 */
export function projectCodeCheckAction(data, userToken) {

    const defaultOptions = {
        headers: {
            Authorization: `Bearer ` + userToken,
        },
    };

    return axios.get('/project/validation/' + data, { ...defaultOptions });
}


/**
 * 프로젝트 접근 권한 관리를 위한 사용자 검색
 * @param {*} data 
 */
export function projectInUsersAction(userToken, value) {

    const defaultOptions = {
        headers: {
            Authorization: `Bearer ` + userToken,
        },
    };
console.log(value);
    return axios.get('/project/users?value=' + value, { ...defaultOptions });
}


/**
 * 프로젝트 생성 요청
 * @param {*} data 
 */
export function projectCreateAction(data, userToken) {

    const defaultOptions = {
        headers: {
            Authorization: `Bearer ` + userToken,
        },
    };

    return axios.post('/project', data, { ...defaultOptions });
}