package org.unit.flink.dls.service;

import org.apache.flink.graph.dto.input.UserInput;

import org.apache.flink.graph.dto.output.UserOutput;
import org.apache.flink.graph.model.User;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final Map<String, User> userStore = new ConcurrentHashMap<>();

    public Mono<UserOutput> getUserById(String id) {
        return Mono.justOrEmpty(userStore.get(id))
                .map(this::toOutput);
    }

    public Flux<UserOutput> getAllUsers() {
        return Flux.fromIterable(userStore.values())
                .map(this::toOutput);
    }

    public Mono<UserOutput> createUser(UserInput input) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, input.name(), input.email());
        userStore.put(id, user);
        return Mono.just(toOutput(user));
    }

    // ====== 可选：提取 mapper 逻辑 ======
    private UserOutput toOutput(User user) {
        return new UserOutput(user.getId(), user.getName(), user.getEmail());
    }
}
