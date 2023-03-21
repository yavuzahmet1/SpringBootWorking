import axios from "axios";

export const signUp = (body) => {
    return axios.post('/api/1.0/users', body);
};

export const login = creds => {
    return axios.post('/api/1.0/auth', {}, { auth: creds });
}
