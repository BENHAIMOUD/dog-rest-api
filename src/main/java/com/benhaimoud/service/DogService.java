package com.benhaimoud.service;

import com.benhaimoud.entity.Dog;

import java.util.List;
import java.util.Optional;
/**
 * @author Ayoub BENHAIMOUD <ayoubbenhaimoud@gmail.com>
 * @created on 16/09/2020
 */
public interface DogService {
     List <Dog> retrieveDogs();
     Dog retrieveDogById(long id);
     String retrieveDogBreedById(Long id);
     List <String> retrieveDogBreed();
     List<String> retrieveDogNames();
}
