package Lambdas;

public class Greeter {
    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello Ashu");
        Greeter greeter = new Greeter();
        greeter.greet(greeting);

    }
}
