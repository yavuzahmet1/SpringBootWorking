import React from "react";
//import axios from "axios";//buna gerek kalmadı importumuz artık api clasörü içinden
import { signUp } from '../api/apiCalls';

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

        } catch (errors) { }

        this.setState({ pendingApiCall: false });



    };


    render() {
        const { pendingApiCall } = this.state;
        return (

            <div className="container">
                <form>
                    <h1 className="text-center">Sign Up</h1>
                    <div className="mb-3">
                        <label>UserName</label>
                        <input className="form-control is-invalid" name="userName" onChange={this.onChange} />
                        <div className="invalid-feedback">{this.state.errors}</div>
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
                            disabled={pendingApiCall}>
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

