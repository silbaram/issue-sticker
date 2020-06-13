import axios from 'axios';


/**
 * 프로젝트 생성시 프로젝트 코드 중복 체크
 * @param {*} data 
 * @return true:중복, false:사용가능
 */
export function projectCodeCheckAction(data, userToken) {
console.log("data", data);
console.log("token", userToken);
    const defaultOptions = {
        headers: {
            Authorization: `Bearer ` + userToken,
        },
    };

    return axios.get('/project/validation/' + data, { ...defaultOptions });
}


/**
 * 프로젝트 생성 요청
 * @param {*} data 
 */
export function projectAction(data) {

    const defaultOptions = {
        headers: {
            Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwc2oiLCJpYXQiOjE1OTE2MjEyMTgsImV4cCI6MTU5MTY1MDAxOH0.tMN-Zgm_tW6Yj6tC5IsmVtJbumoVzPPppgDxPGNtjbSuIXsC-5tY1WYkFpvMnU7l23MkQma6UyIYpiw1QLeY1A`,
        },
    };

    return axios.post('/project', data, { ...defaultOptions });
}