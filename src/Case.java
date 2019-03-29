public class Case {
    private int i,j,longueur;



    public Case(int x, int y, int lon){
        this.i=x;
        this.j=y;
        this.longueur = lon;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getLongueur() {
        return longueur;
    }

    public boolean equals(Case grr){
        if (grr.getI() == i && grr.getJ() == j){
            return true;
        } else return false;
    }
}
