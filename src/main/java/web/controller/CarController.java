package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAO;
import web.DAO.CarDAOArrayList;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

	private CarDAO carDAO = new CarDAOArrayList();

	public int CountCheck(int count) {
		if (count < 1) {
			count = 1;
		}
		if (count > carDAO.getCars().size()) {
			count = carDAO.getCars().size();
		}
		return count;
	}

	@GetMapping(value = "/cars")
	//Параметр count не защищен от чисел вне пределов int и текстовых данных(!). Если принимать параметр как String
	// можно обработать исключения в CountCheck
	public String printCar(@RequestParam (name = "count", defaultValue = "5") int countUnchecked, ModelMap model) {
		int count = CountCheck(countUnchecked);
		List <Car> cars = carDAO.getCars();
		List<String> messages = new ArrayList<>();
		messages.add("Вы запросили показать классные тачки. Вот они:");
		for (int i = 0; i < count; i++) {
			messages.add(cars.get(i).toString());
		}
		model.addAttribute("messages", messages);
		return "cars";
	}
	
}