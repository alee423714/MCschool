package com.example;

/**
 * Represents a single medical procedure performed on a patient.
 */
public class Procedure {

    // Fields to store procedure data
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges; // Added for a complete example

    /**
     * No-arg constructor to create a blank procedure object.
     */
    public Procedure() {
    }

    /**
     * Constructor to initialize all attributes of the procedure.
     */
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }

    // Accessor (getter) and Mutator (setter) methods for each field

    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }

    public String getProcedureDate() { return procedureDate; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }

    public String getPractitionerName() { return practitionerName; }
    public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }

    public double getProcedureCharges() { return procedureCharges; }
    public void setProcedureCharges(double procedureCharges) { this.procedureCharges = procedureCharges; }
    
    /**
     * Returns a string with all procedure information.
     * @return A formatted string of all procedure details.
     */
    @Override
    public String toString() {
        return "\tProcedure: " + procedureName + "\n" +
               "\tDate: " + procedureDate + "\n" +
               "\tPractitioner: " + practitionerName + "\n" +
               "\tCharge: $" + String.format("%,.2f", procedureCharges);
    }
}
