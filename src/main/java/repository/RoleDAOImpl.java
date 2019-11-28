package repository;

import model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Role role) {
        Session session = getSession();
        session.persist(role);
    }

    @Override
    public Role findByName(String name) {
        Session session = getSession();

        Query query = session.createQuery("from Role where name = :name");
        query.setParameter("name", name);
        return (Role) query.uniqueResult();
    }

    @Override
    public Role findById(int id) {
        Session session = getSession();

        return session.get(Role.class, id);
    }
}
