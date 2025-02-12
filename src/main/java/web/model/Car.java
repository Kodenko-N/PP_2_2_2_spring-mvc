package web.model;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String comment;

    public Car(String brand, String model, int year, String comment) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.comment = comment;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return (brand + " " + model + ". " + comment + " Выпущено в " +
                 + year + "году!");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }
}
