package wwwcomcom.gsmeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wwwcomcom.gsmeal.domain.DailyMeal;
import wwwcomcom.gsmeal.dto.ResultDTO;
import wwwcomcom.gsmeal.service.ApiService;

@Controller
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/api")
    public ResultDTO<DailyMeal> getMeal(@RequestParam String date){
        DailyMeal mealData = apiService.getMeal(date);
        int resultCode = mealData.getMeals().isEmpty() ? 0 : 1;
        return ResultDTO.of(resultCode,mealData);
    }

}
