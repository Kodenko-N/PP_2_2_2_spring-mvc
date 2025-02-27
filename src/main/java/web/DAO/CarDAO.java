package web.DAO;

import web.model.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> getCars();
    public Car getCar(int id);
    public void addCar(Car car);
    public void updateCar(Car car, int id);
    public void deleteCar(int id);
}


