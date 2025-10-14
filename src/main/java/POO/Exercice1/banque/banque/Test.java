package banque.banque;

public class Test {

    public static void main(String[] args) {
        
        CompteBancaire compte1 = new CompteBancaire();
        CompteBancaire compte2 = new CompteBancaire();
        
        compte1.setSolde(2000);
        compte2.setSolde(2000);
        System.out.println(compte1.transferer(500, compte2));
    }
}
