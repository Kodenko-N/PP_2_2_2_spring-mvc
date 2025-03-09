package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarService;
import web.DAO.CarServiceImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

	private CarService carService = new CarServiceImpl();

	public int CountCheck(int count) {
		if (count < 1) {
			count = 1;
		}
		if (count > carService.getCars().size()) {
			count = carService.getCars().size();
		}
		return count;
	}

	@GetMapping(value = "/cars")
	//Параметр count не защищен от чисел вне пределов int и текстовых данных(!). Если принимать параметр как String
	// можно обработать исключения в CountCheck
	public String printCar(@RequestParam (name = "count", defaultValue = "5", required = false) Integer countUnchecked, ModelMap model) {
		model.addAttribute("cars", carService.getCars().subList(0, CountCheck(countUnchecked)));
		model.addAttribute("cars", carService.getCars().subList(0, countUnchecked));
		return "cars";
	}
	
}