package paie;

import java.util.ArrayList;
import java.util.List;

public class SystemePaie {
    
    List<Employe> tousLesEmployes = new ArrayList<Employe>();

    public void paieLesEmloye () {

        System.out.println("Fiche de paye de tous les employés");
        for (Employe employe : tousLesEmployes) {
            
            System.out.println(
                "nom: " + employe.getNom()
                + "\nmatricle: " + employe.getNumeroEmploye()
                + "\nsalaire: " + employe.calculerSalaire()
            );
        }
    }
}
