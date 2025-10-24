public class Parrot implements Animal, Flyable {
    
    @Override
    public void makeNoise() {

        System.out.println("Je Hurle Squawk!!!");
    }

    @Override
    public void eat() {

        System.out.println("Je mange des fruits");
    }

    @Override
    public void sleep() {

        System.out.println("Je dors au plus 12h");
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("Je ne vole pas plus de 100m");
    }
}