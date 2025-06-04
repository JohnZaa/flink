package org.apache.flink.service;

import org.apache.flink.graph.dto.input.TodoInput;
import org.apache.flink.graph.dto.output.TodoOutput;
import org.apache.flink.graph.model.Todo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TodoService {

    private final Map<String, Todo> store = new ConcurrentHashMap<>();

    public Mono<TodoOutput> createTodo(TodoInput input) {
        String id = UUID.randomUUID().toString();
        Todo todo = new Todo(id, input.title(), input.completed());
        store.put(id, todo);
        return Mono.just(toOutput(todo));
    }

    public Flux<TodoOutput> getAllTodos() {
        return Flux.fromIterable(store.values()).map(this::toOutput);
    }

    private TodoOutput toOutput(Todo todo) {
        return new TodoOutput(todo.id(), todo.title(), todo.completed());
    }
}
