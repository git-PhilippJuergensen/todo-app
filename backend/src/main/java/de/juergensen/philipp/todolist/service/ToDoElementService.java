package de.juergensen.philipp.todolist.service;

import de.juergensen.philipp.todolist.model.ToDoElement;
import java.util.List;

public interface ToDoElementService {

  /**
   * Deletes the given ToDoElement from the database.
   *
   * @param element The ToDoElement
   */
  void deleteElement(ToDoElement element);

  /**
   * Get a collection of all ToDoElements from the database.
   *
   * @return list of all ToDoElements.
   */
  List<ToDoElement> getAllElements();

  /**
   * Create a new ToDoElement.
   *
   * @param element The ToDoElement
   */
  void createElement(ToDoElement element);

}
