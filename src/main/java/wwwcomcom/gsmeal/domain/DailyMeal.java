package wwwcomcom.gsmeal.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Builder
@Getter
public class DailyMeal {
    private int day;
    private ArrayList<Meal> meals;

    public DailyMeal(int day, ArrayList<Meal> meals) {
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
