package ru.ibisarnov.test.domain.enumeration;

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

    @Override
    public String toString() {
        return name;
    }
}
