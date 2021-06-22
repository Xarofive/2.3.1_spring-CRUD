package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

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

    public User deleteById(long id) {
        return new User();
    }

    public void addUser(String name, int age) {
        userList.add(new User(++userCount,name, age));
    }

    public void updateNameById(long id, String name) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
            }
        }
    }

    public void updateAgeById(long id, int age) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setAge(age);
            }
        }
    }

    public void updateNameAndAgeById(long id, String name, int age) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
                user.setAge(age);
            }
        }
    }

}
