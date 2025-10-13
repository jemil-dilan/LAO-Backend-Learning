package commande;

import java.util.LinkedHashSet;
import java.util.Set;

public class Commande {
    
    private Set<ArticleMenu> listeArticleMenus = new LinkedHashSet<ArticleMenu>();
    private int numeroCommande;
    private int prixTotal;

    public Set<ArticleMenu> getListeArticleMenus() {
        return listeArticleMenus;

    }
    
    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setListeArticleMenus(Set<ArticleMenu> listeArticleMenus) {
        this.listeArticleMenus = listeArticleMenus;
    }
    
}
