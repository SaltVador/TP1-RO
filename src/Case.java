public class Case {
    private int i,j,longueur;
    private String prec;



    public Case(int x, int y, int lon, String preced){
        this.i=x;
        this.j=y;
        this.longueur = lon;
        this.prec = preced;
    }

    public int getI() {
        return i;
    }

    public String getPrec() {
        return prec;
    }

    public int getJ() {
        return j;
    }

    public int getLongueur() {
        return longueur;
    }
}
