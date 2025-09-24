/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: (Movie Driver Task to call the Movie class and use its objects to input and output information)
 * Due: 09/14/20205
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * Independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Adam Lee
*/
package lab;
import java.util.Scanner;

public class MovieDriver_Task1 {
	public static void main(String[] args) {
        
        // Create a tool to read keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Create a new, empty movie object from the Movie blueprint.
        Movie myMovie = new Movie();

        // Ask for the movie's title.
        System.out.print("Enter the title of a movie: ");
        // Read the user's text input.
        String titleInput = keyboard.nextLine();
        // Set the title in movie object.
        myMovie.setTitle(titleInput);

        // Ask for the movie's rating.
        System.out.print("Enter the movie’s rating: ");
        // Read the user's text input.
        String ratingInput = keyboard.nextLine();
        // Set the rating in movie object.
        myMovie.setRating(ratingInput);

        // Ask for the number of tickets sold.
        System.out.print("Enter the number of tickets sold at the theater: ");
        // Read the user's number input.
        int ticketsInput = keyboard.nextInt();
        // Set the tickets sold in movie object.
        myMovie.setSoldTickets(ticketsInput);

        // Print a header for the output.
        System.out.println("\n--- Movie Information ---");
        // Print all the movie's details by calling its toString method.
        System.out.println(myMovie.toString());

        // Close the scanner to free up resources.
        keyboard.close();
    }
}