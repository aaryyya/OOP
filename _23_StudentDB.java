import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Admin {
    private List<Student> students;

    public Admin() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Error: Student with ID " + student.getId() + " already exists.");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    public void updateStudent(int id, String name, int age, String gender, String grade, String contactInfo) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setGender(gender);
                student.setGrade(grade);
                student.setContactInfo(contactInfo);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }

    public void searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Error: Student with name " + name + " not found.");
    }

    public void searchStudentByGrade(String grade) {
        for (Student student : students) {
            if (student.getGrade().equalsIgnoreCase(grade)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Error: Student with grade " + grade + " not found.");
    }
}


 class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String contactInfo;

    public Student(int id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", gender='" + gender + '\'' +
               ", grade='" + grade + '\'' +
               ", contactInfo='" + contactInfo + '\'' +
               '}';
    }
}


public class _23_StudentDB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        String adminUsername = "admin";
        String adminPassword = "password";

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!username.equals(adminUsername) || !password.equals(adminPassword)) {
            System.out.println("Invalid login credentials.");
            return;
        }

        while (true) {
            System.out.println("\nStudent Database Management System:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student by ID");
            System.out.println("3. Update student information");
            System.out.println("4. Display all students");
            System.out.println("5. Search for a student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter student gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter student contact information: ");
                    String contactInfo = scanner.nextLine();
                    Student newStudent = new Student(id, name, age, gender, grade, contactInfo);
                    admin.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    admin.removeStudent(removeId);
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new student gender: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter new student grade: ");
                    String newGrade = scanner.nextLine();
                    System.out.print("Enter new student contact information: ");
                    String newContactInfo = scanner.nextLine();
                    admin.updateStudent(updateId, newName, newAge, newGender, newGrade, newContactInfo);
                    break;
                case 4:
                    admin.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Search by: 1. ID, 2. Name, 3. Grade");
                    int searchChoice = Integer.parseInt(scanner.nextLine());
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter student ID to search: ");
                            int searchId = Integer.parseInt(scanner.nextLine());
                            admin.searchStudentById(searchId);
                            break;
                        case 2:
                            System.out.print("Enter student name to search: ");
                            String searchName = scanner.nextLine();
                            admin.searchStudentByName(searchName);
                            break;
                        case 3:
                            System.out.print("Enter student grade to search: ");
                            String searchGrade = scanner.nextLine();
                            admin.searchStudentByGrade(searchGrade);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
