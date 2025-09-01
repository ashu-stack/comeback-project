package OOPs;

public class Square extends Shapes{
     int side;

    public Square(int side) {
        this.side = side;
    }
    @Override
    public void printArea(){
        System.out.println("Area : " + this.side*this.side);
    }


}
