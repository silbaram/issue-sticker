import axios from 'axios';


/**
 * 프로젝트 생성 요청
 * @param {*} data 
 */
export function projectAction(data) {
    return axios.post('/project', data, {
        headers: {
            'authorization': 'Bearer ',
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        }
    });
}