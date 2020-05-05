package com.mytravels.flights.service.impl;

import com.mytravels.flights.domain.vo.CountryListVO;
import com.mytravels.flights.domain.vo.CountryVO;
import com.mytravels.flights.service.SkyScannerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SkyScannerServiceImplTest {
    @Mock
    private RestTemplate restTemplateMock;

    private SkyScannerService skyScannerService;

    @BeforeEach
    void beforeEach() {
        skyScannerService = new SkyScannerServiceImpl(restTemplateMock);
    }

    @Test
    void getCountries() {
        List<CountryVO> countries = Collections.singletonList(new CountryVO());
        CountryListVO countryListVO = new CountryListVO();
        countryListVO.setCountries(countries);
        when(restTemplateMock.getForEntity(eq(SkyScannerService.COUNTRIES_URI), eq(CountryListVO.class)))
                .thenReturn(ResponseEntity.ok(countryListVO));

        List<CountryVO> countryVOS = skyScannerService.getCountries();
        assertEquals(countries, countryVOS);
    }
}