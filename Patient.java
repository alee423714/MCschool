package com.example;
/**
 * Represents a single patient, holding their personal and contact information.
 */
public class Patient {

    // Fields to store patient data
    private String firstName, middleName, lastName;
    private String streetAddress, city, state, zipCode;
    private String phoneNumber;
    private String emergencyContactName, emergencyContactPhone;

    /**
     * No-arg constructor to create a blank patient object.
     */
    public Patient() {
    }

    /**
     * Constructor to initialize a patient with their name.
     */
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Constructor to initialize all attributes of the patient.
     */
    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zipCode,
                   String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Accessor (getter) and Mutator (setter) methods for each field

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }

    public String getEmergencyContactPhone() { return emergencyContactPhone; }
    public void setEmergencyContactPhone(String emergencyContactPhone) { this.emergencyContactPhone = emergencyContactPhone; }

    /**
     * Concatenates the first, middle, and last name.
     * @return The patient's full name.
     */
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    /**
     * Concatenates the street, city, state, and zip code.
     * @return The patient's full address.
     */
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    /**
     * Concatenates the emergency contact's name and phone number.
     * @return The emergency contact's full information.
     */
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    /**
     * Returns a string with all patient information by calling the build methods.
     * @return A formatted string of all patient details.
     */
    @Override
    public String toString() {
        return "  Name: " + buildFullName() + "\n" +
               "  Address: " + buildAddress() + "\n" +
               "  Phone Number: " + phoneNumber + "\n" +
               "  Emergency Contact: " + buildEmergencyContact();
    }
}

