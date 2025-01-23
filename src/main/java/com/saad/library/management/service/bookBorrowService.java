package com.saad.library.management.service;


import com.saad.library.management.model.borrow_book;
import com.saad.library.management.repository.borrowBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookBorrowService {
   public final borrowBookRepo borrowBookRepo;

    public bookBorrowService(com.saad.library.management.repository.borrowBookRepo borrowBookRepo) {
        this.borrowBookRepo = borrowBookRepo;
    }


    public List<borrow_book> getborrowbook() {
        return borrowBookRepo.findAll();
    }

    public borrow_book addborrowbook(borrow_book borrowBook) {
        return borrowBookRepo.save(borrowBook);
    }

    public borrow_book updateborrowbook(borrow_book borrowBook, long id) {
        borrow_book existingborrowbook =borrowBookRepo.findById(id).orElseThrow(()-> new RuntimeException("your existing borrow book not found"));
        existingborrowbook.setBorrow_date(borrowBook.getBorrow_date());
        existingborrowbook.setReturn_date(borrowBook.getReturn_date());
        existingborrowbook.setStatus(borrowBook.getStatus());
        return borrowBookRepo.save(existingborrowbook);
    }

    public void deleteBorrowBook(long id) {
        borrowBookRepo.deleteById(id);
    }
}
