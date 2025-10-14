package figures;

public class Triangle extends Forme{
    
    private double base;
    private double hauteur;
    private double cote1;
    private double cote2;
    private double cote3;

    public Triangle( double base, double hauteur, double cote1, double cote2, double cote3){

        this.base = base;
        this.hauteur = hauteur;
        this.cote1 = cote1;
        this.cote2 = cote2;
        this.cote3 = cote3;
    }

    public double getBase() {
        return this.base;
    }

    public double getCote1() {
        return this.cote1;
    }

    public double getCote2() {
        return this.cote2;
    }

    public double getCote3() {
        return this.cote3;
    }

    public double getHauteur() {
        return this.hauteur;
    }

        @Override
    public double calculerAire() {

        return (this.base*this.hauteur)/2;
    }

    @Override
    public double calculerPerimetre() {

        return this.cote1 + this.cote2 + this.cote3;
    }
}
