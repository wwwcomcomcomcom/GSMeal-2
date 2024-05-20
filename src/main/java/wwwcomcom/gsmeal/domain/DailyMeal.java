package wwwcomcom.gsmeal.domain;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DailyMeal {
    private int day;
    private ArrayList<Meal> meals;

    public DailyMeal(int day, ArrayList<Meal> meals) {
        if(meals.size() > 3)
            throw new IllegalArgumentException("meals size must be smaller than 3");
        this.day = day;
        this.meals = meals;
    }
    public static DailyMeal emptyMeal(int day) {
        return new DailyMeal(day, new ArrayList<>());
    }

    public boolean isEmpty() {
        return meals.isEmpty();
    }
}
