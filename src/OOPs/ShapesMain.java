package OOPs;

public class ShapesMain {
    public static void main(String[] args) {
        //System.out.println("Hello");
        Shapes sq = new Square(10);
        Shapes rect = new Rectangle(5,6);
        rect.printArea();
        sq.printArea();

    }
}
