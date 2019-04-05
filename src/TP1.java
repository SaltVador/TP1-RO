import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TP1 {

    private char[][] labyrinthe;
    //Coordonnées de la case de départ
    private int startI, startJ,endI,endJ;
    private int longueur = 0;

    public TP1(String lab){
        labyrinthe = init(lab);
    }


    public char[][] init(String lab){

        try {
            BufferedReader br = new BufferedReader(new FileReader("../data/"+ lab +".lab"));
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
                    if (var == 'S'){
                        this.endI=i;
                        this.endJ=j;
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

    public int getLongueur(){
        //TODO retourne longueur
        return 0;
    }

    public int getLargeur(){
        //TODO retourne largeur
        return 0;
    }

    private boolean estLibre(int i, int j){ return labyrinthe[i][j] == '_' || labyrinthe[i][j] == 'S'; }
    private boolean estFin(int i, int j){ return labyrinthe[i][j] == 'S'; }

    private boolean aGauche(Case lacase,ArrayList<Case> frontiere){
        if (this.frontiereInclus(lacase,frontiere)){
            return false;
        } else return estLibre(lacase.getI() , lacase.getJ());
    }

    private boolean aDroite(Case lacase,ArrayList<Case> frontiere){
        if (this.frontiereInclus(lacase,frontiere)){
            return false;
        }else return estLibre(lacase.getI(), lacase.getJ());
    }

    private boolean enHaut(Case lacase,ArrayList<Case> frontiere){
        if (this.frontiereInclus(lacase,frontiere)){
            return false;
        } else return estLibre(lacase.getI(), lacase.getJ());
    }

    private boolean enBas(Case lacase,ArrayList<Case> frontiere){
        if (this.frontiereInclus(lacase,frontiere)){
            return false;
        } else return estLibre(lacase.getI(), lacase.getJ());
    }

    public boolean frontiereInclus(Case test,ArrayList<Case> frontiere){
        for (Case plop : frontiere) {
            if (test.equals(plop)){
                return true;
            }
        }

        return false;
    }


    public int enLargeur(){

        Case grr = new Case(startI,startJ,0);
        ArrayList<Case> atest = new ArrayList<Case>();
        ArrayList<Case> frontiere = new ArrayList<Case>();
        atest.add(grr);
        frontiere.add(grr);
        while(!atest.isEmpty()){
            Case test = atest.get(0);

            if (test.getI()!=0){
                Case enPlusH = new Case(test.getI()-1,test.getJ(),test.getLongueur()+1);
                if (enHaut(enPlusH,frontiere)) {
                    System.out.println("haut i = "+enPlusH.getI()+"  j = "+enPlusH.getJ());
                    atest.add(enPlusH);
                    frontiere.add(enPlusH);
                    if (estFin(enPlusH.getI(),enPlusH.getJ())){
                        return enPlusH.getLongueur();
                    }
                }}

            if (test.getI()!=labyrinthe[0].length){
                Case enPlusB = new Case(test.getI()+1,test.getJ(),test.getLongueur()+1);
                if (enBas(enPlusB,frontiere)) {
                    System.out.println("bas i = "+enPlusB.getI()+"  j = "+enPlusB.getJ());
                    atest.add(enPlusB);
                    frontiere.add(enPlusB);
                    if (estFin(enPlusB.getI(),enPlusB.getJ())){
                        return enPlusB.getLongueur();
                    }
                }
            }

            if (test.getJ() != labyrinthe.length){
                Case enPlusD = new Case(test.getI(),test.getJ()+1,test.getLongueur()+1);
                if (aDroite(enPlusD,frontiere)) {
                    System.out.println("droite i = "+enPlusD.getI()+"  j = "+enPlusD.getJ());
                    atest.add(enPlusD);
                    frontiere.add(enPlusD);
                    if (estFin(enPlusD.getI(),enPlusD.getJ())){
                        return enPlusD.getLongueur();
                    }
                }
            }

            if (test.getJ()!=0){
                Case enPlusG = new Case(test.getI(),test.getJ()-1,test.getLongueur()+1);
                if (aGauche(enPlusG,frontiere)) {
                    System.out.println("gauche i = "+enPlusG.getI()+"  j = "+enPlusG.getJ());
                    atest.add(enPlusG);
                    frontiere.add(enPlusG);
                    if (estFin(enPlusG.getI(),enPlusG.getJ())){
                        return enPlusG.getLongueur();
                    }
                }
            }

            atest.remove(0);
        }

        return 0;
    }

    public int enProfondeur(){

        Case grr = new Case(startI,startJ,0);
        ArrayList<Case> atest = new ArrayList<Case>();
        ArrayList<Case> frontiere = new ArrayList<Case>();
        atest.add(grr);
        while(!atest.isEmpty()){
            Case test = atest.get(0);
            int i = 1;
            if (test.getI()!=0){
                Case enPlusH = new Case(test.getI()-1,test.getJ(),test.getLongueur()+1);
                if (enHaut(enPlusH,frontiere)) {
                    System.out.println("haut i = "+enPlusH.getI()+"  j = "+enPlusH.getJ());
                    atest.add(i,enPlusH);
                    i++;
                    frontiere.add(enPlusH);
                    if (estFin(enPlusH.getI(),enPlusH.getJ())){
                        return enPlusH.getLongueur();
                    }
                }
            }
            if (test.getI()!=labyrinthe[0].length){
                Case enPlusB = new Case(test.getI()+1,test.getJ(),test.getLongueur()+1);
                if (enBas(enPlusB,frontiere)) {
                    System.out.println("bas i = "+enPlusB.getI()+"  j = "+enPlusB.getJ());
                    atest.add(i,enPlusB);
                    i++;
                    frontiere.add(enPlusB);
                    if (estFin(enPlusB.getI(),enPlusB.getJ())){
                        return enPlusB.getLongueur();
                    }
                }
            }

            if (test.getJ() != labyrinthe.length){
                Case enPlusD = new Case(test.getI(),test.getJ()+1,test.getLongueur()+1);
                if (aDroite(enPlusD,frontiere)) {
                    System.out.println("droite i = "+enPlusD.getI()+"  j = "+enPlusD.getJ());
                    atest.add(i,enPlusD);
                    i++;
                    frontiere.add(enPlusD);
                    if (estFin(enPlusD.getI(),enPlusD.getJ())){
                        return enPlusD.getLongueur();
                    }
                }
            }

            if (test.getJ()!=0){
                Case enPlusG = new Case(test.getI(),test.getJ()-1,test.getLongueur()+1);
                if (aGauche(enPlusG,frontiere)) {
                    System.out.println("gauche i = "+enPlusG.getI()+"  j = "+enPlusG.getJ());
                    atest.add(i,enPlusG);
                    i++;
                    frontiere.add(enPlusG);
                    if (estFin(enPlusG.getI(),enPlusG.getJ())){
                        return enPlusG.getLongueur();
                    }
                }
            }
            atest.remove(0);
        }


        return 0;
    }

    public Case laplusprochefin(ArrayList<Case> array){
        Case retour = array.get(0);
        int distT = endI-retour.getI()+endJ-retour.getJ();
        if (distT<0)distT=-distT;
        int longueur = 0;
        for (Case c : array) {
            int test = endI-c.getI()+endJ-c.getJ();
            if (test<0)test=-test;
            test = test + c.getLongueur();
            if (test == distT){
                if (longueur>c.getLongueur()){
                    retour = c;
                    longueur = c.getLongueur();
                }
            } else if (test<distT){
                distT=test;
                longueur = c.getLongueur();
                retour=c;
            }
        }
        return retour;
    }

    public int stratEtoile(){
        Case grr = new Case(startI,startJ,0);
        ArrayList<Case> atest = new ArrayList<Case>();
        ArrayList<Case> frontiere = new ArrayList<Case>();
        atest.add(grr);
        while(!atest.isEmpty()){
            Case test = laplusprochefin(atest);
            if (test.getI()!=0){
                Case enPlusH = new Case(test.getI()-1,test.getJ(),test.getLongueur()+1);
                if (enHaut(enPlusH,frontiere)) {
                    System.out.println("haut i = "+enPlusH.getI()+"  j = "+enPlusH.getJ());
                    atest.add(enPlusH);
                    frontiere.add(enPlusH);
                    if (estFin(enPlusH.getI(),enPlusH.getJ())){
                        return enPlusH.getLongueur();
                    }
                }}

            if (test.getI()!=labyrinthe[0].length){
                Case enPlusB = new Case(test.getI()+1,test.getJ(),test.getLongueur()+1);
                if (enBas(enPlusB,frontiere)) {
                    System.out.println("bas i = "+enPlusB.getI()+"  j = "+enPlusB.getJ());
                    atest.add(enPlusB);
                    frontiere.add(enPlusB);
                    if (estFin(enPlusB.getI(),enPlusB.getJ())){
                        return enPlusB.getLongueur();
                    }
                }
            }

            if (test.getJ() != labyrinthe.length){
                Case enPlusD = new Case(test.getI(),test.getJ()+1,test.getLongueur()+1);
                if (aDroite(enPlusD,frontiere)) {
                    System.out.println("droite i = "+enPlusD.getI()+"  j = "+enPlusD.getJ());
                    atest.add(enPlusD);
                    frontiere.add(enPlusD);
                    if (estFin(enPlusD.getI(),enPlusD.getJ())){
                        return enPlusD.getLongueur();
                    }
                }
            }

            if (test.getJ()!=0){
                Case enPlusG = new Case(test.getI(),test.getJ()-1,test.getLongueur()+1);
                if (aGauche(enPlusG,frontiere)) {
                    System.out.println("gauche i = "+enPlusG.getI()+"  j = "+enPlusG.getJ());
                    atest.add(enPlusG);
                    frontiere.add(enPlusG);
                    if (estFin(enPlusG.getI(),enPlusG.getJ())){
                        return enPlusG.getLongueur();
                    }
                }
            }
            atest.remove(test);
        }
        return 0;
    }

    public static void main (String[] agrs){
        TP1 lab = new TP1("lab1");
        System.out.println(lab.stratEtoile());
    }

}