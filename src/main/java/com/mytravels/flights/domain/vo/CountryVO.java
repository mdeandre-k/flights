package com.mytravels.flights.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryVO {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
}
