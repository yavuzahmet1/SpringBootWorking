import React from "react";

class UserSingupPage extends React.Component {
    state = {
        username: null,
        displayname:null


    };

    onChangeUserName = event => {
        this.setState({
            username: event.target.value
        })
    };
    onChangeDisplayName = event => {
        this.setState({
            displayname: event.target.value
        })
    };


    render() {
        return (
            <form>
                <h1>Sign Up</h1>
                <div>
                    <label>UserName</label>
                    <input onChange={this.onChangeUserName} />
                </div>
                <div>
                    <label>DisplayName</label>
                    <input onChange={this.onChangeDisplayName} />
                </div>
                <div>
                    <label>Password</label>
                    <input type={"password"} />
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input type="password" />
                </div>
                <button>Sing Up</button>
            </form>
        );
    }

}

export default UserSingupPage;

//10. bölüm 13.10. saniyede kaldım