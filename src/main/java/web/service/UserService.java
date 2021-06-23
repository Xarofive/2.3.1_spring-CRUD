package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> index();

    public void save(User user);

    public void update(User user, int id);

    public User showById(int id);

    public void delete(int id);
}
