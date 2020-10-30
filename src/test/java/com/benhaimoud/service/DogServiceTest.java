package com.benhaimoud.service;

import com.benhaimoud.entity.Dog;
import com.benhaimoud.repository.DogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * @author Ayoub BENHAIMOUD <ayoubbenhaimoud@gmail.com>
 * @created on 16/09/2020
 */
@RunWith(SpringRunner.class)
public class DogServiceTest {

    @MockBean
    private DogRepository dogRepository;

    @Autowired
    private DogService dogService;
    //any beans configured in a top-level class annotated with @TestConfiguration will not be picked up via component scanning
    @TestConfiguration
    static class DogServiceContextConfiguration {
        @Bean
        public DogService dogService() {
            return new DogServiceImpl() {
            };
        }
    }

    @Test
    public void whenFindAll_ReturnDogList() {
        //Mockup
        Dog dog1 = new Dog(1," dog1", "dog1", "dog1" );
        Dog dog2 = new Dog(2," dog2", "dog2", "dog2" );
        List<Dog> data = Arrays.asList(dog1,dog2);

        given(dogRepository.findAll()).willReturn(data);

        //
        assertThat(dogService.retrieveDogs())
                .hasSize(2)
                .contains(dog1, dog2);
    }
    @Test
    public void whenGetById_DogShouldBeFound(){
        Dog dog = new Dog(1,"dog", "dog", "dog" );
        given(dogRepository.findById(anyLong())).willReturn(Optional.ofNullable(dog));

        Dog result = dogService.retrieveDogById(1);
        //assertThat(result.getName().compareToIgnoreCase("ee"));
        assertThat(result.getOrigin().compareToIgnoreCase("dog"));
    }

    @Test
    public  void whenGetId_BreedShouldBeFound(){

    }

    @Test
    public void whenFindAll_ReturnBreeList(){

    }

    @Test
    public void whenFindAll_ReturnNameList(){

    }




}
