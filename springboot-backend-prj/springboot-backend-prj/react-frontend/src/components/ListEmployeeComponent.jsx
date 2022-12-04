import React, { Component } from 'react';

class ListEmployeeComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            employees:[]
        }
    }
    render() {
        return (
            <div>
                <h2 class='text-center'>Employees List</h2>
                <div className='row'>
                    <table className='table table-striped table-bordered'>
                        <thread>
                            <tr>
                                <th>Employee First Name</th>
                                <th>Employee Last Name</th>
                                <th>Employee E-mail id</th>
                                <th>Actions</th>
                            </tr>
                        </thread>
                        <tbody>
                            {

                                this.state.employees.map(
                                    employee =>
                                    <tr key={employee.id}>
                                        <td>{employee.name}</td>
                                        <td>{employee.lastname}</td>
                                        <td>{employee.emailId}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

            </div>
        );
    }
}

export default ListEmployeeComponent;