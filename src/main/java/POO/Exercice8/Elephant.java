public class Elephant implements Animal {
    
    @Override
    public void makeNoise() {

        System.out.println("Je barrisse Brrrraaaaaaahhhh!");
    }

    @Override
    public void eat() {

        System.out.println("Je suis végétarien");
    }

    @Override
    public void sleep() {

        System.out.println("Je dors très peu, au plus 4h par jour");
    }
}