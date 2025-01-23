package com.saad.library.management.controller;

import com.saad.library.management.model.libraryUser;
import com.saad.library.management.service.libraryUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class libraryUserController {
    public final libraryUserService LibraryUserService;

    public libraryUserController(libraryUserService libraryUserService) {
        LibraryUserService = libraryUserService;
    }

    @GetMapping("/user")
    public List<libraryUser> getAllUser(){
        return LibraryUserService.getAllUser();
    }
    @GetMapping("/user/{id}")
    public Optional<libraryUser> getUserById(@PathVariable long id){
        return LibraryUserService.getUserId(id);
    }
    @PostMapping("/user/adduser")
    public libraryUser addUser(@RequestBody libraryUser LibraryUser){
        return LibraryUserService.addUser(LibraryUser);
    }
    @PutMapping("/user/updateuser/{id}")
    public libraryUser updateUser(@RequestBody libraryUser LibraryUser, @PathVariable long id){
        return LibraryUserService.updateUser(LibraryUser, id);
    }
    @DeleteMapping("/user/deleteuser/{id}")
    public void deleteUser(@PathVariable long id){
        LibraryUserService.deleteUser(id);
    }
}
