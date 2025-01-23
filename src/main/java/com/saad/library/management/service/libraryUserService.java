package com.saad.library.management.service;


import com.saad.library.management.model.libraryUser;
import com.saad.library.management.repository.LibraryUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class libraryUserService {
  public final LibraryUserRepo libraryUserRepo;

    public libraryUserService(LibraryUserRepo libraryUserRepo) {
        this.libraryUserRepo = libraryUserRepo;
    }

    public List<libraryUser> getAllUser() {
      return libraryUserRepo.findAll();
    }

  public Optional<libraryUser> getUserId(long id) {
      return libraryUserRepo.findById(id);
  }

  public libraryUser addUser(libraryUser libraryUser) {
      return libraryUserRepo.save(libraryUser);
  }

  public libraryUser updateUser(libraryUser libraryUser, long id) {
        libraryUser existingUser=libraryUserRepo.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        existingUser.setUserName(libraryUser.getUserName());
        existingUser.setEmail(libraryUser.getEmail());
        existingUser.setAddress(libraryUser.getAddress());
        existingUser.setPhone(libraryUser.getPhone());
        return libraryUserRepo.save(existingUser);
    }

    public void deleteUser(long id) {
        libraryUserRepo.deleteById(id);
    }
}
