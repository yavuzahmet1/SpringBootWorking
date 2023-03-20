import { type } from "@testing-library/user-event/dist/type";
import React from "react";
//import axios from "axios";//buna gerek kalmadı importumuz artık api clasörü içinden
import { signUp } from '../api/apiCalls';
import Input from "../components/input";

class UserSingupPage extends React.Component {
    state = {
        userName: null,
        displayName: null,
        password: null,
        passwordRepeat: null,
        pendingApiCall: false,
        errors: {}
    };

    onChange = event => {

        const { name, value } = event.target; //object destructure anlamına gelir kullnımı best prectisedir
        const errors = { ...this.state.errors }
        errors[name] = undefined;
        if (name === 'password' || name === 'passportRepeat') {
            if (name === 'password' && value !== this.state.passwordRepeat) {
                errors.passwordRepeat = 'passwort mismatch';
            } else if (name === 'passwordRepeat' && value !== this.state.password) {
                errors.passwordRepeat = 'passwort mismatch';
            } else {
                errors.passwordRepeat = undefined;
            }
        }
        this.setState({
            [name]: value,
            errors
        });

    };

    onClickSignup = async event => {//asenkron yapısı olduğunu belişrmemiz gerekiyor bu yüzen başına async koyduk
        event.preventDefault();

        const { userName, displayName, password } = this.state;

        const body = {
            userName,
            displayName,
            password
        };

        this.setState({ pendingApiCall: true });

        try {

            const response = await signUp(body);

        } catch (error) {
            if (error.response.data.validationsErrors) {
                this.setState({ errors: error.response.data.validationsErrors });
            }

        }

        this.setState({ pendingApiCall: false });

    };

    render() {
        const { pendingApiCall, errors } = this.state;
        const { userName, displayName, password, passwordRepeat } = errors;
        return (

            <div className="container">
                <form>
                    <h1 className="text-center">Sign Up</h1>
                    <Input name="userName" label="User Name" error={userName} onChange={this.onChange} />
                    <Input name="displayName" label="Display Name" error={displayName} onChange={this.onChange} />
                    <Input name="password" label="Password" error={password} onChange={this.onChange} type="password" />
                    <Input name="passwordRepeat" label="Password Repeat" error={passwordRepeat} onChange={this.onChange} type="password" />

                    {/*<div className="mb-3">
                        <label>User Name</label>
                        <input className={userName ? 'form-control is-invalid' : 'form-control'} name="userName" onChange={this.onChange} />
                        <div className="invalid-feedback">{userName}</div>
                    </div>
                    <div className="mb-3">
                        <label>Display Name</label>
                        <input className={displayName ? "form-control is-invalid" : 'form-control'} name="displayName" onChange={this.onChange} />
                        <div className="invalid-feedback">{displayName}</div>
        </div>
                    <div className="mb-3">
                        <label>Password</label>
                        <input className="form-control" name="password" type={"password"} onChange={this.onChange} />
                    </div>
                    <div className="mb-3">
                        <label>Password Repeat</label>
                        <input className="form-control" name="passwordRepeat" type={"password"} onChange={this.onChange} />
                    </div >*/}
                    <div className="text-center">
                        <button
                            className="btn btn-primary"
                            onClick={this.onClickSignup}
                            disabled={pendingApiCall || passwordRepeat !== undefined}>
                            {pendingApiCall && <span class="spinner-border spinner-border-sm"></span>}
                            Sing Up
                        </button>
                    </div>

                </form>
            </div>

        );
    }

} export default UserSingupPage;

/**/

//axios.post('http://localhost:8085/api/1.0/users', body);

//conditional rendering nedir araştır.
//&& işateri belli koşullara bağlı render etme ->sol taraf true ise sağ tarafı ekle, false ise ekleme anlamında
//? işareti ise se şunu yap değilse bunu yap-->
//axios ile ilgili detaylı araştır
//sass araştır??
//async -ile çağrıları await edebiliyoruz yani->
/*signUp(body)
.then(response => {this.setState({ pendingApiCall: false });
}).catch(error => {
this.setState({ pendingApiCall: false });
});->bunun yerine 
    
    const response=await signUp(body);    codumuzun bu noktada biraz beklemesini ve cevabı alduktan sonra responseye düşer*/

/* error tarafını nasıl hallediyoruz bu durmda kodumuzu try catch bloguna alıyoruz yani->
 try{
     const response=await signUp(body);
 }catch(error){

 }*/

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

/*/*axios
.post('/api/1.0/users', body)*///burayı signUp olarak değişrip yeniden yazdık*/
/* signUp(body)
     .then((response) => {
         this.setState({ pendingApiCall: false });
     }).catch(error => {
         this.setState({ pendingApiCall: false });
     }); */

