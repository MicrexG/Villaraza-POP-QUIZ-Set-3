package com.studentbooks.uap.api.popquiz.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studentbooks.uap.api.popquiz.models.Book;
import com.studentbooks.uap.api.popquiz.models.Student;
import com.studentbooks.uap.api.popquiz.repository.BookMapper;
import com.studentbooks.uap.api.popquiz.repository.StudentMapper;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentBooksController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private BookMapper bookMapper;

    //PAKI AYOS AT DI GUMAGANA
    //HETOH YUNG implementation para gumawa ng student saka sa book borrowing implementation
    @PostMapping("/borrow")
    public Student borrowBooks(@RequestBody Student student) {
        studentMapper.insertStudent(student);
        List<Book> books = student.getBooks();
        for (Book book : books) {
            bookMapper.insertBook(book);
        }
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        return student;
    }
    @GetMapping("/books/{type}")
    public List<Book> getBooksByType(@PathVariable String type) {
        return bookMapper.selectBooksByType(type);
    }
}
