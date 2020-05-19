import axios from 'axios';


/**
 * 회원 가입 요청
 * @param {*} data 
 */
export function joinAction(data) {
    return axios.post('/security/join', data);
}


/**
 * 회원 가입시 ID 중복 체크
 * @param {*} data 
 * @return true:중복, false:사용가능
 */
export function idCheckAction(data) {
    return axios.get('/security/validation/'+data);
}


/**
 * 로그인 요청
 * @param {*} data 
 */
export function login(data) {
    console.log('data', data);
    return axios.post('/security/login', data);
}
