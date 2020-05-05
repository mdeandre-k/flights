package com.mytravels.flights.service;

import com.mytravels.flights.domain.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    void saveAll(List<Country> countries);
}
