package com.saad.library.management.controller;

import com.saad.library.management.model.library;
import com.saad.library.management.service.libraryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class librarycontoller {

    public final libraryService LibraryService;

    public librarycontoller(libraryService libraryService) {
        LibraryService = libraryService;
    }

    @GetMapping
    public List<library> getAllLibrary(){
       return LibraryService.getAllLibrary();
    }
    @PostMapping
    public library createLibraryData( @RequestBody library Library){
        return LibraryService.createLibrary(Library);
    }

}
