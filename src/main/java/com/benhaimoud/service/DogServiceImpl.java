package com.benhaimoud.service;

import com.benhaimoud.entity.Dog;
import com.benhaimoud.exception.NotFoundException;
import com.benhaimoud.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
/**
 * @author Ayoub BENHAIMOUD <ayoubbenhaimoud@gmail.com>
 * @created on 16/09/2020
 */
@Service
public class DogServiceImpl implements DogService{

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog retrieveDogById(long id) {
        try {
            return dogRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Dog with the id [%s] was found in our database", id));
        }
    }


    @Override
    public String retrieveDogBreedById(Long id) {
        try {
            return dogRepository.findBreedById(id);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Dog with the id [%s] was found in our database", id));
        }
    }
    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }
}
