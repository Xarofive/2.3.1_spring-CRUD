package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> index();

    void save(User user);

    void update(User user, Long id);

    User showById(Long id);

    void delete(Long id);
}
