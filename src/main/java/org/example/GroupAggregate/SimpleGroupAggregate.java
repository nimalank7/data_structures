package org.example.GroupAggregate;

import java.util.ArrayList;
import java.util.List;

public class SimpleGroupAggregate {

    public static List<GroupedResult> groupAndCount(List<Row> sortedRows) {
        List<GroupedResult> results = new ArrayList<>();
        if (sortedRows.isEmpty()) {
            return results;
        }

        // Retrieve the current country
        String currentCountry = sortedRows.get(0).country;

        // Set count to 0
        int currentCount = 0;

        for (Row row : sortedRows ) {
            if (row.country.equals(currentCountry)) {
                currentCount++;
            } else {
                /*
                Once we hit 'Canada' then we put the country and count into the results (e.g. USA - 2)
                Set the currentCountry to row.country (e.g. Canada) and start the count again
                 */

                // Once it doesn't equal then we've reached the end of the group so
                results.add(new GroupedResult(currentCountry, currentCount));
                currentCountry = row.country;

                // Start count for the new country
                currentCount = 1;
            }
        }
        // Add the last group
        results.add(new GroupedResult(currentCountry, currentCount));

        return results;
    }

    public static void main(String[] args) {
        // Data has to be sorted before entering the GroupAggregate
        List<Row> sortedData = List.of(
                new Row("USA"),
                new Row("USA"),
                new Row("Canada"),
                new Row("Canada"),
                new Row("Canada"),
                new Row("UK"),
                new Row("UK")
        );

        List<GroupedResult> groupedCounts = groupAndCount(sortedData);
        groupedCounts.forEach(System.out::println);
    }
}