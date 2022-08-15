import { Component } from "react";
import ListItem from '@mui/material/ListItem';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import TaskIcon from '@mui/icons-material/Task';
import Avatar from '@mui/material/Avatar';
import ListItemText from '@mui/material/ListItemText';


export default class ToDoElement extends Component {

    constructor(props) {
        super(props);
        this.formatDate = this.formatDate.bind(this);
    }

    formatDate(date) {
        const toFormatDate = new Date(Date(date));
        return [
            toFormatDate.getDate(),
            toFormatDate.getMonth() +1,
            toFormatDate.getFullYear()
          ].join('.');
    }

    render() {
        return (
          <ListItem
            secondaryAction={
              <IconButton edge="end" aria-label="delete" onClick={() => this.props.deleteAction()}>
                <DeleteIcon />
              </IconButton>
            }
          >
            <ListItemAvatar>
              <Avatar>
                <TaskIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText
              primary={this.props.element.description}
              secondary={this.formatDate(this.props.element.date)}
            />
          </ListItem>
        );
    }
}