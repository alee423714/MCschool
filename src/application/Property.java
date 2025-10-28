/*
 * Class: CMSC203
 * Instructor:
 * Description: Represents a property with name, city, rent, owner, and plot.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Adam Lee
 */
package application;

public class Property {

    private String propertyName;
    private String city;
    private double rentalAmount;
    private String owner;
    private Plot plot;

    /**
     * Default constructor. Initializes with empty strings, 0 rent, and a default plot.
     */
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentalAmount = 0;
        this.owner = "";
        this.plot = new Plot();
    }

    /**
     * Copy constructor. Creates a deep copy of the Property.
     * @param otherProperty The Property to copy.
     */
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentalAmount = otherProperty.rentalAmount;
        this.owner = otherProperty.owner;
        // Ensure a deep copy of the plot
        this.plot = new Plot(otherProperty.plot);
    }

    /**
     * Parameterized constructor (no plot).
     * @param propertyName Name of the property.
     * @param city City where the property is located.
     * @param rentalAmount Monthly rental amount.
     * @param owner Owner of the property.
     */
    public Property(String propertyName, String city, double rentalAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot
    }

    /**
     * Parameterized constructor (with plot).
     * @param propertyName Name of the property.
     * @param city City where the property is located.
     * @param rentalAmount Monthly rental amount.
     * @param owner Owner of the property.
     * @param x x-coordinate of the plot.
     * @param y y-coordinate of the plot.
     * @param width width of the plot.
     * @param depth depth of the plot.
     */
    public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // --- Getter and Setter Methods ---

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    /**
     * Returns a string representation of the property.
     * Format: [property name],[ city],[ owner],[ rental amount]
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentalAmount;
    }
}
