package web.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;

@Component
public class CarServiceImpl implements CarService {
    ArrayList <Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Subaru", "Impreza WRX STI", 1997, "Машина мечты!"));
        cars.add(new Car("Ford", "Mustang", 1984, "Как в фильмах!"));
        cars.add(new Car("Nissan", "SkyLine", 1970, "Настоящий Японец!"));
        cars.add(new Car("BMW", "550", 1993, "Баварская классика!"));
        cars.add(new Car("Porsche", "911", 1988, "Porsche и этим всё сказано!"));
    }

    @Override
    public ArrayList<Car> getCarsByCount(int count) {
        return new ArrayList<Car> (cars.subList(0,Math.min(5, Math.abs(count))));
    }

}
