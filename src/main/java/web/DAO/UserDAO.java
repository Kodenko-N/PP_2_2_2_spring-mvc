package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int userID;
    private List<User> users;
    {
        users = new ArrayList<User>();
        users.add(new User(++userID, "Ванюша", "Иванов", "Водочка"));
        users.add(new User(++userID, "Леночка", "Иванова", "Просеко"));
        users.add(new User(++userID, "Сереженька", "Сергеев", "Дядюшка СЭМ"));
        users.add(new User(++userID, "Катюша", "Петрова", "Шампанское"));
        users.add(new User(++userID, "Петя", "Васечкин", "Вискарик"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User userShow (int userIDin) {
        User user = null;
        if (userIDin <= userID) {
            user = users.get(userIDin-1);
        }
        return user;
    }

}
