import React from 'react';
import {Outlet} from "react-router-dom";
import Header from "./Header.jsx";
import Footer from "./Footer.jsx";

const Layout = () => {
    return (
        <>
            <Header/>
            <main className="App">
                <Outlet/>
            </main>
            <Footer/>
        </>
    );
};

export default Layout;
