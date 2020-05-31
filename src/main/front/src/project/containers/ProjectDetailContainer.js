import React from 'react';
import LayoutContainer from '../../common/containers/LayoutContainer';
import ProjectDetailComponent from '../components/ProjectDetailComponent';


const ProjectDetailContainer = ({tabIndex}) => {

    return (
        <LayoutContainer tabIndex={tabIndex}>
            <ProjectDetailComponent />
        </LayoutContainer>
    );
}

export default ProjectDetailContainer;