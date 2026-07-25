import java.util.*;

class Student {
    int roll;
    String name;
    double percentage;

    Student(int roll, String name, double percentage) {
        this.roll = roll;
        this.name = name;
        this.percentage = percentage;
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        // ArrayList
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(101, "Rahul", 88.5));
        list.add(new Student(102, "Sneha", 91.2));
        list.add(new Student(103, "Kiran", 84.8));

        System.out.println("Student Records (ArrayList)\n");
        System.out.println("--------------------------------");
        System.out.println("Roll\tName\tPercentage");
        System.out.println("--------------------------------");

        for (Student s : list) {
            System.out.println(s.roll + "\t" + s.name + "\t" + s.percentage);
        }

        // Search
        int searchRoll = 102;

        System.out.println("\nSearching for Roll No : " + searchRoll);

        for (Student s : list) {
            if (s.roll == searchRoll) {
                System.out.println("\nRecord Found\n");
                System.out.println("Roll No    : " + s.roll);
                System.out.println("Name       : " + s.name);
                System.out.println("Percentage : " + s.percentage);
            }
        }

        // Remove first student
        list.remove(0);

        System.out.println("\nAfter Removing First Student\n");
        System.out.println("--------------------------------");
        System.out.println("Roll\tName\tPercentage");
        System.out.println("--------------------------------");

        for (Student s : list) {
            System.out.println(s.roll + "\t" + s.name + "\t" + s.percentage);
        }

        // HashMap
        HashMap<Integer, Student> map = new HashMap<>();

        map.put(101, new Student(101, "Rahul", 88.5));
        map.put(102, new Student(102, "Sneha", 91.2));
        map.put(103, new Student(103, "Kiran", 84.8));

        System.out.println("\nStudent Records (HashMap)\n");
        System.out.println("--------------------------------");

        for (Integer roll : map.keySet()) {
            Student s = map.get(roll);
            System.out.println(roll + " -> " + s.name + " (" + s.percentage + "%)");
        }
    }
}
