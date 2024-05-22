import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
}
 abstract class Vehicle implements Rentable {
    protected String model;
    protected String brand;
    protected boolean isRented;

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " rented successfully.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " returned successfully.");
        } else {
            System.out.println(model + " is not rented.");
        }
    }

    public boolean isRented() {
        return isRented;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
               "model='" + model + '\'' +
               ", brand='" + brand + '\'' +
               ", isRented=" + isRented +
               '}';
    }
}
 class Car extends Vehicle {
    private double dailyRate;

    public Car(String model, String brand, double dailyRate) {
        super(model, brand);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}
 class Motorcycle extends Vehicle {
    private double dailyRate;

    public Motorcycle(String model, String brand, double dailyRate) {
        super(model, brand);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}
 class Bicycle extends Vehicle {
    private double hourlyRate;

    public Bicycle(String model, String brand, double hourlyRate) {
        super(model, brand);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateRentalCost(int hours) {
        return hours * hourlyRate;
    }
}


 class RentalManager {
    private List<Vehicle> vehicles;

    public RentalManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle.getModel() + " added to the system.");
    }

    public void rentVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                vehicle.rent();
                return;
            }
        }
        System.out.println("Vehicle with model " + model + " not found.");
    }

    public void returnVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                vehicle.returnVehicle();
                return;
            }
        }
        System.out.println("Vehicle with model " + model + " not found.");
    }

    public void calculateRentalCost(String model, int duration) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                double cost = vehicle.calculateRentalCost(duration);
                System.out.println("Rental cost for " + duration + " days/hours is: " + cost);
                return;
            }
        }
        System.out.println("Vehicle with model " + model + " not found.");
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isRented()) {
                System.out.println(vehicle);
            }
        }
    }
}
public class _24_Rentals {
    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();
        Scanner scanner = new Scanner(System.in);

        // Add some vehicles
        rentalManager.addVehicle(new Car("Model S", "Tesla", 100));
        rentalManager.addVehicle(new Motorcycle("CBR500R", "Honda", 50));
        rentalManager.addVehicle(new Bicycle("Mountain Bike", "Giant", 5));

        while (true) {
            System.out.println("\nVehicle Rental System:");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. Calculate rental cost");
            System.out.println("4. Display available vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle model to rent: ");
                    String rentModel = scanner.nextLine();
                    rentalManager.rentVehicle(rentModel);
                    break;
                case 2:
                    System.out.print("Enter vehicle model to return: ");
                    String returnModel = scanner.nextLine();
                    rentalManager.returnVehicle(returnModel);
                    break;
                case 3:
                    System.out.print("Enter vehicle model to calculate cost: ");
                    String costModel = scanner.nextLine();
                    System.out.print("Enter duration (days/hours): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    rentalManager.calculateRentalCost(costModel, duration);
                    break;
                case 4:
                    rentalManager.displayAvailableVehicles();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
