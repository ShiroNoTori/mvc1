package repository;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        Session session = getSession();
        session.persist(user);
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = getSession();
        session.update(user);
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = getSession();
        List<User> list = session.createQuery("from User").list();
        session.close();
        return list;
    }

    @Override
    public User findById(Integer id) {
        Session session = getSession();

        User user = session.load(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = getSession();

        User user = session.load(User.class, id);
        if(null != user){
            session.delete(user);
        }
    }
}
