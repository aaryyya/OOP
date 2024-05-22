public class _2_Employee_Manager {
    public static void main(String[] args) {
        // Create a full-time employee
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", "FT123", 30, 5000, 1000);
        // Create a part-time employee
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Smith", "PT456", 20, 80, 25);

        // Print their monthly salaries
        fullTimeEmployee.printSalary();;
        partTimeEmployee.printSalary();;
    }
}

// Base class for Employee
class Employee {
    private String name;
    private String employeeID;
    private double hourlyRate;

    public Employee(String name, String employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}

// Derived class for Full-Time Employee
class FullTimeEmployee extends Employee {
    private double salary;
    private double benefits;

    public FullTimeEmployee(String name, String employeeID, double hourlyRate, double salary, double benefits) {
        super(name, employeeID, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double calculateMonthlySalary() {
        return salary + benefits;
    }

    public void printSalary() {
        System.out.println("Full-Time Employee ID: " + getEmployeeID() + ", Name: " + getName() + ", Monthly Salary: $" + calculateMonthlySalary());
    }
}

// Derived class for Part-Time Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, String employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double calculateMonthlySalary() {
        double regularPay = getHourlyRate() * hoursWorked;
        double overtimePay = (hoursWorked > 160) ? (hoursWorked - 160) * overtimeRate : 0;
        return regularPay + overtimePay;
    }

    public void printSalary() {
        System.out.println("Part-Time Employee ID: " + getEmployeeID() + ", Name: " + getName() + ", Monthly Salary: $" + calculateMonthlySalary());
    }
}

