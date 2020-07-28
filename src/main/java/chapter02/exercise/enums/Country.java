package chapter02.exercise.enums;

import lombok.Getter;

public enum Country {

    POLAND(0.23), RUSSIA(0.18), UK(0.25), FRANCE(0.15),
    GERMANY(0.13), UKRAINE(0.28), BELGIUM(0.33), HUNGARY(0.18);

    @Getter
    private final Double taxRatio;

    Country(Double taxRatio) {
        this.taxRatio = taxRatio;
    }
}
