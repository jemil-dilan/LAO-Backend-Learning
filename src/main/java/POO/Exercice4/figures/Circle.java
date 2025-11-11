package POO.Exercice4.figures;

public class Circle extends Shape {
    
    private double radius;
    private static final double PI = Math.PI;

    public Circle(double radius){

        this.radius = radius;
    }

    public double getRadius(){

        return radius;
    }

    @Override
    public double calculateArea() {

        return radius * radius * PI;
    }

    @Override
    public double calculatePerimeter() {

        return 2 * radius * PI;
    }
}
