import React, { useState } from 'react';
import JoinComponent from '../components/JoinComponent';
import * as service from '../actions';


const JoinContainer = () => {

    const [joinSuccess, setJoinSuccess] = useState(false);

    function joinAction(data) {
        let result = service.joinAction(data);
        if(result) {
            setJoinSuccess(result);
        }
    }

    return (
        <JoinComponent
            onJoinAction={joinAction}
            isJoinSuccess={joinSuccess}
        />
    );
}

export default JoinContainer;