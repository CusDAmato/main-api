package ru.diamond.mainapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartsOfTheDay {

    MORNING("morning"),
    AFTERNOON("afternoon"),
    EVENING("evening"),
    NIGHT("night");

    private final String value;
}
