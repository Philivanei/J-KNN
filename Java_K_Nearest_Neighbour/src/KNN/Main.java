package KNN;

public class Main {

    public static void main(String[] args) {

        //Count of Neighbors, that should be analysed
        final int k = 5;
        //Size of the crosses in the coordinate system
        final double crossSize = 0.1;
        //Resolution of the coordinate system
        final int[] cor = {-10, 10};

        GUI gui = new GUI(k, cor, crossSize);
        gui.showUI();
    }
}
