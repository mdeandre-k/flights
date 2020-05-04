package com.mytravels.flights.service.impl;

import com.mytravels.flights.domain.entity.Country;
import com.mytravels.flights.domain.vo.CountryListVO;
import com.mytravels.flights.repository.CountryRepository;
import com.mytravels.flights.service.SkyScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SkyScannerServiceImpl implements SkyScannerService {

    private final RestTemplate skyScannerRestTemplate;
    private final CountryRepository countryRepository;

    @Override
    public void refreshCountries() {
        ResponseEntity<CountryListVO> response = skyScannerRestTemplate.getForEntity(COUNTRIES_URI, CountryListVO.class);

        List<Country> countries = response.getBody().getCountries().stream()
                .map(vo -> new Country(vo.getCode(), vo.getName()))
                .collect(toList());

        countryRepository.saveAll(countries);
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
