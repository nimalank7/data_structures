package org.example.HashAggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHashAggregate {

    public static List<GroupedResult> groupAndCount(List<Row> rows) {
        /*
        Map of country and count. Hash the country column and increment the count.
         */

        // Temporary hash table to store group keys and their counts
        Map<String, Integer> groupCounts = new HashMap<>();

        // Process each input record
        for (Row row : rows) {
            // Retrieve the country of the current row
            String country = row.country;

            /*
            If the country exists in the map increment the count otherwise
            add it in and set count to 0
             */
            groupCounts.put(country, groupCounts.getOrDefault(country, 0) + 1);
        }

        // Convert the hash table to a list
        List<GroupedResult> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : groupCounts.entrySet()) {
            results.add(new GroupedResult(entry.getKey(), entry.getValue()));
        }

        return results;
    }

    public static void main(String[] args) {
        List<Row> data = List.of(
                new Row("USA"),
                new Row("Canada"),
                new Row("USA"),
                new Row("UK"),
                new Row("Canada"),
                new Row("Canada"),
                new Row("UK")
        );

        List<GroupedResult> groupedCounts = groupAndCount(data);

        /*
        GroupedResult{country=Canada, count =3}
        GroupedResult{country=USA, count =2}
        GroupedResult{country=UK, count =3}
         */
        groupedCounts.forEach(System.out::println);
    }
}
