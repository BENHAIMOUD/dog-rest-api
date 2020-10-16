package com.benhaimoud.service;

import com.benhaimoud.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface DogService {
     List <Dog> retrieveDogs();
     String retrieveDogBreedById(Long id);
    List <String> retrieveDogBreed();
     List<String> retrieveDogNames();
}
