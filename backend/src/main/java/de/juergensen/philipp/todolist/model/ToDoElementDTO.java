package de.juergensen.philipp.todolist.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ToDoElementDTO {

  private Long id;

  @NonNull
  private String description;

  @NonNull
  private LocalDate date;

}
