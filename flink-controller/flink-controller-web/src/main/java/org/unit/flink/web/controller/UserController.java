package org.unit.flink.web.controller;

import org.apache.flink.graph.dto.input.UserInput;

import org.apache.flink.graph.dto.output.UserOutput;
import org.apache.flink.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserController {

    @Autowired
    private UserService userService;

    @MutationMapping
    public Mono<UserOutput> createUser(@Argument("input") UserInput input) {
        return userService.createUser(input);
    }

    @QueryMapping
    public Mono<UserOutput> getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public Flux<UserOutput> allUsers() {
        return userService.getAllUsers();
    }
}
