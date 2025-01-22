package com.saad.library.management.controller;

import com.saad.library.management.model.book_data;
import com.saad.library.management.service.bookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bookController {
    public final bookService BookService;


    public bookController(bookService bookService) {
        BookService = bookService;
    }
    @GetMapping("/book")
    public List<book_data> getAllbook(){
        return BookService.getAllBook();
    }
    @GetMapping("/book/{id}")
    public Optional<book_data> getbookbyid(@PathVariable long id){
        return BookService.getBookById(id);
    }
    @PostMapping("book/add")
    public book_data addBook(@RequestBody book_data Book_data){
        return BookService.createBook(Book_data);
    }
    @PutMapping("/book/{id}")
    public book_data updateBook(@PathVariable long id, @RequestBody book_data Book_data){
        return BookService.updateBook(id, Book_data);
    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable long id){
        BookService.deleteBook(id);
    }
}
