package com.benhaimoud.web;

import com.benhaimoud.entity.Dog;
import com.benhaimoud.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Ayoub BENHAIMOUD <ayoubbenhaimoud@gmail.com>
 * @created on 16/09/2020
 */
@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    /**
     * Retrieve all dogs
     * @return List<Dog>
     */
    @GetMapping
    public ResponseEntity <List<Dog>> getAllDogs() {
        List <Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    /**
     * Retrieve dog breed
     * @return List<String>
     */
    @GetMapping("/breed")
    public ResponseEntity <List<String>> getDogBreeds() {
        List <String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    /**
     * Retrieve dog breed by id
     * @param id
     * @return String
     */
    @GetMapping("/{id}/breed")
    public ResponseEntity <String> getBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    /**
     * Retrieve dog names
     * @return List<String>
     */
    @GetMapping("/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}
