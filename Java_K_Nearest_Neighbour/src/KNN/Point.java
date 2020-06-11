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

    //Gibt die x-Koordinate eines Punktes zurueck
    public int getX() {
        return x;
    }

    //Gibt die y-Koordinate eines Punktes zurueck
    public int getY() {
        return y;
    }

    //Gibt die Klasse eines Punktes zurueck
    public int getKlasse() {
        return klasse;
    }
}
