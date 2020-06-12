package KNN;

public class Point {

    private int x;
    private int y;
    private int klasse;

    //Konstruktor fuer unklassifizierte Punkte
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Konstruktor fuer klassifizierte Punkte
    public Point(int x, int y, int klasse) {
        this.x = x;
        this.y = y;
        this.klasse = klasse;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getClassOfPoint() {
        return klasse;
    }
}
