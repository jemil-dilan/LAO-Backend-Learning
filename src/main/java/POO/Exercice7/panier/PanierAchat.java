import java.util.ArrayList;
import java.util.List;

public class PanierAchat {
    
    private List<ArticlePanier> listeArticlePaniers = new ArrayList<ArticlePanier>(); 

    public void ajouterArticle(Produit produit, int quantite){

        ArticlePanier article = new ArticlePanier(produit, quantite);
        listeArticlePaniers.add(article);
    }

    public void retirerArticle(String idProduit){

        for (ArticlePanier articlePanier : listeArticlePaniers) {
            
            if (articlePanier.getProduit().getId() == idProduit) {
                
                listeArticlePaniers.remove(articlePanier);
            }
        }
    }

    public void mettreAJourQuantite(String idProduit, int nouvelleQuantite){
        
        for (ArticlePanier articlePanier : listeArticlePaniers) {
            
            if (articlePanier.getProduit().getId() == idProduit) {
                
                articlePanier.getProduit().setQuantite(nouvelleQuantite);
            }
        }
    }

    public int calculerTotal(){

        int total=0;
        for (ArticlePanier articlePanier : listeArticlePaniers) {

            total = (articlePanier.getQuantite()) * (articlePanier.getProduit().getPrix());
        }
        return total;
    }

    public void appliquerRemise(double pourcentage){

        System.out.println("Application d4une remise de " + pourcentage + "%");
        System.out.println("Total à payer: " + (calculerTotal() - (pourcentage * calculerTotal()))); ;
    }

    public void valider(){
        
        System.out.println("Inventaire des commmandes");
        System.out.println("Produit: " + "----|----" + "prix_u: " + "----|----" + "Total: " + "--------|");
        for (ArticlePanier articlePanier : listeArticlePaniers) {

            System.out.println(articlePanier.getProduit().getNom() + "         " 
            + articlePanier.getProduit().getPrix() + "         "
            + (articlePanier.getProduit().getPrix() * articlePanier.getQuantite()));
        }
        
        System.out.println("                          Total                     " + this.calculerTotal());
    }

}
