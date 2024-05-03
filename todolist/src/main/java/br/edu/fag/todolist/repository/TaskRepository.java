package br.edu.fag.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fag.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
