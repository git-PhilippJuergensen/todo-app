package de.juergensen.philipp.todolist.service;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class ToDoElementRequestMapperImpl implements ToDoElementRequestMapper {

  @Override
  public ToDoElement mapElement(final ToDoElementDTO element) {
    return new ToDoElement(element.getId(), element.getDescription(), element.getDate());
  }

  @Override
  public ToDoElement mapElement(String description, LocalDate date) {
    final ToDoElement element = new ToDoElement();
    element.setDescription(description);
    element.setDate(date);

    return element;
  }
}
