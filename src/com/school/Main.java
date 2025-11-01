package com.school;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        for (Person person : regService.getAllPeople()) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // Register
        regService.registerStudent("Alice Wonderland", "Grade 10");
        regService.registerStudent("Bob the builder", "Grade 11");
        regService.registerStudent("Charlie Chaplin", "Grade 12");

        // Register teachers
        regService.registerTeacher("Dr. Smith", "Mathematics");
        regService.registerTeacher("Ms. Johnson", "Computer Science");

        // Register staff
        regService.registerStaff("John Admin", "Administrator");
        regService.registerStaff("Jane Security", "Security Guard");

        // Create courses
        regService.createCourse("Intro to programming");
        regService.createCourse("Linear Algebra");

        System.out.println("\n--- School Directory ---");
        displaySchoolDirectory(regService);

        System.out.println("\n--- Marking Attendance ---");
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 102, "Absent");
        attendanceService.markAttendance(3, 101, "Present");

        System.out.println("\n--- All Attendance Records ---");
        attendanceService.displayAttendanceLog();

        // Save all data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 9: SOLID Service Layer Implementation Complete");
    }
}