package com.mytravels.flights.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryListVO {
    @JsonProperty("Countries")
    List<CountryVO> countries;
}
