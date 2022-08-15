package de.juergensen.philipp.todolist;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.juergensen.philipp.todolist.controller.ToDoElementController;
import de.juergensen.philipp.todolist.repository.ToDoElementRepository;
import de.juergensen.philipp.todolist.service.ToDoElementRequestMapper;
import de.juergensen.philipp.todolist.service.ToDoElementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

  @Autowired
  private ToDoElementController toDoElementController;

  @Autowired
  private ToDoElementRequestMapper requestMapper;

  @Autowired
  private ToDoElementService toDoElementService;

  @Autowired
  private ToDoElementRepository toDoElementRepository;

  @Test
  void contextLoads() {
    assertNotNull(toDoElementController);
    assertNotNull(requestMapper);
    assertNotNull(toDoElementService);
    assertNotNull(toDoElementRepository);
  }

}
