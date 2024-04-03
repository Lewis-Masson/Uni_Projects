/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDesign;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleManager {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int initialCapacity = 5;
            Vehicle[] vehicles = new Vehicle[initialCapacity];
            int numberOfVehicles = 0;
            boolean addMoreVehicles = true;

            while (addMoreVehicles) {
                // Get vehicle details from the user
                Vehicle newVehicle = createVehicle(scanner);

                // Check if the array is full and resize if necessary
                if (numberOfVehicles == vehicles.length) {
                    vehicles = resizeArray(vehicles);
                }

                // Add the new vehicle to the array
                vehicles[numberOfVehicles] = newVehicle;
                numberOfVehicles++;

                // Ask the user if they want to add more vehicles
                System.out.print("Do you want to add another vehicle? (yes/no): ");
                String response = scanner.next().toLowerCase();
                addMoreVehicles = response.equals("yes");
            }

            // Display details of all vehicles
            displayAllVehicles(vehicles, numberOfVehicles);
        }
    }

    // Method to create a new Vehicle object based on user input
    private static Vehicle createVehicle(Scanner scanner) {
        System.out.println("Enter vehicle details:");

        System.out.print("Make: ");
        String make = scanner.next();

        System.out.print("Model: ");
        String model = scanner.next();
//Looped so that incorrect body type cannot be input
        String bodyType = "";
        do {
            System.out.print("Body Type (SALOON/ESTATE/SUV/HATCHBACK/MOTORBIKE): ");
            bodyType = scanner.next().toUpperCase();
        } while (!validVehicleType(bodyType));

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Gearbox (MANUAL/AUTOMATIC): ");
        String gearbox = scanner.next().toUpperCase();

        System.out.print("Colour: ");
        String colour = scanner.next();

        System.out.print("Mileage: ");
        int mileage = scanner.nextInt();

        System.out.print("VIN: ");
        String vin = scanner.next();

        Vehicle newVehicle;

        switch (bodyType) {
            case "SUV": {
                newVehicle = createSUV(scanner, make, model, year, gearbox, colour, mileage, vin);
                break;
            }
            case "ESTATE": {
                newVehicle = createEstate(scanner, make, model, year, gearbox, colour, mileage, vin);
                break;
            }
            case "MOTORBIKE": {
                newVehicle = createMotorbike(scanner, make, model, year, gearbox, colour, mileage, vin);
                break;
            }
            case "HATCHBACK":
            case "SALOON": {
                newVehicle = createCar(scanner, make, model, year, gearbox, colour, mileage, vin, bodyType);
                break;
            }
            default:
                newVehicle = new Vehicle(make, model, year, gearbox, colour, mileage, vin);
                break;
        }

        return newVehicle;
    }

    private static SUV createSUV(Scanner scanner, String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        System.out.print("All-Wheel Drive (true/false): ");
        boolean allWheelDrive = scanner.nextBoolean();
        scanner.nextLine();
        SUV suv = new SUV(make, model, year, gearbox, colour, mileage, vin, allWheelDrive);

        // Extra options for SUV
        System.out.print("Add Tow Bar? (true/false): ");
        suv.setTowBar(scanner.nextBoolean());
        System.out.print("Add Roof Rack? (true/false): ");
        suv.setRoofRack(scanner.nextBoolean());
        System.out.print("Add Sat Nav? (true/false): ");
        suv.setSatNav(scanner.nextBoolean());
        System.out.print("Add Parking Sensors? (true/false): ");
        suv.setParkingSensors(scanner.nextBoolean());

        return suv;
    }

    private static Estate createEstate(Scanner scanner, String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        System.out.print("Add Third Row Seat? (true/false): ");
        boolean thirdRowSeat = scanner.nextBoolean();
        scanner.nextLine();
        Estate estate = new Estate(make, model, year, gearbox, colour, mileage, vin, thirdRowSeat);

        // Extra options for Estate
        System.out.print("Add Tow Bar? (true/false): ");
        estate.setTowBar(scanner.nextBoolean());
        System.out.print("Add Roof Rack? (true/false): ");
        estate.setRoofRack(scanner.nextBoolean());
        System.out.print("Add Sat Nav? (true/false): ");
        estate.setSatNav(scanner.nextBoolean());
        System.out.print("Add Parking Sensors? (true/false): ");
        estate.setParkingSensors(scanner.nextBoolean());

        return estate;
    }
// Options to add remove and do nothing for the luggage box

    private static Motorbike createMotorbike(Scanner scanner, String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
    System.out.print("Does the motorbike have a luggage box? (true/false): ");
    boolean hasLuggageBox = scanner.nextBoolean();

    Motorbike motorbike = new Motorbike(make, model, year, gearbox, colour, mileage, vin, hasLuggageBox);

    System.out.print("Do you want to add or remove the luggage box? (add/remove/none): ");
    String action = scanner.next().toLowerCase();

    switch (action) {
        case "add":
            motorbike.addLuggageBox();
            break;
        case "remove":
            motorbike.removeLuggageBox();
            break;
        case "none":
            // Do nothing
            break;
        default:
            System.out.println("Invalid action. Luggage box remains unchanged.");
    }

    return motorbike;
}

    private static boolean validVehicleType(String vehicleType) {
        switch (vehicleType) {
            case "SALOON":
            case "ESTATE":
            case "SUV":
            case "HATCHBACK":
            case "MOTORBIKE":
                return true;
            default:
                return false;
        }
    }

    // Method to create a new Car object based on user input
    private static Car createCar(Scanner scanner, String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType) {
        Car newCar = new Car(make, model, year, gearbox, colour, mileage, vin, bodyType);

        return newCar;
    }

    // Method to resize the array
    private static Vehicle[] resizeArray(Vehicle[] oldArray) {
        int newCapacity = oldArray.length * 2;
        return Arrays.copyOf(oldArray, newCapacity);
    }

    // Method to display details of all vehicles
    private static void displayAllVehicles(Vehicle[] vehicles, int numberOfVehicles) {
        System.out.println("Details of all vehicles:");

        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println("Vehicle " + (i + 1) + ":\n " + vehicles[i]);
        }
    }
}
