package KNN;

public class PointDistance implements Comparable<PointDistance> {
    private final Point point;
    private final double distance;

    public PointDistance(Point point, double distance) {
        this.point = point;
        this.distance = distance;
    }

    public Point getPoint() {
        return point;
    }

    //The list is sorted by the value of the distance
    @Override
    public int compareTo(PointDistance o) {
        //The distance is rounded up
        return ((int) Math.ceil(this.distance - o.distance));
    }
}
