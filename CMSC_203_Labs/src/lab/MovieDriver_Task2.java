/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: (Movie Driver Task 2 to call the Movie class and use its objects to input and output information and include an option to list more than one movie)
 * Due: 09/14/20205
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * Independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Adam Lee
*/
package lab;
import java.util.Scanner;

// Main class to drive the application.
public class MovieDriver_Task2 {

    public static void main(String[] args) {
        
        // Create a Scanner object to get keyboard input.
        Scanner keyboard = new Scanner(System.in);
        String anotherMovie; // Holds the user's 'y' or 'n' answer.

        // Use a do-while loop to run the program at least once.
        do {
            // Create a new movie object for this entry.
            Movie myMovie = new Movie();

            // Ask the user for the movie title and read it.
            System.out.println("Enter the name of a movie");
            String titleInput = keyboard.nextLine();
            myMovie.setTitle(titleInput);

            // Ask for the rating and read it.
            System.out.println("Enter the rating of the movie");
            String ratingInput = keyboard.nextLine();
            myMovie.setRating(ratingInput);

            // Ask for the number of tickets sold and read it.
            System.out.println("Enter the number of tickets sold for this movie");
            int ticketsInput = keyboard.nextInt();
            myMovie.setSoldTickets(ticketsInput);

            // Print out the movie's info using its toString method.
            System.out.println(myMovie.toString());

            // Ask the user if they want to enter another movie.
            System.out.println("Do you want to enter another? (y or n)");
            
            // This extra nextLine() clears the leftover "Enter" keypress
            // from when the user entered the number of tickets.
            keyboard.nextLine(); 
            
            // Read the user's 'y' or 'n' response.
            anotherMovie = keyboard.nextLine();

        // Keep looping as long as the user types 'y' (or 'Y').
        } while (anotherMovie.equalsIgnoreCase("y"));
        
        // When the loop is done, say goodbye.
        System.out.println("Goodbye");

        // Close the scanner to free up resources.
        keyboard.close();
    }
}