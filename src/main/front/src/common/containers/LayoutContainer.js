import React from 'react';
import TopLayoutComponent from '../components/TopLayoutComponent';
import TopSiderLayoutComponent from '../components/TopSiderLayoutComponent';


const LayoutContainer = ({children, tabIndex}) => {

    return (
        <TopLayoutComponent tabIndex={tabIndex}>
            {children}
        </TopLayoutComponent>
    );
}

export default LayoutContainer;