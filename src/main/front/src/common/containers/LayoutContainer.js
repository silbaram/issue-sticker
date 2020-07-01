import React from 'react';
import TopLayoutComponent from '../components/TopLayoutComponent';
// import TopSiderLayoutComponent from '../components/TopSiderLayoutComponent';
import { PageHeader, Divider } from 'antd';


const LayoutContainer = ({children, title, subTitle, tabIndex}) => {

    return (
        <TopLayoutComponent tabIndex={tabIndex}>

            <PageHeader 
                className="site-page-header"
                title={title}
                subTitle={subTitle}
            />

            <Divider />

            {children}

        </TopLayoutComponent>
    );
}

export default LayoutContainer;