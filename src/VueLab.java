import javax.swing.*;
import java.awt.*;

public class VueLab extends JFrame {

    private TP1 tp1;

    /**
     * Valeurs des cases
     * E = case d'entrée
     * _ = case vide
     * M = mur
     * S = case de sortie
     */

    static class Vue extends JPanel {

        public Vue(){
        }

        public void paint(Graphics graphics){

        }

    }

    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Labyrinthe");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800,800);
        Vue vue = new Vue();
        fenetre.add(vue);
        fenetre.setVisible(true);
    }


    /**
    public class MazeApp extends JFrame {

public static void main(String[] args) {

    JFrame frame = new JFrame("Maze");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(1000, 1000);
    Maze brd = new Maze();
    frame.add(brd);
    frame.setVisible(true);
}
}


class Maze extends JPanel {

public Maze() {
}

protected void paintComponent(Graphics g) {
    int width = 1;
    int height = 1;

    int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 1, 2, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, },
            { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, },
            { 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, } };

    for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map.length; j++) {
            int factori = i * 50;
            int factorj = j * 50;
            switch (map[i][j]) {
            case 0: {
                g.setColor(Color.red);
                g.fillRect(factori, factorj, 2, 2);

            }
                break;
            case 1: {
                g.setColor(Color.yellow);
                g.fillRect(factori, factorj, 2, 2);

            }
                break;
            case 2: {
                g.setColor(Color.blue);
                g.fillRect(factori, factorj, 2, 2);

            }
                break;
            }
        }
    }
}
}
     */
}