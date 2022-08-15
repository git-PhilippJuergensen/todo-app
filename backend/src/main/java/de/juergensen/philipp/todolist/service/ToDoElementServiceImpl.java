package de.juergensen.philipp.todolist.service;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.repository.ToDoElementRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoElementServiceImpl implements ToDoElementService {

  @Autowired
  private ToDoElementRepository toDoElementRepository;

  @Override
  public void deleteElement(final ToDoElement element) {
    toDoElementRepository.delete(element);
  }

  @Override
  public List<ToDoElement> getAllElements() {
    return (List<ToDoElement>) toDoElementRepository.findAll();
  }

  @Override
  public void createElement(ToDoElement element) {
    toDoElementRepository.save(element);
  }
}
