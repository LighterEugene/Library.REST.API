package com.example.library.Controllers;

import com.example.library.Models.Library;
import com.example.library.Models.LibraryPatchRequest;
import com.example.library.Repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
    private LibraryRepository libraryRepository;

    @GetMapping
    public List<Library> getAllLibraries() {
        return (List<Library>) libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        Optional<Library> library = libraryRepository.findById(id);
        return library.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody LibraryPatchRequest libraryPatchRequest) {
        Library existingLibrary = libraryRepository.findById(id).orElse(null);
        if (existingLibrary != null) {
            if (libraryPatchRequest.getName() != null) {
                existingLibrary.setName(libraryPatchRequest.getName());
            }
            if (libraryPatchRequest.getAddress() != null) {
                existingLibrary.setAddress(libraryPatchRequest.getAddress());
            }
            if (libraryPatchRequest.getWorkingHours() != null) {
                existingLibrary.setWorkingHours(libraryPatchRequest.getWorkingHours());
            }
            if (libraryPatchRequest.getStaffCount() != null) {
                existingLibrary.setStaffCount(libraryPatchRequest.getStaffCount());
            }
            if (libraryPatchRequest.getFoundationYear() != null) {
                existingLibrary.setFoundationYear(libraryPatchRequest.getFoundationYear());
            }

            Library updatedLibrary = libraryRepository.save(existingLibrary);
            return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Long id, @RequestBody Library updatedLibrary) {
        return libraryRepository.findById(id).map(library -> {
            library.setName(updatedLibrary.getName());
            library.setAddress(updatedLibrary.getAddress());
            library.setWorkingHours(updatedLibrary.getWorkingHours());
            library.setStaffCount(updatedLibrary.getStaffCount());
            library.setFoundationYear(updatedLibrary.getFoundationYear());
            return libraryRepository.save(library);
        }).orElseThrow(() -> new IllegalArgumentException("Library not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryRepository.deleteById(id);
    }
}