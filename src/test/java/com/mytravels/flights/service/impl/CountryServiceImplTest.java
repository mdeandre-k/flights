package com.mytravels.flights.service.impl;

import com.mytravels.flights.domain.entity.Country;
import com.mytravels.flights.repository.CountryRepository;
import com.mytravels.flights.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryServiceImplTest {

    @Mock
    CountryRepository countryRepositoryMock;

    CountryService countryService;

    @BeforeEach
    void beforeEach() {
        countryService = new CountryServiceImpl(countryRepositoryMock);
    }

    @Test
    void findAllTest() {
        when(countryRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        List<Country> countries = countryService.findAll();
        assertTrue(countries.isEmpty());
        verify(countryRepositoryMock, times(1)).findAll();
    }

    @Test
    void saveAllTest() {
        List<Country> countries = Collections.singletonList(new Country());
        countryService.saveAll(countries);
        verify(countryRepositoryMock, times(1)).saveAll(eq(countries));
    }

}