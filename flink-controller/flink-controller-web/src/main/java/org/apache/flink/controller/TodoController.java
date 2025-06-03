package org.apache.flink.controller;

import org.apache.flink.graph.dto.input.TodoInput;
import org.apache.flink.graph.dto.output.TodoOutput;
import org.apache.flink.service.TodoService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @MutationMapping
    public Mono<TodoOutput> createTodo(@Argument("input") TodoInput input) {
        return service.createTodo(input);
    }

    @QueryMapping
    public Flux<TodoOutput> getAllTodos() {
        return service.getAllTodos();
    }
}
