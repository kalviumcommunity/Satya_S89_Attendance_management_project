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

        ArrayList<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("Alice Wonderland", "Grade 10"));
        allStudents.add(new Student("Bob the builder", "Grade 11"));
        allStudents.add(new Student("Charlie Chaplin", "Grade 12"));

        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Computer Science");

        Staff staff1 = new Staff("John Admin", "Administrator");
        Staff staff2 = new Staff("Jane Security", "Security Guard");

        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(allStudents);
        schoolPeople.add(teacher1);
        schoolPeople.add(teacher2);
        schoolPeople.add(staff1);
        schoolPeople.add(staff2);

        System.out.println("\n--- School Directory ---");
        displaySchoolDirectory(schoolPeople);

        ArrayList<Course> allCourses = new ArrayList<>();
        allCourses.add(new Course("Intro to programming"));
        allCourses.add(new Course("Linear Algebra"));

        System.out.println("\nRegistered Students:");
        for (Student s : allStudents) s.displayDetails();

        System.out.println("\nAvailable Courses:");
        for (Course c : allCourses) c.displayDetails();

        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        System.out.println("\n--- Marking Attendance ---");
        attendanceService.markAttendance(allStudents.get(0), allCourses.get(0), "Present");
        attendanceService.markAttendance(allStudents.get(1), allCourses.get(1), "Absent");
        attendanceService.markAttendance(2, 101, "Present", allStudents, allCourses);
        attendanceService.markAttendance(3, 102, "Late", allStudents, allCourses);

        System.out.println("\n--- All Attendance Records ---");
        attendanceService.displayAttendanceLog();

        System.out.println("\n--- Attendance for Alice ---");
        attendanceService.displayAttendanceLog(allStudents.get(0));

        System.out.println("\n--- Attendance for Intro to programming ---");
        attendanceService.displayAttendanceLog(allCourses.get(0));

        attendanceService.saveAttendanceData();

        List<Student> studentsForSaving = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                studentsForSaving.add((Student) person);
            }
        }

        storage.saveData(studentsForSaving, "students.txt");
        storage.saveData(allCourses, "courses.txt");

        System.out.println("\nSession 8: AttendanceService with Method Overloading Complete");
    }
}
