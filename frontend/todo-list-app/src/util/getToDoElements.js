import httpClient from "./httpClient";
import { GET_TODO_LIST } from "../constants";

export default async function getToDoList() {
    try {
        const response = await httpClient.get(GET_TODO_LIST);

        return response.data;
    } catch (error) {
        throw error;
    }
}