package figures;

public class CalculateurFormes {
    
    Forme formeQuelconque;

    public CalculateurFormes(Forme forme){

        this.formeQuelconque = forme;
    }

    public double getAire(){

        return formeQuelconque.calculerAire();
    }

    public double getPerimetre(){

        return formeQuelconque.calculerPerimetre();
    }
}
