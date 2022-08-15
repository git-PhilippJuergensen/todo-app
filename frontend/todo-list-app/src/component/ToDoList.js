import { Component } from "react";
import List from '@mui/material/List';
import ToDoElement from './ToDoElement';
import getToDoList from "../util/getToDoElements";
import deleteElement from "../util/deleteElement";

export default class ToDoList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            elements: []
        }
        this.fetchData = this.fetchData.bind(this);
        this.clickDeleteElement = this.clickDeleteElement.bind(this);
    }

    async fetchData() {
        const elementList = await getToDoList();
        this.setState({
            elements: elementList
        });
    }

    async clickDeleteElement(element) {
        await deleteElement(element);
        this.fetchData();
    }

    componentDidMount() {
        this.fetchData();
    }

    render() {
        return (
            <List dense={false}>
                {this.state.elements.map(
                    element => (
                        <ToDoElement 
                            key={element.id} 
                            element={element} 
                            deleteAction={() => this.clickDeleteElement(element)}
                        />
                    )
                )} 
            </List>
          );
    }

}