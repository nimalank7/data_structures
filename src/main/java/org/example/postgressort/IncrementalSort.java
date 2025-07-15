package org.example.postgressort;

import java.util.*;

public class IncrementalSort {

    public static List<Employee> incrementalSort(List<Employee> input) {

        List<Employee> result = new ArrayList<>();
        List<Employee> currentGroup = new ArrayList<>();

        // Start with the first employee as reference
        Employee previousEmployee = input.get(0);
        currentGroup.add(previousEmployee);

        for (int i = 1; i < input.size(); i++) {
            Employee currentEmployee = input.get(i);

            // If department and team are the same then add to the current group
            if (currentEmployee.department.equals(previousEmployee.department) && currentEmployee.team.equals(previousEmployee.team)) {
                currentGroup.add(currentEmployee);
            } else {
                /*
                else block is triggered once we hit an employee that isn't of the same department and name.
                That is the signal to sort the current block by the name. So once we hit 'Dave' then we sort the current
                group which is Sales-A.
                 */

                currentGroup.sort(Comparator.comparing(emp -> emp.name));

                // Add to the result group (e.g. Sales-A)
                result.addAll(currentGroup);

                // Clear the current group to begin the next group (e.g. Sales-B)
                currentGroup.clear();
                currentGroup.add(currentEmployee);
            }
            previousEmployee = currentEmployee;
        }

        /*
        This sorts the final group (e.g. Tech-X as there isn't a further employee to trigger the else block so
        the loop exits after the if block.
         */
        currentGroup.sort(Comparator.comparing(emp -> emp.name));
        result.addAll(currentGroup);

        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Sales", "A", "Carol"),
                new Employee("Sales", "A", "Alice"),
                new Employee("Sales", "B", "Dave"),
                new Employee("Sales", "B", "Bob"),
                new Employee("Tech", "X", "Zoe"),
                new Employee("Tech", "X", "Anna")
        );

        // NOTE: input must be pre-sorted by department, team
        employees.sort(Comparator
                .comparing((Employee e) -> e.department)
                .thenComparing(e -> e.team));

        List<Employee> sorted = incrementalSort(employees);

        System.out.println("Incrementally sorted employees:");
        for (Employee e : sorted) {
            System.out.println(e);
        }
    }
}
