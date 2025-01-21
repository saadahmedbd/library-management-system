package com.saad.library.management.service;

import com.saad.library.management.model.library;
import com.saad.library.management.repository.libraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public library updateLibrary(long id, library library) {
        library existingData=LibraryRepo.findById(id).orElseThrow(()-> new RuntimeException("library not found"));
        existingData.setName(library.getName());
        existingData.setLocation(library.getLocation());
        existingData.setContract(library.getContract());
        return LibraryRepo.save(existingData);
    }

    public List<library> getLibraryById(long id) {
        return  LibraryRepo.findAllById(Collections.singleton(id));
    }

    public void deleteLibraray(long id) {
         LibraryRepo.deleteById(id);
    }
}
