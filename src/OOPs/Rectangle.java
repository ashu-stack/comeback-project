package OOPs;

public class Rectangle extends Shapes{
     int length;
     int breadth;


    public Rectangle() {
        System.out.println("Rectangle constructor called");
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void printArea(){
        System.out.println("Area : " + this.length*this.breadth);
    }

    public void printArea(int length){
        System.out.println("Area: " + length*length);
    }


}
