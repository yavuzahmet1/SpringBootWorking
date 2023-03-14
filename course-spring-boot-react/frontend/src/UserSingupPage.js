import React from "react";
import axios from "axios";

class UserSingupPage extends React.Component {
    state = {
        userName: null,
        displayName: null,
        password: null,
        passwordRepeat: null
    };

    onChange = event => {

        const { name, value } = event.target; //object destructure anlamına gelir kullnımı best prectisedir
        this.setState({
            [name]: value
        });

    };

    onClickSignup = event => {
        event.preventDefault();

        const{userName,displayName,password}=this.state;

        const body = {
            userName,
            displayName,
            password
        };

        //axios.post('http://localhost:8085/api/1.0/users', body);
        axios.post('/api/1.0/users', body);
    };

    /*
        onChangeUserName = event => {
            this.setState({
                username: event.target.value
            });
        };
    
        onChangeDisplayName = event => {
            this.setState({
                displayname: event.target.value
            });
        };
    
        onChangePassword = event => {
            this.setState({
                password: event.target.value
            });
        };
    
        onChangePasswordRepeat = event => {
            this.setState({
                passwordRepeat: event.target.value
            });
        };
    */

    render() {
        return (
            <form>
                <h1>Sign Up</h1>
                <div>
                    <label>UserName</label>
                    <input name="userName" onChange={this.onChange} />
                </div>
                <div>
                    <label>DisplayName</label>
                    <input name="displayName" onChange={this.onChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type={"password"} onChange={this.onChange} />
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input name="passwordRepeat" type={"password"} onChange={this.onChange} />
                </div>
                <button onClick={ this.onClickSignup}>Sing Up</button>
            </form>
        );
    }

}

export default UserSingupPage;
