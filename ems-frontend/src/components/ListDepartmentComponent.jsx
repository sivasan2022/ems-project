import React, { useState } from 'react'
import { useEffect } from 'react';
import { deleteDepartmentById, getAllDepartments } from '../services/DepartmentService'
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

const ListDepartmentComponent = () => {

    useEffect( () => {
        listOfDepartments()
    },[]);

    function listOfDepartments() {
        getAllDepartments().then((response) => {
            console.log(response.data);
            setDepartments(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    const [departments, setDepartments] = useState([]);
    const navigator = useNavigate();

    const updateDepartment = (id) => navigator(`/edit-department/${id}`);

    function removeDepartment (id) {
        deleteDepartmentById(id).then((response) => {
            console.log("Department deleted successfully!");
            listOfDepartments()
        }).catch(error => console.error(error));
        
    }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Departments</h2>
        <Link className='btn btn-dark mb-2' to='/add-department'>Add Department</Link>
        <table className='table table-striped table-hover table-bordered'>
            <thead>
                <tr>
                    <th>Department Id</th>
                    <th>Department Name</th>
                    <th>Department Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    departments.map(department => 
                        <tr key={department.id}>
                            <td> {department.id}</td>
                            <td> {department.departmentName}</td>
                            <td> {department.departmentDescription}</td>
                            <td>
                                <button 
                                    onClick={() => updateDepartment(department.id)}
                                    className='btn btn-info m-2'>Update</button>
                                <button 
                                    onClick={() => removeDepartment(department.id)}
                                    className='btn btn-danger m-2'>Delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListDepartmentComponent