package com.saad.library.management.controller;

import com.saad.library.management.model.borrow_book;
import com.saad.library.management.service.bookBorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookBorrowController {
    public final bookBorrowService BookBorrowService;

    public bookBorrowController(bookBorrowService bookBorrowService) {
        BookBorrowService = bookBorrowService;
    }
    @GetMapping("/book/borrowbook")
    public List<borrow_book> getborrowbook(){
        return BookBorrowService.getborrowbook();
    }
    @PostMapping("/book/borrowbook/add")
    public borrow_book addborrowbook(@RequestBody borrow_book borrowBook){
        return BookBorrowService.addborrowbook(borrowBook);
    }
    @PutMapping("/book/borrowbook/update/{id}")
    public borrow_book updateborrowbook(@RequestBody borrow_book borrowBook, @PathVariable long id){
        return BookBorrowService.updateborrowbook(borrowBook, id);
    }
    @DeleteMapping("book/borrowbook/delete/{id}")
    public void deleteborrowBook(@PathVariable long id){
        BookBorrowService.deleteBorrowBook(id);
    }
}
