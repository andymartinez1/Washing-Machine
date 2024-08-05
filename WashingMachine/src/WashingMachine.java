public class WashingMachine {
    private boolean hasSoap; // true when soap has been added
    private boolean running; // true when machine is running a load
    private double currentLoad; // amount of laundry in the machine
    private final double capacity; // max load of the machine cubic feet
    private String id; // testing tag for the washing machine
    private String warnings;

    // Makes a new WashingMachine instance and initializes it state
    public WashingMachine(String id, double maxCapacity) {
        hasSoap = running = false; // inititially off
        currentLoad = 0; // initially empty
        capacity = maxCapacity; // cubic feet laundry allowed for this machine
        this.id = id;
        warnings = "";
    }

    // Reports the clothing load amount of the washing machine
    public double CurrentLoad() {
        return currentLoad;
    }

    // Reports the running, soap and load status of the washing machine
    public String ReportStatus() {
        String status = "ID=" + id + "     Running: " + running + "     Soap: " + hasSoap + "     Laundry: "
                + currentLoad;
        if (warnings.length() > 0) {
            status = status + "     Warnings" + warnings;
        }
        return status;
    }

    /*
     * Adds clothing to the washing machine - amount in cubic feet
     * The request must not exceed capacity
     * The washer must be off to add clothes
     */
    public void AddClothes(double amount) {
        double request = currentLoad + amount;

        if (!running) {

            if (request <= capacity) {
                currentLoad = request;
            } else {
                warnings = warnings + ":CAPACITY OVERLOAD";
            }
        } else {
            warnings = warnings + ":DOOR LOCKED";
        }
    }

    // Adds soap to the washing machine - amount unspecified
    public void AddSoap() {
        if (!hasSoap) {
            hasSoap = true;
        } else {
            warnings = warnings + ":SOAP OVERLOAD";
        }
    }

    // Start button - to start the operation of the washing machine
    public void StartWasher() {
        if (running == false) {
            running = true;
        } else {
            warnings = warnings + ":ALREADY RUNNING";
        }
    }

    // Stop button - to halt the operation of the washing machine
    public void StopWasher() {
        if (running == true) {
            running = false;
            hasSoap = false; // once the washer is stopped, soap is considered gone :-)
        } else {
            warnings = warnings + ":ALREADY STOPPED";

        }
    }
}
