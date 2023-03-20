import React, { Component } from 'react';
import Input from '../components/input'

class LoginPage extends Component {
    state={
        userName:null,
        password:null

    }

    onChange=event=>{
        const{name,value}=event.target;
        this.setState({
            [name]:value
        })
    }
    render() {
        return (
            <div className='container'>
                <form>
                    <h1 className='text-center'>Login</h1>
                    <Input label='User Name' name='userName' onChange={this.onChange} />
                    <Input label='Password' name='password' type='password' onChange={this.onChange} />
                    <div className='text-center'>
                        <button className='btn btn-primary'>Login</button>
                    </div>


                </form>

            </div>
        );
    }
}

export default LoginPage;