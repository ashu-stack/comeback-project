package CoreJava.effectiveJava.item2;

//JAVA BEANS PATTERN
public class NutritionFacts2 {
    private int servingSize; // required
    private int servings; // required
    private int carbs;
    private int protein;
    private int calories;

    public NutritionFacts2(){

    }
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "NutritionFacts2{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", carbs=" + carbs +
                ", protein=" + protein +
                ", calories=" + calories +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts2 whey = new NutritionFacts2();
        whey.setServingSize(25);
        whey.setServings(1);
        whey.setProtein(12);

        System.out.println(whey);
    }
}
