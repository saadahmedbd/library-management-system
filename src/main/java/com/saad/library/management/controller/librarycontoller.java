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
    @GetMapping("/{id}")
    public List<library> getLibraryById(@PathVariable long id){
        return LibraryService.getLibraryById(id);
    }
    @PostMapping
    public library createLibraryData( @RequestBody library Library){
        return LibraryService.createLibrary(Library);
    }
    @PutMapping("/{id}")
    public library updateLibrary(@PathVariable long id, @RequestBody library Library){
        return LibraryService.updateLibrary(id, Library);
    }
    @DeleteMapping("{id}")
    public void deleteLibrary(@PathVariable long id){
        LibraryService.deleteLibraray(id);
    }


}
