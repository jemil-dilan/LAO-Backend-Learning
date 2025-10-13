public class Vehicules {

    private String marque;
    private String modele;
    private int annee;
    private int prix;

    public void afficherInfo(){

        System.out.println(
            "Les information du vehicule"+
            "\nmarque: " + this.marque +
            "\nmodele: " + this.modele +
            "\nannee: " + this.annee +
            "\nprix: " + this.prix
        );
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }
}