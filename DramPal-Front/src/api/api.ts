import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8081/api/user', // backend base path
});

export default API;
