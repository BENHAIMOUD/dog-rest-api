package com.benhaimoud.service;

import com.benhaimoud.entity.Dog;
import com.benhaimoud.exception.DogNotFoundException;
import com.benhaimoud.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{

    @Autowired
    private DogRepository repo;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) repo.findAll();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(repo.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) repo.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        return (List<String>) repo.findAllName();
    }
}
