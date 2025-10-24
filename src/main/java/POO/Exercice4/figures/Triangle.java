package figures;

public class Triangle extends Shape {
    
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double base, double height, double side1, double side2, double side3){

        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getBase() {
        return this.base;
    }

    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public double getHeight() {
        return this.height;
    }

        @Override
    public double calculateArea() {

        return (base * height)/2;
    }

    @Override
    public double calculatePerimeter() {

        return side1 + side2 + side3;
    }
}
