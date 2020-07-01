package KNN;

/**
 * The PointDistance class is used to sort the points by the distance values. It creates a new object, that contains
 * point values and its resulting distance to the unclassified point.
 */
public class PointDistance implements Comparable<PointDistance> {
    private final Point point;
    private final double distance;

    /**
     * The Constructor gets the point value and its distance value.
     *
     * @param point    Point values.
     * @param distance Distance value.
     */
    public PointDistance(Point point, double distance) {
        this.point = point;
        this.distance = distance;
    }

    /**
     * Gets the point values.
     *
     * @return Point values.
     */
    public Point getPoint() {
        return point;
    }

    /**
     * The list in KNearestNeighbor gets sorted by the value of the distance.
     *
     * @param o PointDistance object.
     * @return The up rounded distance.
     */
    @Override
    public int compareTo(PointDistance o) {
        return ((int) Math.ceil(this.distance - o.distance));
    }
}
