package com.example.aspect.controllers;

import com.example.aspect.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/dostoyevski")
    public String getDostoyevskiBook() {
        return bookService.getDostoyevskyBook();
    }

    @GetMapping("/tolstoy")
    public String getTolstoyBook() {
        return bookService.getTolstoyBook();
    }
}
