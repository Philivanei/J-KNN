package KNN;

public class Point {

    private final int x;
    private final int y;
    private int classes;

    //Constructor for unclassified points
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Constructor for classified points
    public Point(int x, int y, int classes) {
        this.x = x;
        this.y = y;
        this.classes = classes;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getClassOfPoint() {
        return classes;
    }
}
