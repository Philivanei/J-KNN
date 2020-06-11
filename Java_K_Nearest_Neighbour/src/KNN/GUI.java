package KNN;

import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private int k;
    private int classCount;

    public GUI(int k, int classCount) {

        this.k = k;
        this.classCount = classCount;
    }

    public void showUI() {
        setTitle("Menü");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        buttons();
    }

    private void buttons() {
        JButton close = new JButton("Schließen");
        JButton drawEu = new JButton("Euklidische Distanz");
        close.setBounds(200, 300, 200, 40);
        drawEu.setBounds(200, 200, 200, 40);

        Container cont = getContentPane();
        GroupLayout group = new GroupLayout(cont);
        cont.setLayout(group);

        cont.add(close);
        cont.add(drawEu);

        buttonExit(close);
        buttonEucl(drawEu);

    }

    private void buttonExit(JButton button) {
        button.addActionListener(e -> System.exit(1));
    }

    private void buttonEucl(JButton button) {
        button.addActionListener(e -> {
            Plot2DPanel plot = new Plot2DPanel();

            //Setze Aufloesung des Koordinatensystems
            plot.addLinePlot("", new double[]{-10, -10}, new double[]{-10, -10});
            plot.addLinePlot("", new double[]{10, 10}, new double[]{10, 10});

            JFrame frame = new JFrame("KNearestNeighbour");
            frame.setContentPane(plot);
            frame.setSize(1200, 800);
            frame.setVisible(true);

            ButtonAction buttonAction = new ButtonAction();
            buttonAction.createTestData(classCount);
            buttonAction.getKNearestNeighbour(k);

            //TODO: Die zugehörige Gruppenfarbe muss festgelegt werden!
            //Zeichne klassifizierte Punkte in Koordinatensystem
            for (Point p : buttonAction.getClassifiedPoints()) {
                plot.addLinePlot("", Color.BLACK, new double[]{p.getX() - 0.1, p.getY() - 0.1},
                        new double[]{p.getX() + 0.1, p.getY() + 0.1});
                plot.addLinePlot("", Color.BLACK, new double[]{p.getX() + 0.1, p.getY() - 0.1},
                        new double[]{p.getX() - 0.1, p.getY() + 0.1});
            }

            //Zeichne unklassifizierten Punkt in Koordinatensystem
            plot.addLinePlot("", Color.GREEN, new double[]{buttonAction.getUnclassifiedPoint().getX() - 0.1,
                            buttonAction.getUnclassifiedPoint().getY() - 0.1},
                    new double[]{buttonAction.getUnclassifiedPoint().getX() + 0.1,
                            buttonAction.getUnclassifiedPoint().getY() + 0.1});
            plot.addLinePlot("", Color.GREEN, new double[]{buttonAction.getUnclassifiedPoint().getX() + 0.1,
                            buttonAction.getUnclassifiedPoint().getY() - 0.1},
                    new double[]{buttonAction.getUnclassifiedPoint().getX() - 0.1,
                            buttonAction.getUnclassifiedPoint().getY() + 0.1});

        });
    }


}
