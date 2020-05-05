package com.mytravels.flights.resource;

import com.mytravels.flights.domain.entity.Country;
import com.mytravels.flights.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAll() {
        return countryService.findAll();
    }
}
