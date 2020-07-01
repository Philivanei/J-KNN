package KNN;

/**
 * The Point class stores point coordinates and its classes in one object.
 */
public class Point {

    private final int x;
    private final int y;
    private int classes;

    /**
     * Constructor for unclassified points.
     *
     * @param x X-Coordinate of a unclassified point.
     * @param y Y-Coordinate of a unclassified point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor for classified points.
     *
     * @param x       X-Coordinate of a classified point.
     * @param y       Y-Coordinate of a classified point.
     * @param classes Class value of a classified point.
     */
    public Point(int x, int y, int classes) {
        this.x = x;
        this.y = y;
        this.classes = classes;
    }

    /**
     * Gets the x-coordinate of a point object.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of a point object.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the class of a classified point object.
     *
     * @return The class.
     */
    public int getClassOfPoint() {
        return classes;
    }
}
