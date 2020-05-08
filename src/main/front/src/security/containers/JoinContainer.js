import React from 'react';
import JoinComponent from '../components/JoinComponent';
import joinAction from '../actions/'


const JoinContainer = () => {
    
    return (
        <JoinComponent onJoinAction={joinAction} />
    );
}

export default JoinContainer;