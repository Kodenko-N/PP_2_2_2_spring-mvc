package web.DAO;

import org.springframework.stereotype.Component;
import web.config.HibernateUtil;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int userIDcount;
    private List<User> users;
    {
        users = new ArrayList<User>();
        users.add(new User(++userIDcount, "Ванюша", "Иванов", "Водочка"));
        users.add(new User(++userIDcount, "Леночка", "Иванова", "Просеко"));
        users.add(new User(++userIDcount, "Сереженька", "Сергеев", "Дядюшка СЭМ"));
        users.add(new User(++userIDcount, "Катюша", "Петрова", "Шампанское"));
        users.add(new User(++userIDcount, "Петя", "Васечкин", "Вискарик"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User userShow (int userIDin) {
        User user = null;
        if (userIDin <= userIDcount) {
            user = users.get(userIDin-1);
        }
        return user;
    }

    public void save (User user) {
       /*
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();
        System.out.println("SAVE USER, entityManager: " + entityManager);
        EntityTransaction transaction = null;
        for (User u : users) {
            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                entityManager.persist(user);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
        }

        */
        user.setId(++userIDcount);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userForUpdate = userShow(id);
        userForUpdate.setName(updatedUser.getName());
        userForUpdate.setSecondName(updatedUser.getSecondName());
        userForUpdate.setAlcoholType(updatedUser.getAlcoholType());
    }

    public void delete (int id) {
        users.remove(id-1);
        userIDcount--;
        //users.removeIf(p -> p.getId() == id);
    }

}
