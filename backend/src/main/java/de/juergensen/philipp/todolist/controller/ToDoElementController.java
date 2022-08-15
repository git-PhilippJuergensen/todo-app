package de.juergensen.philipp.todolist.controller;

import de.juergensen.philipp.todolist.model.ToDoElement;
import de.juergensen.philipp.todolist.model.ToDoElementDTO;
import de.juergensen.philipp.todolist.service.ToDoElementRequestMapper;
import de.juergensen.philipp.todolist.service.ToDoElementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@CrossOrigin("http://localhost:3000")
public class ToDoElementController {

  @Autowired
  private ToDoElementService toDoElementService;

  @Autowired
  private ToDoElementRequestMapper toDoElementRequestMapper;

  @Operation(summary = "Get all ToDo elements.")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Successfully getting a list with all ToDo elements.",
              content = {@Content(mediaType = "application/json")}),
          @ApiResponse(
              responseCode = "405",
              description = "Unsupported request method.",
              content = @Content),
          @ApiResponse(
              responseCode = "500",
              description = "Unexpected internal error.",
              content = @Content),
      })
  @GetMapping("/all")
  public ResponseEntity<List<ToDoElement>> getAllElements() {
    return ResponseEntity.ok().body(toDoElementService.getAllElements());
  }

  @Operation(summary = "Delete a ToDo element.")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Given ToDo element is successfully deleted.",
              content = {@Content(mediaType = "application/json")}),
          @ApiResponse(
              responseCode = "405",
              description = "Unsupported request method.",
              content = @Content),
          @ApiResponse(
              responseCode = "500",
              description = "Unexpected internal error.",
              content = @Content),
      })
  @DeleteMapping
  public ResponseEntity<String> deleteElement(@RequestBody final ToDoElementDTO requestElement) {
    final ToDoElement element = toDoElementRequestMapper.mapElement(requestElement);
    toDoElementService.deleteElement(element);

    return ResponseEntity.ok().body("ToDo element " + requestElement.getDescription() + " successfully deleted.");
  }

  @Operation(summary = "Create a ToDo elements.")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "ToDo element is created successfully.",
              content = {@Content(mediaType = "application/json")}),
          @ApiResponse(
              responseCode = "405",
              description = "Unsupported request method.",
              content = @Content),
          @ApiResponse(
              responseCode = "500",
              description = "Unexpected internal error.",
              content = @Content),
      })
  @PostMapping
  public ResponseEntity<String> createElement(@RequestBody final ToDoElementDTO elementDTO) {
    final ToDoElement element = toDoElementRequestMapper.mapElement(elementDTO.getDescription(), elementDTO.getDate());
    toDoElementService.createElement(element);

    return ResponseEntity.ok().body("ToDo element " + element.getDescription() + " successfully created.");
  }

}
