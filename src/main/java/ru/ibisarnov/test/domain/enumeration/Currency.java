package ru.ibisarnov.test.domain.enumeration;

import java.util.Arrays;

/**
 * This enum represents an allowed list of currencies.
 */
public enum Currency {
    RUR("RUR"),
    USD("USD"),
    EUR("EUR");

    Currency(String name) {
        this.name = name;
    }

    private final String name;

    public static Currency getByName(final String name) {
        return Arrays.stream(Currency.values())
                .filter(val -> val.name.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
