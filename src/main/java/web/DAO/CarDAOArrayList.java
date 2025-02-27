package web.DAO;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAOArrayList implements CarDAO {
    ArrayList<Car> cars = new ArrayList<>();

    {
        Car car1 = new Car("Subaru", "Impreza WRX STI", 1997, "Машина мечты!");
        Car car2 = new Car("Ford", "Mustang", 1984, "Как в фильмах!");
        Car car3 = new Car("Nissan", "SkyLine", 1970, "Настоящий Японец!");
        Car car4 = new Car("BMW", "550", 1993, "Баварская классика!");
        Car car5 = new Car("Porsche", "911", 1988, "Porsche и этим всё сказано!");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    @Override
    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCar(int id) {
        return cars.get(id);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void updateCar(Car car, int id) {
        cars.set(id, car);
    }

    @Override
    public void deleteCar(int id) {
        cars.remove(id);
    }
}
