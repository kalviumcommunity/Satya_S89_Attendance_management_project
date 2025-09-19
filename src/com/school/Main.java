package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        Staff staff1 = new Staff("Mrs. Johnson", "Administrator");

        System.out.println("\nPerson Details:");
        student1.displayDetails();
        teacher1.displayDetails();
        staff1.displayDetails();

        Course course1 = new Course("Intro to programming");
        Course course2 = new Course("Linear Algebra");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(student1.getId(), course2.getCourseId(), "Late")); // Invalid status

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nSession 5: Person Hierarchy Complete");
    }
}