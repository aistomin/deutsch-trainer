import React from 'react';

const Footer = () => {
    return (
        <footer className="Footer">
            <p>
                &copy; {(new Date()).getFullYear()} Andrej Istomin
            </p>
        </footer>
    );
};

export default Footer;
