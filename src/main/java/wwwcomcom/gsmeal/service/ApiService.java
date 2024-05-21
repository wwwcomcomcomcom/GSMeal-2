package wwwcomcom.gsmeal.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wwwcomcom.gsmeal.domain.DailyMeal;
import wwwcomcom.gsmeal.domain.Meal;
import java.util.ArrayList;

@Service
public class ApiService {

    @Value("${api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final JSONParser jsonParser = new JSONParser();
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DailyMeal getMeal(String date) {
        return fetchMealData(date);
    }
    private DailyMeal fetchMealData(String date) {
        int dateAsNum = Integer.parseInt(date);
        String url = String.format("https://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=F10&SD_SCHUL_CODE=7380292&MLSV_YMD=%s&Type=json&KEY=%s",date,apiKey);
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        JSONObject rawApiResponse;
        try {
            rawApiResponse = (JSONObject) jsonParser.parse(response.getBody());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            JSONArray res = (JSONArray) rawApiResponse.get("mealServiceDietInfo");
            if(res == null) throw new NullPointerException();
            JSONArray jsonMeals = (JSONArray)((JSONObject)res.get(1)).get("row");
            if(jsonMeals == null) throw new NullPointerException();

            ArrayList<Meal> meals = new ArrayList<>();
            for (Object jsonMeal : jsonMeals) {
                meals.add(Meal.fromJson((JSONObject) jsonMeal));
            }

            return DailyMeal.builder()
                    .day(dateAsNum)
                    .meals(meals)
                    .build();
        } catch (NullPointerException e) {
            System.out.println("No meal data for " + date);
        }
        return DailyMeal.emptyMeal(dateAsNum);
    }
}
