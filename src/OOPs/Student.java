package OOPs;

public class Student {
    public final String SCHOOL_NAME = "Swami Vivekanand Internation School";
   private int roll;
   private String name;
    private int marks;
    static int age = 15;


    public Student() {
        System.out.println("Empty constructor called");
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Student(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public  void changeProperties(String name , int roll, int marks){
         this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public static void setAge(int num){
        age = num;
    }





}
