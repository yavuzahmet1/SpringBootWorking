import React from "react";
import axios from "axios";

class UserSingupPage extends React.Component {
    state = {
        userName: null,
        displayName: null,
        password: null,
        passwordRepeat: null,
        pendingApiCall: false
    };

    onChange = event => {

        const { name, value } = event.target; //object destructure anlamına gelir kullnımı best prectisedir
        this.setState({
            [name]: value
        });

    };

    onClickSignup = event => {
        event.preventDefault();

        const { userName, displayName, password } = this.state;

        const body = {
            userName,
            displayName,
            password
        };
        this.setState({ pendingApiCall: true });

        //axios.post('http://localhost:8085/api/1.0/users', body);

        axios.post('/api/1.0/users', body).then(response => {
            this.setState({ pendingApiCall: false });

        });
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
            <div className="container">
                <form>
                    <h1 className="text-center">Sign Up</h1>
                    <div className="mb-3">
                        <label>UserName</label>
                        <input className="form-control" name="userName" onChange={this.onChange} />
                    </div>
                    <div className="mb-3">
                        <label>DisplayName</label>
                        <input className="form-control" name="displayName" onChange={this.onChange} />
                    </div>
                    <div className="mb-3">
                        <label>Password</label>
                        <input className="form-control" name="password" type={"password"} onChange={this.onChange} />
                    </div>
                    <div className="mb-3">
                        <label>Password Repeat</label>
                        <input className="form-control" name="passwordRepeat" type={"password"} onChange={this.onChange} />
                    </div >
                    <div className="text-center">
                        <button
                            className="btn btn-primary"
                            onClick={this.onClickSignup}
                            disabled={this.pendingApiCall}>Sing Up</button>
                    </div>

                </form>
            </div>

        );
    }

}

export default UserSingupPage;




////20. böüm 7. dk da kaldım