public class Produit {
    
    private String id;
    private String nom;
    private int prix;
    private int quantite;

    public Produit(String id, String nom, int prix, int quantite){

        this.id = id;
        this.nom = nom; 
        this.prix = Math.max(0, prix);
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public String getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
