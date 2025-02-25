package web.model;

public class User {

    private int id;
    private String name;
    private String secondName;
    private String alcoholType;

    public User(int id, String name, String secondName, String alcoholType) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.alcoholType = alcoholType;
    }

    public User(String name, String secondName, String alcoholType) {
        this.name = name;
        this.secondName = secondName;
        this.alcoholType = alcoholType;
    }

    public User() { }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(String alcoholType) {
        this.alcoholType = alcoholType;
    }

    @Override
    public String toString() {
        return "Этого человека зовут " + name + " " + secondName + " (ID = "
                 + id + " и он предпочитает " + alcoholType;

    }
}
