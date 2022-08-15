import httpClient from "./httpClient";
import { DELETE_ELEMENT } from "../constants";

export default async function deleteElement(element) {
    try {
        const response = await httpClient.delete(DELETE_ELEMENT, {
            data: {
                id: element.id,
                description: element.description,
                date: element.date
            }
        });

        return response.data;
    } catch (error) {
        throw error;
    }
}