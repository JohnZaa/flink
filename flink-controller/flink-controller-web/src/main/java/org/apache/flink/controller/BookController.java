package org.apache.flink.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class BookController {

    record Book(String id, String title, String author) {}

    @QueryMapping
    public Mono<Book> bookById(String id) {
        return Mono.just(new Book(id, "Spring WebFlux in Action", "John Doe"));
    }
}