package lab;

/**
 * The DataManager class is responsible for holding and providing the data
 * that the GUI will display. It does not interact with the GUI directly.
 * @author ralexander
 *
 */
public class DataManager {
    
    /**
     * Default constructor.
     */
    DataManager() {	}

    /**	
     * Returns the "Hello" greeting.
     * @return A string containing "Hello World".
     */
    public String getHello() {
        return "Hello World";
    }

    /**
     * Returns the "Howdy" greeting.
     * @return A string containing "Howdy y'all".
     */
    public String getHowdy() {
        return "Howdy y'all";
    }

    /**
     * Returns the "Chinese" greeting.
     * @return A string containing "Ni hau".
     */
    public String getChinese() {
        return "Ni hau";
    }
}
