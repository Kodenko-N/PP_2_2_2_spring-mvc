package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

	@GetMapping(value = "/cars")
	public String printCar(ModelMap model, HttpServletRequest request) {

		Car car1 = new Car("Subaru", "Impreza WRX STI", 1997, "Машина мечты!");
		Car car2 = new Car("Ford", "Mustang", 1984, "Как в фильмах!");
		Car car3 = new Car("Nissan", "SkyLine", 1970, "Настоящий Японец!");
		Car car4 = new Car("BMW", "550", 1993, "Баварская классика!");
		Car car5 = new Car("Porsche", "911", 1988, "Все телки будут твои!");
		List <Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);


		String countString = request.getParameter("count");
		String error;
		int count = cars.size();
		try {
		count = Integer.parseInt(countString);
		if (count < 1) {
			error = "Бро, если совсем не интересно, посмотри хотя бы одну! Вот эту:";
			count = 1;
		}
		else if (count > cars.size()) {
			error = "Я не могу показать тебе " + count + " машин! У меня их всего " + cars.size();
			count = cars.size();
		}
		else {
			error = "Вы запросили показать " + count + " классных тачек. Вот они:";
		}
		}
		catch (NumberFormatException e) {
			 error = "Из запроса не понял сколько машин надо выводить. Выведу всё что есть!";
		}
		List<String> messages = new ArrayList<>();
		messages.add(error);
		for (int i = 0; i < count; i++) {
			messages.add(cars.get(i).toString());
		}
		model.addAttribute("messages", messages);
		return "cars";
	}
	
}