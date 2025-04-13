package OOP;

public abstract class Shape {
    public abstract void draw();
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
        Rectangle rectangle= new Rectangle();
        rectangle.draw();
    }
}
