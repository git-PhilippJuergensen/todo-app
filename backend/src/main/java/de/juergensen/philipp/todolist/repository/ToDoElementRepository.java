package de.juergensen.philipp.todolist.repository;

import de.juergensen.philipp.todolist.model.ToDoElement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoElementRepository extends CrudRepository<ToDoElement, Long> {

}
