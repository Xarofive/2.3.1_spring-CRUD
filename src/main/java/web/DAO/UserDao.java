package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    void save(User user);

    void update(User user, Long id);

    User showById(Long id);

    void delete(Long id);
}
