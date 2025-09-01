package OOPs;

public class Director {

   private String name ;
   private int age;
   private int experience;

   private static Director instance;
    public Director() {
        System.out.println("Empty constructor");
    }
    public static Director getDirector(){
        if(instance == null){
            instance = new Director("Ashutosh", 50, 18);
        }
        return instance;
    }

    private Director(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }
}
