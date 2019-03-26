package pl.oskarpolak.wetherx.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CurrencyDto {

    @JsonProperty("rates")
    private List<Rate> currencyDataList;

    @Data
    public static class Rate {
        private double mid;
    }
}
