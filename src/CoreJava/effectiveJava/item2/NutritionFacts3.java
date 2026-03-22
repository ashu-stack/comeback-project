package CoreJava.effectiveJava.item2;

// BUILDER PATTERN
public class NutritionFacts3 {
    private int servingSize;
    private int servings;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;

    public static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories;
        private int protein;
        private int carbs;
        private int fat;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }

        public Builder protein(int val){
            this.protein = val;
            return this;
        }

        public Builder carbs(int val){
            this.carbs = val;
            return this;
        }

        public Builder fat(int val){
            this.fat = val;
            return this;
        }

        public NutritionFacts3 build(){
            return new NutritionFacts3(this);
        }

    }

    public NutritionFacts3(Builder builder) {
        this.servingSize = builder.servingSize;
        servings = builder.servings;
        this.calories = builder.calories;
        this.protein = builder.protein;
        this.carbs = builder.carbs;
        this.fat = builder.fat;
    }

    @Override
    public String toString() {
        return "NutritionFacts3{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts3 banana = new NutritionFacts3.Builder(50, 2).calories(100).build();
        System.out.println(banana);

    }
}
