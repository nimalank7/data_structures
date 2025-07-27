package org.example.postgres.GroupAggregate;

import java.util.Objects;

class Row {
    String country;
    // Other data columns
    public Row(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(country, row.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    @Override
    public String toString() {
        return "GroupAggregate.Row{country='" + country + "'}";
    }
}