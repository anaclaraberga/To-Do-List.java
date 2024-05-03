package br.edu.fag.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fag.todolist.model.Task;
import br.edu.fag.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask (Task task) {
        return taskRepository.save(task);
    }
}
