package de.juergensen.philipp.todolist.service;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import java.time.LocalDate;

public interface ToDoElementRequestMapper {

  ToDoElement mapElement(ToDoElementDTO element);

  ToDoElement mapElement(String description, LocalDate date);

}
