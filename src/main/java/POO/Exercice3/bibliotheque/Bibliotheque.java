package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    
    private List <Livre> livresBibliotheque = new ArrayList <Livre> ();

    public void ajouterLivre(Livre livre){

        livresBibliotheque.add(livre);
    }

    public void emprunterLivre(String isbn){

        for (Livre livre : livresBibliotheque) {
            
            if (livre.getIsbn() == isbn) {
                
                livre.setEstDisponible(false); //Pour tout les livres, marquer disponible à false si l'isbn correspond
            }
        }
    }

    public void retournerLivre(String isbn){

        for (Livre livre : livresBibliotheque) {
            
            if (livre.getIsbn() == isbn) {
                
                livre.setEstDisponible(true);//Pour tout les livres, marquer disponible à true si l'isbn correspond
            }
        }
    }

    public List<Livre> rechercherParAuteur(String auteur){
        
        List<Livre> listeLivresDeAuteur = new ArrayList<Livre>(); // creer une liste d'auteur

        for (Livre livre : livresBibliotheque) {
            
            if (livre.getAuteur() == auteur) {
                
                listeLivresDeAuteur.add(livre); // Pour tout les livres, si l'auteur correspond, ajouter le livre
            }
        }

        return listeLivresDeAuteur;
    }
}
