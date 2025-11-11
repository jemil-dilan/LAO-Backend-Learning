package POO.Exercice4.figures;

public class ShapesCalculator {
    
    Shape anyShape;

    public ShapesCalculator(Shape shape){

        this.anyShape = shape;
    }

    public double getArea(){

        return anyShape.calculateArea();
    }

    public double getPerimeter(){

        return anyShape.calculatePerimeter();
    }
}
