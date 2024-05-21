package wwwcomcom.gsmeal.domain;


import lombok.Getter;
import org.json.simple.JSONObject;
@Getter
public class Meal {

    private int mealType;

    private String[] menu;

    public Meal(String[] menu, int mealType) {
        this.menu = menu;
        this.mealType = mealType;
    }
    public static Meal fromJson(JSONObject object) {
        String menuStr = (String) object.get("DDISH_NM");
        String typeStr = (String) object.get("MMEAL_SC_CODE");
        return new Meal(menuStr.split("<br/>"),Integer.parseInt(typeStr));
    }
}
