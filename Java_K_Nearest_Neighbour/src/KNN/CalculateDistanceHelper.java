package KNN;

/**
 * This class calculates the distance from each classified point to the unclassified point.
 */
public class CalculateDistanceHelper {

    /**
     * Constructor of CalculateDistanceHelper.
     */
    public CalculateDistanceHelper() {

    }

    /**
     * Calculates the euclidean distance with point values.
     *
     * @param unclassifiedPoint Unclassified point values.
     * @param classifiedPoint   Classified point values.
     * @return The calculated euclidean distance.
     */
    public double getEuclideanDistance(Point unclassifiedPoint, Point classifiedPoint) {
        return getEuclideanDistance(unclassifiedPoint.getX(), unclassifiedPoint.getY(),
                classifiedPoint.getX(), classifiedPoint.getY());
    }

    /**
     * Calculates the euclidean distance with coordinate values.
     *
     * @param unclassifiedX X-Coordinate of a unclassified point.
     * @param unclassifiedY Y-Coordinate of a unclassified point.
     * @param referenceX    X-Coordinate of a classified point.
     * @param referenceY    Y-Coordinate of a classified point.
     * @return The calculated euclidean distance.
     */
    public double getEuclideanDistance(int unclassifiedX, int unclassifiedY, int referenceX, int referenceY) {
        return Math.pow(unclassifiedX - referenceX, 2) + Math.pow(unclassifiedY - referenceY, 2);
    }

}
