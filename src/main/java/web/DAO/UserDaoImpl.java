package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl {

    //временный список вместо БД
    private List<User> userList;
    private static long userCount;

    {
        userList = new ArrayList<>();
        userList.add(new User(++userCount, "Denis", 24));
        userList.add(new User(++userCount, "Anna", 23));
        userList.add(new User(++userCount, "Tobias", 2));
    }

    public List<User> index() {
        return userList;
    }

    public void save(User user) {
        userList.add(new User(++userCount, user.getName(), user.getAge()));
    }

    public void update(User user, int id) {
        for (User existingUser : userList) {
            if (existingUser.getId() == id) {
                existingUser.setName(user.getName());
                existingUser.setAge(user.getAge());
            }
        }
    }

    public User showById(int id) {
        for (User existingUser : userList) {
            if (existingUser.getId() == id) {
                return existingUser;
            }
        }
        return null;
    }

    public void delete(int id) {
        userList.removeIf(existingUser -> existingUser.getId() == id);
    }

}
