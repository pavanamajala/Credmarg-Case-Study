import React from "react";
import VendorComponent from "../organisms/VendorComponent";
import EmployeeComponent from "../organisms/EmployeeComponent";
import './MainPage.css';

const MainPage = () => {
    return (
        <div className="main-page">
            <header className="main-header">
                <h1>Vendor and Employee Management</h1>
            </header>
            <div className="components-container">
                <VendorComponent />
                <EmployeeComponent />
            </div>
        </div>
    );
}

export default MainPage;
