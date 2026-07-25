import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "  " + name + "  " + dept + "  " + salary;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Rahul", "CSE", 55000.0),
            new Employee(102, "Sneha", "ECE", 62000.0),
            new Employee(103, "Kiran", "CSE", 48000.0),
            new Employee(104, "Divya", "MECH", 51000.0),
            new Employee(105, "Arjun", "ECE", 70000.0)
        );

        System.out.println("---- All Employees ----");
        employees.forEach(System.out::println);

        System.out.println("\n---- Salary Above 50000 (High to Low) ----");
        employees.stream()
                 .filter(e -> e.salary > 50000)
                 .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                 .forEach(e -> System.out.println(e.name + " -> " + e.salary));

        System.out.println("\n---- Employee Names ----");
        List<String> names = employees.stream()
                                      .map(e -> e.name)
                                      .collect(Collectors.toList());
        System.out.println(names);

        System.out.println("\n---- Employees Grouped by Department ----");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));
        grouped.forEach((dept, list) -> {
            List<String> deptNames = list.stream().map(e -> e.name).collect(Collectors.toList());
            System.out.println(dept + " : " + deptNames);
        });

        System.out.println("\n---- Average Salary per Department ----");
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.averagingDouble(e -> e.salary)));
        avgSalary.forEach((dept, avg) -> System.out.printf("%s : %.2f%n", dept, avg));

        double totalSalary = employees.stream().mapToDouble(e -> e.salary).sum();
        System.out.println("\nTotal Salary Paid : " + totalSalary);

        long cseCount = employees.stream().filter(e -> e.dept.equals("CSE")).count();
        System.out.println("Number of CSE Employees : " + cseCount);

        Employee highestPaid = employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .orElse(null);
        if (highestPaid != null) {
            System.out.println("Highest Paid : " + highestPaid.name + " (" + highestPaid.salary + ")");
        }
    }
}
