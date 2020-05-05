package com.mytravels.flights.service.impl;

import com.mytravels.flights.domain.vo.CountryListVO;
import com.mytravels.flights.domain.vo.CountryVO;
import com.mytravels.flights.service.SkyScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SkyScannerServiceImpl implements SkyScannerService {

    private final RestTemplate skyScannerRestTemplate;

    @Override
    public List<CountryVO> getCountries() {
        ResponseEntity<CountryListVO> countryResponse = skyScannerRestTemplate.getForEntity(COUNTRIES_URI, CountryListVO.class);

        return Optional.ofNullable(countryResponse.getBody())
                .map(CountryListVO::getCountries)
                .orElse(Collections.emptyList());
    }
}
