import React from "react";

class UserSingupPage extends React.Component {
    state = {
        username: null,
        displayname: null,
        password: null,
        passwordRepeat: null
    };

    onChange=event=>{

        const{name,value}=event.target; //object destructure anlamına gelir kullnımı best prectisedir
        this.setState({
            [name]:value
        });

        /*const value=event.target.value;
        const field=event.target.name;
        this.setState({
            [field]:value
        });*/
    }
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
                    <input name="username" onChange={this.onChange} />
                </div>
                <div>
                    <label>DisplayName</label>
                    <input name="displayname" onChange={this.onChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type={"password"} onChange={this.onChange} />
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input name="passwordRepeat" type={"password"} onChange={this.onChange} />
                </div>
                <button>Sing Up</button>
            </form>
        );
    }

}

export default UserSingupPage;

//10. bölüm 13.10. saniyede kaldım