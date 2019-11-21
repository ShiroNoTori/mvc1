package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDAO;

import java.util.List;

@Service
public class UserService {

    private UserDAO dao;

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public void save(User user) {
        dao.save(user);
    }

    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Transactional
    public List<User> findAll() {
        return dao.findAll();
    }

    @Transactional
    public User findById(Integer id) {
        return dao.findById(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
