import java.util.*;

abstract class Employee {
    protected String employeeID;
    protected String name;

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();
    public abstract String evaluatePerformance();
    
    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + name;
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private int performanceRating;

    public FullTimeEmployee(String employeeID, String name, double monthlySalary, int performanceRating) {
        super(employeeID, name);
        this.monthlySalary = monthlySalary;
        this.performanceRating = performanceRating;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String evaluatePerformance() {
        return "Performance Rating: " + performanceRating + " out of 5";
    }

    @Override
    public String toString() {
        return super.toString() + ", Monthly Salary: $" + monthlySalary + ", Performance Rating: " + performanceRating;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    private int overtimeHours;

    public PartTimeEmployee(String employeeID, String name, double hourlyRate, int hoursWorked, int overtimeHours) {
        super(employeeID, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return (hourlyRate * hoursWorked) + (1.5 * hourlyRate * overtimeHours);
    }

    @Override
    public String evaluatePerformance() {
        return "Performance evaluation not applicable for part-time employees.";
    }

    @Override
    public String toString() {
        return super.toString() + ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked + ", Overtime Hours: " + overtimeHours;
    }
}

public class _15_EmployeeManagementSystem {
    private static Map<String, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Register Full-Time Employee");
            System.out.println("2. Register Part-Time Employee");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Evaluate Performance");
            System.out.println("5. Display Employee Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerFullTimeEmployee(scanner);
                    break;
                case 2:
                    registerPartTimeEmployee(scanner);
                    break;
                case 3:
                    calculateSalary(scanner);
                    break;
                case 4:
                    evaluatePerformance(scanner);
                    break;
                case 5:
                    displayEmployeeDetails(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Register a full-time employee
    private static void registerFullTimeEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Performance Rating (1-5): ");
        int performanceRating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employee = new FullTimeEmployee(employeeID, name, monthlySalary, performanceRating);
        employees.put(employeeID, employee);
        System.out.println("Full-Time Employee registered successfully.");
    }

    // Register a part-time employee
    private static void registerPartTimeEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Enter Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        System.out.print("Enter Overtime Hours: ");
        int overtimeHours = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employee = new PartTimeEmployee(employeeID, name, hourlyRate, hoursWorked, overtimeHours);
        employees.put(employeeID, employee);
        System.out.println("Part-Time Employee registered successfully.");
    }

    // Calculate salary for an employee
    private static void calculateSalary(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        Employee employee = employees.get(employeeID);

        if (employee != null) {
            System.out.println("Salary for " + employee.getName() + ": $" + employee.calculateSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Evaluate performance for an employee
    private static void evaluatePerformance(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        Employee employee = employees.get(employeeID);

        if (employee != null) {
            System.out.println(employee.evaluatePerformance());
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display employee details
    private static void displayEmployeeDetails(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        Employee employee = employees.get(employeeID);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
