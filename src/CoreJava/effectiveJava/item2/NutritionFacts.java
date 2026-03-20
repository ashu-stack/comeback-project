package CoreJava.effectiveJava.item2;

//TELESCOPING CONSTRUCTOR PATTERN
public class NutritionFacts {
    private  int servingSize; // required
    private int servings; //required
    private int calories;
    private int fat;
    private int carbs;

    public NutritionFacts(int servingSize, int servings){
        this.servingSize  = servingSize;
        this.servings = servings;
    }

    public NutritionFacts(int servingSize, int servings, int calories ){
        this.servingSize  = servingSize;
        this.servings = servings;
        this.calories = calories;
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat){
        this.servingSize  = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int carbs){
        this.servingSize  = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbs=" + carbs +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts lays = new NutritionFacts(100, 10);

        System.out.println(lays.toString());

        NutritionFacts coke = new NutritionFacts(200, 2, 500);
        System.out.println(coke);
    }

}
