//SQL
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE student(
    roll INT PRIMARY KEY,
    name VARCHAR(30),
    marks INT
);

import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "");
        while (true) {
            System.out.println("\n1.Insert");
            System.out.println("2.View");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.print("Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Marks: ");
                int marks = sc.nextInt();
                PreparedStatement ps = con.prepareStatement(
                        "insert into student values(?,?,?)");
                ps.setInt(1, roll);
                ps.setString(2, name);
                ps.setInt(3, marks);
                ps.executeUpdate();
                System.out.println("Record Inserted");
            }
            else if (ch == 2) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from student");
                System.out.println("\nRoll\tName\tMarks");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t"
                            + rs.getString(2) + "\t"
                            + rs.getInt(3));
                }
            }
            else if (ch == 3) {
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                System.out.print("New Marks: ");
                int marks = sc.nextInt();
                PreparedStatement ps = con.prepareStatement(
                        "update student set marks=? where roll=?");
                ps.setInt(1, marks);
                ps.setInt(2, roll);
                ps.executeUpdate();
                System.out.println("Record Updated");
            }
            else if (ch == 4) {
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                PreparedStatement ps = con.prepareStatement(
                        "delete from student where roll=?");
                ps.setInt(1, roll);
                ps.executeUpdate();
                System.out.println("Record Deleted");
            }
            else {
                break;
            }
        }
        con.close();
        sc.close();
    }
}
