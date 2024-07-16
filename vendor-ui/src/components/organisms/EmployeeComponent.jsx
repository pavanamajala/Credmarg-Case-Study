import React, { useState, useEffect } from 'react';
import axios from 'axios';
import InputBoxWithLabel from '../molecules/InputBoxWithLabel';
import './EmployeeComponent.css';

const EmployeeComponent = () => {
    const [employee, setEmployee] = useState({
        name: '',
        designation: '',
        ctc: '',
        email: ''
    });

    const [employeeList, setEmloyeeList] = useState([]);

    const fieldsObject = [
        {
            label: "Name",
            value: "name"
        },
        {
            label: "Designation",
            value: "designation"
        },
        {
            label: "CTC",
            value: "ctc"
        },
        {
            label: "Email",
            value: "email"
        }
    ];

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!(employee.email && employee.name && employee.designation && employee.ctc)) {
            alert('Please enter all the fields before submitting');
            return;
        } else if (employeeList.find(e => e.email === employee.email)) {
            alert("Employee with this email already exists. Please choose another email address");
            return;
        } else {
            axios.post('http://localhost:8080/employee/create', employee)
                .then(response => {
                    alert(response.data);
                    setEmployee({
                        name: '',
                        designation: '',
                        ctc: '',
                        email: ''
                    });
                    getAllEmployeeData();
                })
                .catch(error => {
                    console.error('Error adding employee:', error);
                });
        }
    };

    const getAllEmployeeData = () => {
        axios.get('http://localhost:8080/employee/all', employee)
            .then(response => {
                setEmloyeeList(response.data);
            })
            .catch(error => {
                console.error('Error adding employee:', error);
            });
    }

    const fetchDataByName = (value) => {
        if(!value) return;
        axios.get(`http://localhost:8080/employee/getByName/${value}`,)
            .then(response => {
                setEmloyeeList(response.data);
            })
            .catch(error => {
                console.error('Error adding employee:', error);
            });
    }

    useEffect(() => {
        getAllEmployeeData();
    }, []);

    return (
        <div className="employee-component">
            <div className="form-section">
                <h2>Add Employee</h2>
                {fieldsObject.map((item, index) =>
                    <InputBoxWithLabel
                        key={index}
                        label={item.label}
                        value={employee[item.value]}
                        onChange={(e) => setEmployee({ ...employee, [item.value]: e.target.value })}
                    />
                )}
                <button type="submit" className='submit-btn' onClick={handleSubmit}>Add Employee</button>
            </div>

            <div className="list-section">
                <h2>Employees List</h2>
                <InputBoxWithLabel lable={"Enter value to get Employees"} onChange={(e) => {fetchDataByName(e.target.value)}}/>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Designation</th>
                            <th>CTC</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employeeList.map((employee, index) => (
                            <tr key={index}>
                                <td>{employee.name}</td>
                                <td>{employee.designation}</td>
                                <td>{employee.ctc}</td>
                                <td>{employee.email}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default EmployeeComponent;
