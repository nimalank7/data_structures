package org.example.postgres.sort;

public class Employee {
    String department;
    String team;
    String name;

    public Employee(String department, String team, String name) {
        this.department = department;
        this.team = team;
        this.name = name;
    }

    @Override
    public String toString() {
        return department + " | " + team + " | " + name;
    }
}