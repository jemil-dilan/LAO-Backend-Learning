package commande;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Restaurant {
    
    private Set<ArticleMenu> menu = new LinkedHashSet<ArticleMenu>();
    private List<Commande> commandes = new ArrayList<Commande>();

    public void ajouterArticleMenu(ArticleMenu article){

        menu.add(article);
    }

    public void afficherMenu(){

        System.out.println("        MENU        ");
        
        Iterator<ArticleMenu> iterateur = menu.iterator();
        while (iterateur.hasNext()) {
            System.out.println(iterateur.next());
        }
    }

    public Commande creeCommande(List<String> nomsArticles){

        Commande uneCommande = new Commande();
        Set<ArticleMenu> articleDeCommande = new LinkedHashSet<ArticleMenu>();
        int prixTotal = 0;

        //Récupérer les commandes
        for (ArticleMenu articleMenu : menu) {

            for (String string : nomsArticles) {
                
                if (articleMenu.getNom() == string) {
                    
                    articleDeCommande.add(articleMenu);
                }
            }
        }
        
        //Déterminer le prix total
        for (ArticleMenu articleCommande : articleDeCommande) {

            prixTotal = prixTotal + articleCommande.getPrix(); 
        }

        //Créer une commande
        uneCommande.setListeArticleMenus(articleDeCommande);
        uneCommande.setPrixTotal(prixTotal);
        uneCommande.setNumeroCommande(this.commandes.getLast().getNumeroCommande() + 1);
        return uneCommande;
    }

    public int calculerVentesTotales(){

        System.out.println("Total de la Facture");

        int total = 0;
        for (Commande commande : commandes) {
            
            total = total + commande.getPrixTotal();
        }
        return total;
    }
}
