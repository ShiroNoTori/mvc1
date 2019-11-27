package repository;

import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        Session session = getSession();
        session.persist(user);
    }

    @Override
    public void update(User user) {
        Session session = getSession();

        session.update(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = getSession();

        List<User> list = session.createQuery("from User").list();
        return list;
    }

    @Override
    public User findById(Integer id) {
        Session session = getSession();

        User user = session.load(User.class, id);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        Session session = getSession();

        Query query = session.createQuery("from User where login = :login");
        query.setParameter("login", login);
        return (User) query.uniqueResult();
    }

    @Override
    public void deleteById(Integer id) {
        Session session = getSession();

        User user = session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
    }
}
