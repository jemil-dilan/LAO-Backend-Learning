package commande;

import java.util.ArrayList;
import java.util.List;

public class Client {

        private List<Commande> listeCommandes = new ArrayList<Commande>();

        public void listeCommandesClient(){

            System.out.println("Mes commandes:");
            for (Commande commande : listeCommandes) {
                
                System.out.println("N° " + commande.getNumeroCommande() + "Articles: "
                + commande.getListeArticleMenus() + "Total: "
                + commande.getPrixTotal());
            }
        }

        public void setListeCommandes(List<Commande> listeCommandes) {
            this.listeCommandes = listeCommandes;
        }
}

