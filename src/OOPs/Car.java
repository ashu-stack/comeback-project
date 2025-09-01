package OOPs;

public class Car implements Engine,Brake,Media{

    @Override
    public void start() {
        System.out.println("Car engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stops");
    }

    @Override
    public void acc() {
        System.out.println("Car engine accelerates");
    }
}
