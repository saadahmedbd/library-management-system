package com.saad.library.management.service;

import com.saad.library.management.model.library;
import com.saad.library.management.repository.libraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class libraryService {
    public final libraryRepo LibraryRepo;

    public libraryService(libraryRepo libraryRepo) {
        LibraryRepo = libraryRepo;
    }

    public List<library> getAllLibrary() {
        return LibraryRepo.findAll();
    }

    public library createLibrary(library Library) {
        return LibraryRepo.save(Library);
    }
}
