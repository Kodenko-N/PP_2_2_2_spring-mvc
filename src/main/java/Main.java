import web.DAO.UserDAO;
import web.config.HibernateUtil;
import web.model.User;

import java.util.List;



public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Создание нового пользователя
        User user1 = new User("Ivan", "Petrov", "Vodka");
        userDAO.save(user1);

        User user2 = new User("Sergey", "Ivanov", "beer");
        userDAO.save(user2);

        // Получение и вывод всех пользователей
        /*
        List<User> users = userDAO.getAllUsers();
        if (users != null) {
            System.out.println("Список всех пользователей:");
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
            }
        }

         */

        // Закрытие EntityManagerFactory
        HibernateUtil.shutdown();
    }

}
