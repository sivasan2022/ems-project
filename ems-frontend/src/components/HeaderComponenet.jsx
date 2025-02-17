import React from 'react'
import { NavLink } from 'react-router-dom'

const HeaderComponent = () => {
  return (
    <div>
        <header>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand ps-2" href="#">Employee Management System</a>

          {/* Collapsible Navbar */}
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink className="nav-link" to="/employees">Employees</NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/departments">Departments</NavLink>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    </div>
  )
}

export default HeaderComponent