package com.example;
import java.util.Scanner;

/**
 * This is the main driver class that gets patient data from the user
 * and displays a summary of the patient and their procedures.
 */
public class PatientDriverApp {

    public static void main(String[] args) {
        // Create a Scanner object to read keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Get patient information from the user
        System.out.print("Enter patient's first name:");
        String firstName = keyboard.nextLine();
        
        System.out.print("Enter patient's middle name:");
        String middleName = keyboard.nextLine();
        
        System.out.print("Enter patient's last name:");
        String lastName = keyboard.nextLine();
        
        System.out.print("Enter patient's street address:");
        String address = keyboard.nextLine();
        
        System.out.print("Enter patient's city:");
        String city = keyboard.nextLine();
        
        System.out.print("Enter patient's state:");
        String state = keyboard.nextLine();
        
        System.out.print("Enter patient's ZIP code:");
        String zip = keyboard.nextLine();
        
        System.out.print("Enter patient's phone number:");
        String phone = keyboard.nextLine();
        
        System.out.print("Enter emergency contact's name:");
        String emergencyName = keyboard.nextLine();
        
        System.out.print("Enter emergency contact's phone number:");
        String emergencyPhone = keyboard.nextLine();

        // Create a Patient object using the user's input
        Patient patient = new Patient(firstName, middleName, lastName, address, city, state, zip, phone, emergencyName, emergencyPhone);

        // Create three instances of the Procedure class with sample data
        Procedure procedure1 = new Procedure("Physical Exam", "07/20/2024", "Dr. Irvine", 250.00);
        Procedure procedure2 = new Procedure("X-ray", "07/20/2024", "Dr. Jamison", 500.00);
        Procedure procedure3 = new Procedure("Blood Test", "07/20/2024", "Dr. Smith", 200.00);

        // Display all patient and procedure information using the required methods
        displayPatient(patient);
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate and display the total charges using the required method
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges));
        
        // Display student information
        System.out.println("\nStudent Name: Adam Lee");
        System.out.println("MC#: M21191683");
        System.out.println("Due Date: 09/28/2025");
        
        // Close the scanner to free up resources
        keyboard.close();
    }

    /**
     * Displays the patient's information.
     */
    public static void displayPatient(Patient p) {
        System.out.println("\nPatient info:");
        System.out.println(p.toString());
    }

    /**
     * Displays a single procedure's information.
     */
    public static void displayProcedure(Procedure proc) {
        System.out.println("\n" + proc.toString());
    }

    /**
     * Calculates the sum of charges for all procedures.
     */
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getProcedureCharges() + p2.getProcedureCharges() + p3.getProcedureCharges();
    }
}

