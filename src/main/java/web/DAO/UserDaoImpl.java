package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, Long id) {
        entityManager.merge(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(get(id));
    }

}
