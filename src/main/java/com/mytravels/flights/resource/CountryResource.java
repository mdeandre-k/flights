package com.mytravels.flights.resource;

import com.mytravels.flights.domain.entity.Country;
import com.mytravels.flights.service.SkyScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final SkyScannerService skyScannerService;

    @GetMapping
    public List<Country> getAll() {
        return skyScannerService.getCountries();
    }

    @GetMapping("refresh")
    public void refreshAll() {
        skyScannerService.refreshCountries();
    }
}
