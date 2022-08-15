import axios from "axios";
import { API_BASE_URL } from "../constants";

// axios.defaults.withCredentials = true;

export default axios.create({
    baseURL: API_BASE_URL,
    // headers: {
    //     'Accept': '*/*',
    //     'Access-Control-Allow-Origin': '*'
    // }
});