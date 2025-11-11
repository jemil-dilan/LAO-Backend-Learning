package POO.Exercice8.zoo;

public class Manchot implements Animal{
    
    @Override
    public void makeNoise() {

        System.out.println("Je trumpette Aaah-aaaah-aaaah!");
    }

    @Override
    public void eat() {

        System.out.println("Je mange beaucoup de poisson");
    }

    @Override
    public void sleep() {

        System.out.println("Je dors plus de 8h par jours");
    }

}