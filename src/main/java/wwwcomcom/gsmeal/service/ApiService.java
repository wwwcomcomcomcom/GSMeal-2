package wwwcomcom.gsmeal.service;

import org.springframework.stereotype.Service;
import wwwcomcom.gsmeal.domain.DailyMeal;

import java.util.Optional;

@Service
public class ApiService {
    public DailyMeal getMeal(String date){
        return DailyMeal.emptyMeal(1);
    }
}
