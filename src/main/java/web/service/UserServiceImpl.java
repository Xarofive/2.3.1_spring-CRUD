package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> index() {
        List<User> users = userDao.index();
        log.info("Получен список всех пользователей");
        return users;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
        log.info("Пользователь с именем={} сохранен", user.getName());
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        userDao.update(user, id);
        log.info("Пользователь с id={} обновлен", id);
    }

    @Override
    @Transactional
    public User showById(int id) {
        User user = userDao.showById(id);
        log.info("Пользователь с id={} найден", id);
        return user;
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
        log.info("Пользователь с id={} удален", id);
    }

}
