package de.juergensen.philipp.todolist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import de.juergensen.philipp.todolist.repository.ToDoElementRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ToDoElementServiceTestCase {

  @InjectMocks
  private ToDoElementServiceImpl toDoElementService;

  @Mock
  private ToDoElementRepository toDoElementRepository;

  private List<ToDoElement> databaseElements;

  @BeforeEach
  void init() {
    final ToDoElement toDoElement_1 = new ToDoElement(1L, "ToDo No. 1", LocalDate.now());
    final ToDoElement toDoElement_2 = new ToDoElement(2L, "ToDo No. 2", LocalDate.now());
    databaseElements = new ArrayList<>();
    databaseElements.add(toDoElement_1);
    databaseElements.add(toDoElement_2);
  }

  @Test
  void testGetAllElements_ReturnAllOnes() {
    // Arrange
    when(toDoElementRepository.findAll()).thenReturn(databaseElements);

    // Act
    final List<ToDoElement> allElements = toDoElementService.getAllElements();

    // Assert
    assertEquals(allElements, databaseElements);
    verify(toDoElementRepository, times(1)).findAll();
  }

  @Test
  void testDeleteElement_WithExistingElement() {
    // Arrange
    final ToDoElement toDeleteElement = databaseElements.get(0);

    // Act
    toDoElementService.deleteElement(toDeleteElement);

    // Assert
    verify(toDoElementRepository, times(1)).delete(toDeleteElement);
  }

  @Test
  void testDeleteElement_WithNotExistingElement() {
    // Arrange
    final ToDoElement toDeleteElement = new ToDoElement(5L, "I'm not there", LocalDate.now());

    // Act
    toDoElementService.deleteElement(toDeleteElement);

    // Assert
    assertEquals(2, databaseElements.size());
    verify(toDoElementRepository, times(1)).delete(toDeleteElement);
  }

  @Test
  void testCreateElement() {
    // Arrange
    final ToDoElementDTO requestElement = new ToDoElementDTO(null, "The new one.", LocalDate.now());
    final ToDoElement mappedElement = new ToDoElement(null, requestElement.getDescription(), requestElement.getDate());

    // Act
    toDoElementService.createElement(mappedElement);

    // Assert
    verify(toDoElementRepository).save(mappedElement);
  }

}
