package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "Grade 10"));
        students.add(new Student("Bob the builder", "Grade 11"));
        students.add(new Student("Charlie Chaplin", "Grade 12"));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Intro to programming"));
        courses.add(new Course("Linear Algebra"));

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        records.add(new AttendanceRecord(students.get(2).getId(), courses.get(0).getCourseId(), "Late")); // Invalid

        System.out.println("\nRegistered Students:");
        for (Student s : students) s.displayDetails();

        System.out.println("\nAvailable Courses:");
        for (Course c : courses) c.displayDetails();

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord r : records) r.displayRecord();

        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nSession 6: Data Storage Complete");
    }
}