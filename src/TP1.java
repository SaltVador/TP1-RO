import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TP1 {

    private char[][] labyrinthe;
    //Coordonnées de la case de départ
    private int startI, startJ;
    private int longueur = 0;

    public TP1(){
        labyrinthe = init();
    }


    public char[][] init(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("../data/labExemple.lab"));
            char[][] res = new char[20][20];
            String lecture;
            int i = 0;
            while ((lecture = br.readLine()) != null){
                char[] tab = lecture.toCharArray();
                int j = 0;
                for (char var : tab) {
                    res[i][j] = var;
                    if (var == 'e'){
                        this.startI=i;
                        this.startJ=j;
                    }
                    j++;
                }
                i++;
            }

            br.close();
            return res;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




    private boolean estLibre(int i, int j){ return labyrinthe[i][j] == '_' || labyrinthe[i][j] == 'S'; }

    private boolean aGauche(int i, int j){ return estLibre(i - 1, j); }

    private boolean aDroite(int i, int j){ return estLibre(i + 1, j); }

    private boolean enHaut(int i, int j){ return estLibre(i, j - 1); }

    private boolean enBas(int i, int j){ return estLibre(i, j + 1); }

    public int enLargeur(){
        while (i <= labyrinthe.length && j <= labyrinthe[0].length) {
            if (enHaut(i,j)) {
                labyrinthe[i][j] = labyrinthe[i][j - 1];
                longueur += 1;
            } else if (enBas(i,j)) {
                labyrinthe[i][j] = labyrinthe[i][j + 1];
                longueur += 1;
            } else if (aDroite(i,j)) {
                labyrinthe[i][j] = labyrinthe[i + 1][j];
                longueur += 1;
            } else if (aGauche(i,j)) {
                labyrinthe[i][j] = labyrinthe[i - 1][j];
                longueur += 1;
            }
        }
        return longueur;
    }


}