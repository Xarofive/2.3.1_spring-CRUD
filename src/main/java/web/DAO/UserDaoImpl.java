package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, int id) {
        entityManager.merge(user);
    }

    @Override
    public User showById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(showById(id));
    }

}
