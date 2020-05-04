package com.mytravels.flights.service;

import com.mytravels.flights.domain.entity.Country;

import java.util.List;

public interface SkyScannerService {
    String COUNTRIES_URI = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US";

    void refreshCountries();

    List<Country> getCountries();
}
