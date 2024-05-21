package wwwcomcom.gsmeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wwwcomcom.gsmeal.domain.DailyMeal;
import wwwcomcom.gsmeal.dto.ResultDTO;
import wwwcomcom.gsmeal.service.ApiService;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/api")
    public DailyMeal getMeal(@RequestParam String date){
        DailyMeal mealData = apiService.getMeal(date);
        return mealData;
    }

}
