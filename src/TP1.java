import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                    if (var == 'E'){
                        this.startI=i;
                        this.startJ=j;
                    }
                    j++;
                }
                i++;
            }

            br.close();

            for (int x = 0; x<20; x++){
                StringBuilder p = new StringBuilder();
                for (int y = 0; y<20;y++){
                    p.append(res[x][y]);
                }
                System.out.println(p);
            }

            System.out.println(startI);
            System.out.println(startJ);

            return res;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private boolean estLibre(int i, int j){ return labyrinthe[i][j] == '_' || labyrinthe[i][j] == 'S'; }
    private boolean estFin(int i, int j){ return labyrinthe[i][j] == 'S'; }

    private boolean aGauche(int i, int j,String prec){
        if (j==0 || prec.equals("droite")){
            return false;
        } else return estLibre(i , j - 1);
    }

    private boolean aDroite(int i, int j, String prec){
        if (j == labyrinthe.length || prec.equals("gauche")){
            return false;
        }else return estLibre(i, j+1);
    }

    private boolean enHaut(int i, int j, String prec){
        if (i==0 || prec.equals("bas")){
            return false;
        } else return estLibre(i-1, j);
    }

    private boolean enBas(int i, int j, String prec){
        if (i==labyrinthe[0].length || prec.equals("haut")){
            return false;
        } else return estLibre(i+1, j);
    }

    /*public int enLargeur(){
        int i = startI;
        int j = startJ;
        String prec = "";
        while (labyrinthe[i][j] != 'S') {
            if (enHaut(i,j,prec)) {
                prec = "haut";
                System.out.println("haut i = "+i+"  j = "+j);
                i--;
                longueur += 1;
            } else if (enBas(i,j,prec)) {
                prec = "bas";
                System.out.println("bas i = "+i+"  j = "+j);
                i++;
                longueur += 1;
            } else if (aDroite(i,j,prec)) {
                prec = "droite";
                System.out.println("droite i = "+i+"  j = "+j);
                j++;
                longueur += 1;
            } else if (aGauche(i,j,prec)) {
                prec = "gauche";
                System.out.println("gauche i = "+i+"  j = "+j);
                j--;
                longueur += 1;
            }
        }
        return longueur;
    }*/

    public int enLargeurV2(){

        Case grr = new Case(startI,startJ,0,"");
        ArrayList<Case> frontiere = new ArrayList<Case>();
        frontiere.add(grr);
        while(!frontiere.isEmpty()){
            Case test = frontiere.get(0);
            if (enHaut(test.getI(),test.getJ(),test.getPrec())) {
                Case enPlus = new Case(test.getI()-1,test.getJ(),test.getLongueur()+1,"haut");
                System.out.println("haut i = "+enPlus.getI()+"  j = "+enPlus.getJ());
                frontiere.add(enPlus);
                if (estFin(enPlus.getI(),enPlus.getJ())){
                    return enPlus.getLongueur();
                }
            }
            if (enBas(test.getI(),test.getJ(),test.getPrec())) {
                Case enPlus = new Case(test.getI()+1,test.getJ(),test.getLongueur()+1,"bas");
                System.out.println("bas i = "+enPlus.getI()+"  j = "+enPlus.getJ());
                frontiere.add(enPlus);
                if (estFin(enPlus.getI(),enPlus.getJ())){
                    return enPlus.getLongueur();
                }
            }
            if (aDroite(test.getI(),test.getJ(),test.getPrec())) {
                Case enPlus = new Case(test.getI(),test.getJ()+1,test.getLongueur()+1,"droite");
                System.out.println("droite i = "+enPlus.getI()+"  j = "+enPlus.getJ());
                frontiere.add(enPlus);
                if (estFin(enPlus.getI(),enPlus.getJ())){
                    return enPlus.getLongueur();
                }
            }
            if (aGauche(test.getI(),test.getJ(),test.getPrec())) {
                Case enPlus = new Case(test.getI(),test.getJ()-1,test.getLongueur()+1,"gauche");
                System.out.println("gauche i = "+enPlus.getI()+"  j = "+enPlus.getJ());
                frontiere.add(enPlus);
                if (estFin(enPlus.getI(),enPlus.getJ())){
                    return enPlus.getLongueur();
                }
            }

            frontiere.remove(0);
        }

        return 0;
    }

    public static void main (String[] agrs){
        TP1 lab = new TP1();
        System.out.println(lab.enLargeurV2());
    }

}