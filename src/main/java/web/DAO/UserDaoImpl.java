package web.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    //заменить на EntityManager
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(User user, int id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("update User set name = :name, age = :age where id = :id");
        query.setParameter("name", user.getName());
        query.setParameter("age", user.getAge());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User showById(int id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(int id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
