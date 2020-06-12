package KNN;

import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private int k;
    private int classCount;
    private double crossSize;
    private int coor[];

    public GUI(int k, int classCount, int[] coor, double crossSize) {

        this.k = k;
        this.classCount = classCount;
        this.crossSize = crossSize;
        this.coor = coor;
    }

    public void showUI() {

        //Layout des Menues festlegen
        final int width = 600;
        final int height = 600;

        setTitle("Menü");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        buttons();
    }

    private void buttons() {

        //Layout der Buttons festlegen
        final int x = 200;
        final int y[] = {200, 300};
        final int size[] = {200, 40};
        JButton drawEu = new JButton("Euklidische Distanz");
        JButton close = new JButton("Schließen");
        drawEu.setBounds(x, y[0], size[0], size[1]);
        close.setBounds(x, y[1], size[0], size[1]);

        Container cont = getContentPane();
        GroupLayout group = new GroupLayout(cont);
        cont.setLayout(group);

        cont.add(close);
        cont.add(drawEu);

        //Aufruf des ActionListeners
        buttonExit(close);
        buttonEucl(drawEu);
    }

    private void buttonEucl(JButton button) {
        button.addActionListener(e -> {
            Plot2DPanel plot = new Plot2DPanel();
            DrawPointsHelper draw = new DrawPointsHelper(crossSize);
            ButtonAction buttonAction = new ButtonAction();

            buttonAction.createTestData(classCount);
            buttonAction.getKNearestNeighbour(k);

            //Zeichne Koordinatensystem mit Punkte
            drawCoordinateSystem(plot);
            draw.drawUnclassifiedPoint(buttonAction.getUnclassifiedPoint(), plot);
            draw.drawClassifiedPoints(buttonAction.getClassifiedPoints(), plot);
        });
    }

    private void buttonExit(JButton button) {
        button.addActionListener(e -> System.exit(1));
    }

    //Koordinatensystem fuer GUI
    private void drawCoordinateSystem(Plot2DPanel plot) {

        final int width = 1200;
        final int height = 800;

        //Setze Aufloesung des Koordinatensystems
        plot.addLinePlot("", new double[]{coor[0], coor[0]}, new double[]{coor[0], coor[0]});
        plot.addLinePlot("", new double[]{coor[1], coor[1]}, new double[]{coor[1], coor[1]});

        //Layout des Koordinatensystems
        JFrame frame = new JFrame("KNearestNeighbour");
        frame.setContentPane(plot);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
