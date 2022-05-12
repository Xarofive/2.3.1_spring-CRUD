package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void create(User user);

    void update(User user, Long id);

    User get(Long id);

    void delete(Long id);
}
