package com.mytravels.flights.service.impl;

import com.mytravels.flights.domain.entity.Country;
import com.mytravels.flights.repository.CountryRepository;
import com.mytravels.flights.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void saveAll(List<Country> countries) {
        countryRepository.saveAll(countries);
    }
}
