package com.benhaimoud.web;

import com.benhaimoud.entity.Dog;
import com.benhaimoud.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService service;

    @GetMapping
    public ResponseEntity <List<Dog>> getAllDogs() {
        List <Dog> dogs = service.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }
    @GetMapping("/breed")
    public ResponseEntity <List<String>> getDogBreeds() {
        List <String> breeds = service.retrieveDogBreed();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }
    @GetMapping("/{id}/breed")
    public ResponseEntity <String> getBreedById(@PathVariable Long id) {
        String breed = service.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
    @GetMapping("/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> names = service.retrieveDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}
