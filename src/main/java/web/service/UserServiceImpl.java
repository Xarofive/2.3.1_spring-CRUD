package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        userDao.update(user, id);
    }

    @Override
    @Transactional
    public User showById(int id) {
        return userDao.showById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

}
