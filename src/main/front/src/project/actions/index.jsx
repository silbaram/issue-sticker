import axios from 'axios';


/**
 * 프로젝트 생성 요청
 * @param {*} data 
 */
export function projectAction(data) {


    // axios.interceptors.request.use(
    //     config => {
    //         config.headers['Authorization'] = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwc2oiLCJpYXQiOjE1OTE0MjExMjAsImV4cCI6MTU5MTQ0OTkyMH0.i1FwUwar80Gy8CCDtSfugbZk9AMotKPdj96a0XHS2tvWgXPiUA_14wf7-shY-LJnzPgmj2AXF7i1sCrqCPIW7w';
    //         return config;
    //     },
    //     error => {
    //         Promise.reject(error)
    //     }
    // );
    // return axios.post('/project', data);

    const defaultOptions = {
        headers: {
            Authorization: `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwc2oiLCJpYXQiOjE1OTE2MjEyMTgsImV4cCI6MTU5MTY1MDAxOH0.tMN-Zgm_tW6Yj6tC5IsmVtJbumoVzPPppgDxPGNtjbSuIXsC-5tY1WYkFpvMnU7l23MkQma6UyIYpiw1QLeY1A`,
        },
    };

    return axios.post('/project', data, { ...defaultOptions });
}