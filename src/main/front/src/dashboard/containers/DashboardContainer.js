import React from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import DashboardComponent from '../components/DashboardComponent';


const DashboardContainer = ( { match }) => {
    return (
        <LayoutContainer>
            <DashboardComponent />
        </LayoutContainer>
    );
}

export default DashboardContainer;