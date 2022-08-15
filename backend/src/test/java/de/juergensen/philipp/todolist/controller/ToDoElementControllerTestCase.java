package de.juergensen.philipp.todolist.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import de.juergensen.philipp.todolist.service.ToDoElementRequestMapper;
import de.juergensen.philipp.todolist.service.ToDoElementService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ToDoElementControllerTestCase {

  @InjectMocks
  private ToDoElementController toDoElementController;

  @Mock
  private ToDoElementService toDoElementService;

  @Mock
  private ToDoElementRequestMapper toDoElementRequestMapper;

  private List<ToDoElement> databaseElements;

  @BeforeEach
  void init() {
    final ToDoElement toDoElement_1 = new ToDoElement(1L, "Create the a new entry.", LocalDate.now());
    final ToDoElement toDoElement_2 = new ToDoElement(2L, "Please hold the line.", LocalDate.now());
    databaseElements = new ArrayList<>();
    databaseElements.add(toDoElement_1);
    databaseElements.add(toDoElement_2);
  }

  @Test
  void testGetAllElements_Returns_OK_And_FilledList() {
    // Arrange
    when(toDoElementService.getAllElements()).thenReturn(databaseElements);

    // Act
    final ResponseEntity<List<ToDoElement>> allElementsResponse = toDoElementController.getAllElements();

    //Assert
    assertEquals(HttpStatus.OK, allElementsResponse.getStatusCode());
    assertEquals(2, allElementsResponse.getBody().size());
    verify(toDoElementService).getAllElements();
  }

  @Test
  void testDeleteElement_Returns_OK_And_DeleteElement() {
    // Arrange
    final ToDoElement originElement = databaseElements.get(0);
    final ToDoElementDTO element = new ToDoElementDTO(originElement.getId(), originElement.getDescription(), originElement.getDate());
    when(toDoElementRequestMapper.mapElement(element)).thenReturn(new ToDoElement(originElement.getId(), originElement.getDescription(), originElement.getDate()));

    // Act
    final ResponseEntity<String> response = toDoElementController.deleteElement(element);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    verify(toDoElementRequestMapper).mapElement(element);
    verify(toDoElementService).deleteElement(any(ToDoElement.class));
  }

  @Test
  void testCreateElement_Return_OK_And_CreatedNewElement() {
    // Arrange
    final ToDoElementDTO requestElement = new ToDoElementDTO(1L, "Ignore the id.", LocalDate.now());
    final ToDoElement mappedElement = new ToDoElement(null, requestElement.getDescription(), requestElement.getDate());
    when(toDoElementRequestMapper.mapElement(requestElement.getDescription(), requestElement.getDate())).thenReturn(mappedElement);

    // Act
    final ResponseEntity<String> response = toDoElementController.createElement(requestElement);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    verify(toDoElementRequestMapper).mapElement(requestElement.getDescription(), requestElement.getDate());
    verify(toDoElementService).createElement(any(ToDoElement.class));
  }

}
