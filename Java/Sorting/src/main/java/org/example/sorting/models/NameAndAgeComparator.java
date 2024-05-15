package org.example.sorting.models;

import java.util.Comparator;

public class NameAndAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getName().equals(o2.getName())) {
            return Integer.compare(o1.getAge(), o2.getAge());
        } else if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
