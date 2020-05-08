import axios from 'axios';

const joinAction = data => {
    console.log(data);
    axios.post('/security/join', { params: data })
    .then(function(response) {
        console.log(response);
    }).catch(function(error) {
        console.log(error);
    });
}

export default joinAction;