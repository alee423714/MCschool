package application;
/*
 * Class: CMSC203
 * Instructor: Huseyin Aygun
 * Description: Manages a list of properties, checking for overlaps and plot containment.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Adam Lee
 */
public class ManagementCompany {

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxId;
    private double managementFee;

    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    /**
     * Default constructor. Initializes array and default plot (0,0,10,10).
     */
    public ManagementCompany() {
        this.name = "";
        this.taxId = "";
        this.managementFee = 0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    /**
     * Parameterized constructor.
     * @param name Company name.
     * @param taxId Company tax ID.
     * @param managementFee Management fee percentage.
     */
    public ManagementCompany(String name, String taxId, double managementFee) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    /**
     * Parameterized constructor (with custom plot).
     * @param name Company name.
     * @param taxId Company tax ID.
     * @param managementFee Management fee percentage.
     * @param x x-coordinate of the company plot.
     * @param y y-coordinate of the company plot.
     * @param width width of the company plot.
     * @param depth depth of the company plot.
     */
    public ManagementCompany(String name, String taxId, double managementFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    /**
     * Copy constructor. Creates a deep copy of the company.
     * @param otherCompany The company to copy.
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxId = otherCompany.taxId;
        this.managementFee = otherCompany.managementFee;
        this.plot = new Plot(otherCompany.plot);
        this.numberOfProperties = otherCompany.numberOfProperties;

        // Deep copy of the properties array
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    /**
     * Adds a property to the properties array.
     * @param property The property to add.
     * @return -1 if full, -2 if null, -3 if not encompassed, -4 if overlaps, or array index if success.
     */
    public int addProperty(Property property) {
        if (isPropertiesFull()) {
            return -1; // Array is full
        }
        if (property == null) {
            return -2; // Property is null
        }
        if (!this.plot.encompasses(property.getPlot())) {
            return -3; // Not encompassed by management plot
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Overlaps another property
            }
        }

        // Success
        properties[numberOfProperties] = new Property(property); // Use copy constructor
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    /**
     * Overloaded addProperty. Creates a default plot.
     * @param name Property name.
     * @param city Property city.
     * @param rent Property rent.
     * @param owner Property owner.
     * @return Return code from addProperty(Property p).
     */
    public int addProperty(String name, String city, double rent, String owner) {
        Property p = new Property(name, city, rent, owner, 0, 0, 1, 1); // Default plot
        return addProperty(p);
    }

    /**
     * Overloaded addProperty. Creates a property with a specific plot.
     * @param name Property name.
     * @param city Property city.
     * @param rent Property rent.
     * @param owner Property owner.
     * @param x x-coordinate of the plot.
     * @param y y-coordinate of the plot.
     * @param width width of the plot.
     * @param depth depth of the plot.
     * @return Return code from addProperty(Property p).
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property p = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(p);
    }

    /**
     * Calculates the total rent of all properties.
     * @return The total rent.
     */
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                total += properties[i].getRentalAmount();
            }
        }
        return total;
    }

    /**
     * Finds the property with the highest rent.
     * @return The property with the highest rent (as a copy), or null if no properties.
     */
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }

        Property highest = null;
        // Find the first non-null property to start
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                highest = properties[i];
                break;
            }
        }

        // If all properties were null (which shouldn't happen, but good to check)
        if (highest == null) {
            return null;
        }

        // Now compare with the rest
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getRentalAmount() > highest.getRentalAmount()) {
                highest = properties[i];
            }
        }
        return new Property(highest); // Return a copy for encapsulation
    }

    /**
     * Removes the last property in the array.
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    /**
     * Checks if the properties array is full.
     * @return true if full, false otherwise.
     */
    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    /**
     * Gets the current number of properties.
     * @return The number of properties.
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    /**
     * Checks if the management fee is valid (0-100).
     * @return true if valid, false otherwise.
     */
    public boolean isManagementFeeValid() {
        return managementFee >= 0 && managementFee <= 100;
    }

    /**
     * Returns string representation of the company and its properties.
     */
    @Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].toString()).append("\n");
            }
        }
        sb.append("______________________________________________________\n\n");
        
        double totalFee = getTotalRent() * (managementFee / 100.0);
        sb.append(" total management Fee: ").append(String.format("%.2f", totalFee));
        
        return sb.toString();
    }
    
    // --- Other Getters ---
    
    public String getName() {
        return name;
    }
    
    public String getTaxId() {
        return taxId;
    }
    
    public Plot getPlot() {
        return new Plot(plot); // Return a copy
    }
    
    public double getManagementFee() {
        return managementFee;
    }
    
    // Not explicitly required, but needed for GUI
    public Property[] getProperties() {
        return properties;
    }

    public static int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }
}

