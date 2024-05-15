package org.example.sorting;

import org.example.sorting.models.Employee;
import org.example.sorting.models.NameAndAgeComparator;
import org.example.sorting.models.NameComparator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SortingApplication {

    public static void main(String[] args) {
		var employees = getEmployees();
		var comparator = new NameAndAgeComparator();
		employees.sort(comparator);

		for (var employee : employees) {
			System.out.println(employee);
		}
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("A", 20, 100));
        employees.add(new Employee("A", 10, 100));
        employees.add(new Employee("B", 10, 150));
        employees.add(new Employee("C", 30, 200));

        return employees;
    }
}
