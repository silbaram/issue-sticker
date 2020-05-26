import React from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import DashboardComponent from '../components/DashboardComponent';


const DashboardContainer = ({match}) => {
console.log("match.params.userId", match.params.userId);
    return (
        <LayoutContainer>
            <DashboardComponent />
        </LayoutContainer>
    );
}

export default DashboardContainer;