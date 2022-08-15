package de.juergensen.philipp.todolist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ToDoElementRequestMapperTestCase {

  private ToDoElementRequestMapper requestMapper;

  @BeforeEach
  void init() {
    requestMapper = new ToDoElementRequestMapperImpl();
  }

  @Test
  void testMapElement_WithToDoElementDTO() {
    // Arrange
    final ToDoElementDTO requestElement = new ToDoElementDTO(1L, "This is Sparta!", LocalDate.now());

    // Act
    final ToDoElement mappedElement = requestMapper.mapElement(requestElement);

    // Assert
    assertEquals("This is Sparta!", mappedElement.getDescription());
    assertEquals(requestElement.getDate(), mappedElement.getDate());
    assertEquals(requestElement.getId(), mappedElement.getId());
  }

  @Test
  void testMapElement_WithDescriptionAndDate() {
    // Arrange
    final String description = "Moin moin";
    final LocalDate date = LocalDate.now();

    // Act
    final ToDoElement mappedElement = requestMapper.mapElement(description, date);

    // Assert
    assertEquals(description, mappedElement.getDescription());
    assertEquals(date, mappedElement.getDate());
    assertNull(mappedElement.getId());
  }

}
