package com.saad.library.management.service;

import com.saad.library.management.model.book_data;
import com.saad.library.management.repository.bookDataRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookService {
    public final bookDataRepo BookDataRepo;

    public bookService(bookDataRepo bookDataRepo) {
        BookDataRepo = bookDataRepo;
    }

    public List<book_data> getAllBook() {
        return BookDataRepo.findAll();
    }

    public book_data createBook(book_data bookData) {
        return BookDataRepo.save(bookData);
    }

    public book_data updateBook(long id, book_data bookData) {
        book_data existingData=BookDataRepo.findById(id).orElseThrow(() -> new RuntimeException("book not availble"));
        existingData.setTitle(bookData.getTitle());
        existingData.setAuthor(bookData.getAuthor());
        existingData.setGenre(bookData.getGenre());
        existingData.setLanguage(bookData.getLanguage());
        existingData.setPublished_year(bookData.getPublished_year());
        return BookDataRepo.save(existingData);
    }

    public void deleteBook(long id) {
        BookDataRepo.deleteById(id);
    }

    public Optional<book_data> getBookById(long id) {
        return BookDataRepo.findById(id);
    }
}
