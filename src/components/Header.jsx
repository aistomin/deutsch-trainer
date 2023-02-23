import React from 'react';
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <header className="Header">
            <h1>Deutschtrainer</h1>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="test">Test</Link></li>
                    <li><Link to="vocabulary">Vocabulary</Link></li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;
