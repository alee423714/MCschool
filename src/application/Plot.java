/*
 * Class: CMSC203
 * Instructor: Huseyin Aygun
 * Description: Represents a Plot of land with x, y, width, and depth.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Adam Lee
 */
package application;

public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;

    /**
     * Default constructor, creates a plot at (0,0) with width 1 and depth 1.
     */
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    /**
     * Parameterized constructor.
     * @param x The x-coordinate of the upper left corner.
     * @param y The y-coordinate of the upper left corner.
     * @param width The horizontal extent of the plot.
     * @param depth The vertical extent of the plot.
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Copy constructor.
     * @param otherPlot The Plot object to copy.
     */
    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    /**
     * Checks if this plot overlaps with another plot.
     * @param plot The plot to check against.
     * @return true if the plots overlap, false otherwise.
     */
    public boolean overlaps(Plot plot) {
        // Check if one rectangle is to the left of the other
        if (this.x + this.width <= plot.x || plot.x + plot.width <= this.x) {
            return false;
        }
        // Check if one rectangle is above the other
        if (this.y + this.depth <= plot.y || plot.y + plot.depth <= this.y) {
            return false;
        }
        return true;
    }

    /**
     * Checks if this plot encompasses another plot (inclusive).
     * @param plot The plot to check.
     * @return true if this plot encompasses the other, false otherwise.
     */
    public boolean encompasses(Plot plot) {
        boolean xEncompassed = this.x <= plot.x && (this.x + this.width) >= (plot.x + plot.width);
        boolean yEncompassed = this.y <= plot.y && (this.y + this.depth) >= (plot.y + plot.depth);
        return xEncompassed && yEncompassed;
    }

    // --- Getter and Setter Methods ---

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Returns a string representation of the plot.
     * Format: [x],[y],[width],[depth]
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
