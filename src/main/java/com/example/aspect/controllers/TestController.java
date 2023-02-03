package com.example.aspect.controllers;

import com.example.aspect.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/take-name/{name}")
    public String takeName(@PathVariable String name) {
        return testService.takeName(name);
    }

    @GetMapping("/find-name/{name}")
    public String findName(@PathVariable String name) {
        return testService.findName(name);
    }
}
