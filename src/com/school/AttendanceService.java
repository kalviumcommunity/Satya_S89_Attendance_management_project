package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        }
    }

    private Student findStudentById(int studentId, List<Student> allStudents) {
        for (Student student : allStudents) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseById(int courseId, List<Course> allCourses) {
        for (Course course : allCourses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("All Attendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("Attendance Records for " + student.getName() + ":");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().getId() == student.getId()) {
                record.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("Attendance Records for " + course.getCourseName() + ":");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().getCourseId() == course.getCourseId()) {
                record.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}