import React, { useEffect, useState } from 'react';
import axios from 'axios';
import InputBoxWithLabel from '../molecules/InputBoxWithLabel';
import './VendorComponent.css';

const VendorComponent = () => {
    const [vendors, setVendors] = useState({
        name: '',
        upi: '',
        email: ''
    });

    const [vendorsList, setVendorsList] = useState([]);
    const [selectedRows, setSelectedRows] = useState([]);

    const fieldsObject = [
        {
            label: "Name",
            value: "name"
        },
        {
            label: "UPI",
            value: "upi"
        },
        {
            label: "Email",
            value: "email"
        }
    ];

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!(vendors.email && vendors.name && vendors.upi)) {
            alert('Please enter all the fields before submitting');
            return;
        } else if (vendorsList.find(e => e.email === vendors.email)) {
            alert("Vendor with this email already exists. Please choose another email address");
            return;
        } else {
            axios.post('http://localhost:8080/vendor/create', vendors)
                .then(response => {
                    alert(response.data);
                    setVendors({
                        name: '',
                        upi: '',
                        email: ''
                    });
                    getAllVendorsData();
                })
                .catch(error => {
                    alert(error?.response?.data?.message);
                });
        }
    };

    const getAllVendorsData = () => {
        axios.get('http://localhost:8080/vendor/all', vendors)
            .then(response => {
                setVendorsList(response.data);
            })
            .catch(error => {
                alert(error?.response?.data?.message);
            });
    }

    const handleRowSelect = (vendor) => {
        const selectedIndex = selectedRows.findIndex(row => row.email === vendor.email);
        if (selectedIndex === -1) {
            setSelectedRows([...selectedRows, vendor]);
        } else {
            const updatedSelection = [...selectedRows];
            updatedSelection.splice(selectedIndex, 1);
            setSelectedRows(updatedSelection);
        }
    };

    const handleSendEmail = () => {
        if (selectedRows.length === 0) {
            alert("Please select at least one vendor to send email");
            return;
        } else {
            const vendorEmails = selectedRows.map(vendor => vendor.email);
            axios.post('http://localhost:8080/email/send', vendorEmails)
                .then(response => {
                    alert(response.data);
                })
                .catch(error => {
                    alert(error?.response?.data?.message);
                });
            setSelectedRows([]);
        }
    }

    const fetchDataByName = (value) => {
        if(!value) return;
        axios.get(`http://localhost:8080/vendor/getByname/${value}`,)
            .then(response => {
                setVendorsList(response.data);
            })
            .catch(error => {
                alert(error?.response?.data?.message);
            });
    }

    useEffect(() => {
        getAllVendorsData();
    }, []);

    return (
        <div className="vendor-component">
            <div className="form-section">
                <h2>Add Vendor</h2>
                {fieldsObject.map((item, index) =>
                    <InputBoxWithLabel
                        key={index}
                        label={item.label}
                        value={vendors[item.value]}
                        onChange={(e) => setVendors({ ...vendors, [item.value]: e.target.value })}
                    />
                )}
                <button type="submit" className='submit-btn' onClick={handleSubmit}>Add Vendor</button>
            </div>

            <div className="list-section">
                <h2>Vendors List</h2>
                <InputBoxWithLabel lable={"Enter value to get Employees"} onChange={(e) => { fetchDataByName(e.target.value) }} />
                <table>
                    <thead>
                        <tr>
                            <th>Select</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>UPI</th>
                        </tr>
                    </thead>
                    <tbody>
                        {vendorsList.map((vendor, index) => (
                            <tr key={index}>
                                <td>
                                    <input
                                        type="checkbox"
                                        checked={selectedRows.some(row => row.email === vendor.email)}
                                        onChange={() => handleRowSelect(vendor)}
                                    />
                                </td>
                                <td>{vendor.name}</td>
                                <td>{vendor.email}</td>
                                <td>{vendor.upi}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                <button type="submit" className='submit-btn' onClick={handleSendEmail}>Send Emails to Selected Vendors</button>
            </div>
        </div>
    );
};

export default VendorComponent;
