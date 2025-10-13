package figures;

public class Cercle extends Forme {
    
    private double rayon;

    public double getRayon(){

        return rayon;
    }

    public Cercle(double rayon){

        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {

        return rayon*rayon*Math.PI;
    }

    @Override
    public double calculerPerimetre() {

        return 2*rayon*Math.PI;
    }
}
