package br.edu.fag.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fag.todolist.model.Task;
import br.edu.fag.todolist.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @Operation(summary = "Criando uma nova tarefa",
        responses = {@ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso."),
    @ApiResponse(responseCode = "500", description = "Erro ao criar as tarefas, verifique as informações concedidas.")})
    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask (@RequestBody Task task) {
        log.info("Criando uma nova tarefa com as informações recebidas [{}]", task);
        return taskService.createTask(task);
    }

    @Operation(summary = "Listando todas as tarefas",
        responses = {@ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso."),
    @ApiResponse(responseCode = "500", description = "Erro ao listar as tarefas, verifique as informações concedidas.")})
    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        log.info("Listando todas as tarefas cadastradas [{}]");
        return taskService.ListAllTasks();
    }

    @Operation(summary = "Buscando tarefa pelo Id",
        responses = {@ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso."),
    @ApiResponse(responseCode = "404", description = "Erro ao encontrar a tarefa, verifique as informações concedidas.")})
    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id) {
        log.info("Buscando tarefa com o id [{}]", id);
        return taskService.findTaskById(id);
    }

    @Operation(summary = "Atualizando tarefa pelo Id",
        responses = {@ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso."),
    @ApiResponse(responseCode = "404", description = "Erro ao atualizar a tarefa, verifique as informações concedidas.")})
    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable(value = "id") Long id, @RequestBody Task task) {
        log.info("Atualizando tarefa com o id [{}]", id, task);
        return taskService.updateTaskById(task, id);
    }

    @Operation(summary = "Deletando tarefa pelo Id",
        responses = {@ApiResponse(responseCode = "204", description = "Tarefa deletada com sucesso."),
    @ApiResponse(responseCode = "404", description = "Erro ao deletar a tarefa, verifique as informações concedidas.")})
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable(value = "id") Long id) {
        log.info("Excluindo tarefa com o id [{}]", id);
        return taskService.deleteById(id);
    }
}
