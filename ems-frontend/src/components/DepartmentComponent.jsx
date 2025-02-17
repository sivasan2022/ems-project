import React, { useState } from 'react'
import { createDepartment } from '../services/DepartmentService';
import { useNavigate } from 'react-router-dom';

const DepartmentComponent = () => {


  const [departmentName, setDepartmentName] = useState('');
  const [departmentDescription, setDepartmentDescription] = useState('');

  const navigator = useNavigate();

  function saveDepartment(e) {
    e.preventDefault();
    const department = {departmentName, departmentDescription};
    console.log(department);
    createDepartment(department).then((response) => {
      console.log(response.data);
    }).catch(error => console.error(error));
    navigator('/departments');
  }

  return (
    <div className='conatainer'>
      <br/><br/>
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          <h2 className='text-center'>Add Department</h2>
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'>Department Name: </label>
                <input type="text" name='departmentName' 
                  placeholder='Enter Department Name'
                  value={departmentName}
                  onChange={(e) => setDepartmentName(e.target.value)}
                  className='form-control'/>
              </div>
              <div className='form-group mb-2'>
                <label className='form-label'>Department Description: </label>
                <input type="text" name='departmentDescription' 
                  placeholder='Enter Department Description'
                  value={departmentDescription}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                  className='form-control'/>
              </div>
              <div className='d-flex justify-content-center'>
                <button className='btn btn-success ' onClick={(e) => saveDepartment(e)}>Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default DepartmentComponent