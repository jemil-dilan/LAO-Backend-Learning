package bibliotheque;

public class Test {
    
    public static void main(String[] args) {
        
        Livre Livre1 = new Livre("La force et l'intérêt", "Adon", "545re", true);
        Livre Livre2 = new Livre("La mort", "Adon", "465eg", true);
        Livre Livre3 = new Livre("Hercule Poireau", "Agatha Christie", "546qq", true);


        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.ajouterLivre(Livre3);
        bibliotheque.ajouterLivre(Livre2);
        bibliotheque.ajouterLivre(Livre1);

        System.out.println("Les livres de Adon sont: ");
        for (Livre livre : bibliotheque.rechercherParAuteur("Adon")) {
            
            System.out.println(livre.getTitre() + "\n");
        }
    }
}
