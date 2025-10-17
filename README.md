# Satya_S89_Attendance_management_project

AttendanceSystem/

## Part 1 Summary
- Project setup and orientation.
- Created initial folder structure and base files.
- Verified Java environment and basic compilation.

## Part 2 Summary
- Implemented basic `Student` and `Course` classes.
- Added methods for displaying details.
- Demonstrated object creation and method usage in `Main.java`.

## Part 3 Summary
- Implemented constructors for `Student` and `Course` classes.
- Automatic unique ID generation for students and courses using static variables.
- Demonstrated auto-ID by creating multiple instances in `Main.java`.

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters (e.g., `student1.getStudentId()`) when creating records.

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

## Part 6: Data Storage with Interface and File Output
- Added `Storable` interface with `toDataString()` for data serialization.
- Implemented `Storable` in `Student`, `Course`, and `AttendanceRecord`.
- Created `FileStorageService` to save lists of objects to text files.
- Updated `Main.java` to demonstrate saving students, courses, and attendance records to `students.txt`, `courses.txt`, and `attendance_log.txt`.

## Part 7: Polymorphism & Enhanced AttendanceRecord with Object References
- Modified `AttendanceRecord` to use `Student` and `Course` object references instead of primitive IDs.
- Enhanced `displayRecord()` method to show rich information using `student.getName()`, `course.getCourseName()`, etc.
- Added `displaySchoolDirectory()` method in `Main.java` demonstrating polymorphic calls to `displayDetails()`.
- Created mixed `ArrayList<Person>` containing Students, Teachers, and Staff objects.
- Implemented proper filtering using `instanceof` when saving Student data to files.
- Maintained backward compatibility with file storage while providing enhanced object composition.

## Part 8: AttendanceService with Method Overloading
- Created `AttendanceService` class to manage attendance operations with encapsulated attendance log.
- Implemented overloaded `markAttendance()` methods accepting either object references or IDs with lookup functionality.
- Added helper methods `findStudentById()` and `findCourseById()` for ID-based lookups.
- Implemented overloaded `displayAttendanceLog()` methods for all records, student-specific, and course-specific filtering.
- Integrated `FileStorageService` for centralized attendance data persistence.
- Demonstrated method overloading and service-oriented architecture in `Main.java`.

## How to Run

1. Navigate to the project root directory.
2. Compile: 
   ```sh
   javac src/com/school/*.java
   ```
   (or list individual files including `AttendanceRecord.java`)
3. Run: 
   ```sh
   java -cp src com.school.Main
   ```
4. Check output files: `students.txt`, `courses.txt`, `attendance_log.txt` in your project root.

## Project Structure

```
Attendance_management_project/
├── src/
│   └── com/
│       └── school/
│           ├── Student.java
│           ├── Course.java
│           ├── AttendanceRecord.java
│           ├── Person.java
│           ├── Teacher.java
│           ├── Staff.java
│           ├── Storable.java
│           ├── FileStorageService.java
│           ├── AttendanceService.java
│           └── Main.java
└── README.md
```

## Notes

- Ensure you have Java installed (`java -version`).
- All source files are in `src/com/school/`.
- Output will display registered students, available courses, and attendance records with enhanced polymorphic behavior.