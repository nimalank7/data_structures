package org.example.GroupAggregate;

class GroupedResult {
    String country;
    int count;

    public GroupedResult(String country, int count) {
        this.country = country;
        this.count = count;
    }

    @Override
    public String toString() {
        return "GroupAggregate.GroupedResult{country='" + country + ", count=" + count + "}";
    }
}
