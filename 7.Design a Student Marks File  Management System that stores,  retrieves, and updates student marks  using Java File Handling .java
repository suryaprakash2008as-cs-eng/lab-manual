import java.io.*;
import java.util.*;


class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + marks;
    }
}

public class Main {
    private static final String FILE_NAME = "students.txt";

    // Save student records to file
    public static void saveStudents(List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        }
        System.out.println("Student records saved successfully.");
    }

    // Read student records from file
    public static List<Student> readStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int rollNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                int marks = Integer.parseInt(parts[2]);
                students.add(new Student(rollNo, name, marks));
            }
        }
        return students;
    }

    // Search student by roll number
    public static Student searchStudent(int rollNo) throws IOException {
        List<Student> students = readStudents();
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                return s;
            }
        }
        return null;
    }

    // Update student marks
    public static void updateMarks(int rollNo, int newMarks) throws IOException {
        List<Student> students = readStudents();
        boolean updated = false;
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                s.marks = newMarks;
                updated = true;
                break;
            }
        }
        if (updated) {
            saveStudents(students);
            System.out.println("Marks updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for Student " + i);
            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();
            students.add(new Student(rollNo, name, marks));
        }

        saveStudents(students);

        System.out.println("\n------ Student Records ------");
        for (Student s : readStudents()) {
            System.out.println(s);
        }

        System.out.print("\nEnter Roll Number to Search: ");
        int searchRoll = sc.nextInt();
        Student found = searchStudent(searchRoll);
        if (found != null) {
            System.out.println("\nStudent Found");
            System.out.println("Roll No: " + found.rollNo);
            System.out.println("Name: " + found.name);
            System.out.println("Marks: " + found.marks);
        } else {
            System.out.println("Student not found.");
        }

        System.out.print("\nEnter Roll Number to Update Marks: ");
        int updateRoll = sc.nextInt();
        System.out.print("Enter new marks: ");
        int newMarks = sc.nextInt();
        updateMarks(updateRoll, newMarks);

        sc.close();
    }
}
