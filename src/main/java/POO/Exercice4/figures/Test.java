package POO.Exercice4.figures;

public class Test {

    public static void main(String[] args) {

        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(10, 45);
        Triangle triangle = new Triangle(6, 4, 5,5,6);

        ShapesCalculator calculator1 = new ShapesCalculator(circle);
        ShapesCalculator calculator2 = new ShapesCalculator(rectangle);
        ShapesCalculator calculator3 = new ShapesCalculator(triangle);

        System.out.println("The circle area is: " + calculator1.getArea() + " and his perimeter: " + calculator1.getPerimeter());
        System.out.println("The rectangle area is: " + calculator2.getArea() + " and his perimeter: " + calculator2.getPerimeter());
        System.out.println("The triangle area is: " + calculator3.getArea() + " and his perimeter: " + calculator3.getPerimeter());
    }
}
