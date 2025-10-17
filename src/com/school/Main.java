package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "Grade 10"));
        students.add(new Student("Bob the builder", "Grade 11"));
        students.add(new Student("Charlie Chaplin", "Grade 12"));

        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Computer Science");

        Staff staff1 = new Staff("John Admin", "Administrator");
        Staff staff2 = new Staff("Jane Security", "Security Guard");

        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.add(teacher1);
        schoolPeople.add(teacher2);
        schoolPeople.add(staff1);
        schoolPeople.add(staff2);

        System.out.println("\n--- School Directory ---");
        displaySchoolDirectory(schoolPeople);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Intro to programming"));
        courses.add(new Course("Linear Algebra"));

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0), courses.get(0), "Present"));
        records.add(new AttendanceRecord(students.get(1), courses.get(1), "Absent"));
        records.add(new AttendanceRecord(students.get(2), courses.get(0), "Late")); // Invalid

        System.out.println("\nRegistered Students:");
        for (Student s : students) s.displayDetails();

        System.out.println("\nAvailable Courses:");
        for (Course c : courses) c.displayDetails();

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord r : records) r.displayRecord();

        List<Student> studentsForSaving = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                studentsForSaving.add((Student) person);
            }
        }

        FileStorageService storage = new FileStorageService();
        storage.saveData(studentsForSaving, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nSession 7: Polymorphism and Enhanced Records Complete");
    }
}
