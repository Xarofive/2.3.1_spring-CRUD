package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, int id) {
        Query query = entityManager.createQuery("update User set name = :name, age = :age where id = :id");
        query.setParameter("name", user.getName());
        query.setParameter("age", user.getAge());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User showById(int id) {
        TypedQuery<User> query = entityManager.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
