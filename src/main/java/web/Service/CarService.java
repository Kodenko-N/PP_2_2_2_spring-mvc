package web.Service;

import web.model.Car;

import java.util.List;

public interface CarService {
    public List<Car> getCarsByCount(int count);

}


