public class Lion implements Animal {
    
    @Override
    public void makeNoise() {

        System.out.println("Je rugis Rooaarrrr!!!!");
    }

    @Override
    public void eat() {

        System.out.println("I eat meat");
    }

    @Override
    public void sleep() {

        System.out.println("Je dors 18h par jours");
    }
}
