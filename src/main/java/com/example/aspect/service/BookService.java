package com.example.aspect.service;

import com.example.aspect.annotations.Confuse;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Confuse
    public String getDostoyevskyBook() {
        return "Мастер и маргарита";
    }

    public String getTolstoyBook() {
        return "Анна Каренина";
    }
}
