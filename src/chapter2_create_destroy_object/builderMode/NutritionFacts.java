package chapter2_create_destroy_object.builderMode;


/**
 * Buiulder模式
 * 1.保证重叠构造器的安全性
 * 2.保证类似JavaBeans模式的可读性
 * 3.可以添加任意长度的参数,可扩展性
 */

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohrgrate;

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohrgrate = builder.carbohrgrate;
    }

    public static void main(String[] args){
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
                calories(100).sodium(35).carbohrgrate(27).build();
    }

    public static class Builder {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohrgrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder carbohrgrate(int val){
            carbohrgrate = val;
            return this;
        }
    }
}
