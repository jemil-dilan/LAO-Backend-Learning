package figures;

public class Rectangle extends Forme {
    
    private double largeur;
    private double hauteur;
    
    public Rectangle(double largeur, double hauteur){

        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return this.hauteur;
    }

    public double getLargeur() {
        return this.largeur;
    }

    @Override
    public double calculerAire() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'calculerAire'");
        return this.largeur*this.hauteur;
    }

    @Override
    public double calculerPerimetre() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'calculerPerimetre'");
        return 2*(this.largeur + this.hauteur);
    }
    
    
}
