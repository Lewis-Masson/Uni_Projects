package ClassDesign;

/**
 * @author Lewis Masson
 */
public class VehicleClassDesign {

    public static void main(String[] args) {

    }

}

// enum set to determine gearbox type - only 2 options for the user.
enum GearboxType {
    MANUAL, AUTOMATIC
}

// Vehicle class
class Vehicle {

    String make;
    String model;
    int year;
    GearboxType gearbox;
    String colour;
    int mileage;
    String vin;
    String bodyType;

    public Vehicle(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.gearbox = parseGearbox(gearbox);
        this.colour = colour;
        this.mileage = mileage;
        this.vin = vin;
        this.bodyType = bodyType;

    }

    // Vehcile constructor
    public Vehicle(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        this(make, model, year, gearbox, colour, mileage, vin, null);
    }
// Gearbox Type set private so user can only enter MAN/AUTO, throw exception also included if MAN/AUTO incorrectly entered

    private GearboxType parseGearbox(String gearbox) {
        switch (gearbox.toUpperCase()) {
            case "MANUAL":
                return GearboxType.MANUAL;
            case "AUTOMATIC":
                return GearboxType.AUTOMATIC;
            default:
                throw new IllegalArgumentException("Invalid gearbox type: " + gearbox);
        }
    }

    @Override
    public String toString() {
        return "Make: " + make + "\n"
                + "Model: " + model + "\n"
                + "Year: " + year + "\n"
                + "Gearbox: " + gearbox + "\n"
                + "Colour: " + colour + "\n"
                + "Mileage: " + mileage + "\n"
                + "VIN: " + vin + "\n";
    }

}

// Start of Subclasses
class Car extends Vehicle {

    boolean satNav;
    boolean parkingSensors;
    boolean towBar;
    boolean roofRack;

    public Car(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType,
            boolean satNav, boolean parkingSensors, boolean towBar, boolean roofRack) {
        super(make, model, year, gearbox, colour, mileage, vin, bodyType);
        this.satNav = satNav;
        this.parkingSensors = parkingSensors;
        this.towBar = towBar;
        this.roofRack = roofRack;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Sat Nav: " + satNav + "\n"
                + "Parking Sensors: " + parkingSensors + "\n"
                + "Tow Bar: " + towBar + "\n"
                + "Roof Rack: " + roofRack + "\n";
    }

    public Car(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType) {
        super(make, model, year, gearbox, colour, mileage, vin, bodyType);
    }

    public void addSatNav() {
        satNav = true;
    }

    public void addParkingSensors() {
        parkingSensors = true;
    }

    public void addTowBar() {
        towBar = true;
    }

    public void addRoofRack() {
        roofRack = true;
    }

    public boolean hasSatNav() {
        return satNav;
    }

    public boolean hasParkingSensors() {
        return parkingSensors;
    }

    public boolean hasTowBar() {
        return towBar;
    }

    public boolean hasRoofRack() {
        return roofRack;
    }

    public void setSatNav(boolean satNav) {
        this.satNav = satNav;
    }

    public void setParkingSensors(boolean parkingSensors) {
        this.parkingSensors = parkingSensors;
    }

    public void setTowBar(boolean towBar) {
        this.towBar = towBar;
    }

    public void setRoofRack(boolean roofRack) {
        this.roofRack = roofRack;
    }

}

class SUV extends Car {

    boolean allWheelDrive;

    public SUV(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean allWheelDrive) {
        super(make, model, year, gearbox, colour, mileage, vin, "SUV");
        this.allWheelDrive = allWheelDrive;
    }

// methods to set additional features specific to SUV
    public void addAllWheelDrive() {
        allWheelDrive = true;
    }
// toString to allow the print out of all wheel drive

    @Override
    public String toString() {
        return super.toString()
                + "All-Wheel Drive: " + allWheelDrive + "\n";
    }
}

class Estate extends Car {

    private boolean thirdRowSeat;

    public Estate(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean thirdRowSeat) {
        super(make, model, year, gearbox, colour, mileage, vin, "Estate");
        this.thirdRowSeat = thirdRowSeat;
    }

    // Getter and setter methods for thirdRowSeat
    public boolean hasThirdRowSeat() {
        return thirdRowSeat;
    }

    public void setThirdRowSeat(boolean thirdRowSeat) {
        this.thirdRowSeat = thirdRowSeat;
    }

    // Add methods to set additional features specific to Estate
    public void addThirdRowSeat() {
        this.thirdRowSeat = true;
    }
// toString to allow the print out of third row seat

    @Override
    public String toString() {
        return super.toString()
                + "Third Row Seat: " + thirdRowSeat;

    }

}

class Hatchback extends Vehicle {

    public Hatchback(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        super(make, model, year, gearbox, colour, mileage, vin, "Hatchback");
    }

}

class Motorbike extends Vehicle {

    private boolean luggageBox;

    public Motorbike(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean luggageBox) {
        super(make, model, year, gearbox, colour, mileage, vin, "MOTORBIKE");
        this.luggageBox = luggageBox;
    }

    public boolean hasLuggageBox() {
        return luggageBox;
    }

    public void addLuggageBox() {
        luggageBox = true;
    }

    public void removeLuggageBox() {
        luggageBox = false;
    }

    @Override
    public String toString() {
        return super.toString() + "Luggage Box: " + luggageBox;
    }
}
