package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> index();

    void save(User user);

    void update(User user, int id);

    User showById(int id);

    void delete(int id);
}
