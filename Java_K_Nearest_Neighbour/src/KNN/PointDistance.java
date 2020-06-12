package KNN;

public class PointDistance implements Comparable<PointDistance> {
    private Point point;
    private double distance;

    public PointDistance(Point point, double distance) {
        this.point = point;
        this.distance = distance;
    }

    public Point getPoint() {
        return point;
    }

    //Hier wird festgelegt, nach was sortiert werden soll. In diesem Fall nach der Distanzgroesse.
    @Override
    public int compareTo(PointDistance o) {
        //Die Distanz wird immer aufgerundet
        return ((int) Math.ceil(this.distance - o.distance));
    }
}
