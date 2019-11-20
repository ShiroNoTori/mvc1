package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserDAO;

import java.util.List;

@Service
public class UserService {

    private UserDAO dao;

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void save(User user) {
        dao.save(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public User findById(Integer id) {
        return dao.findById(id);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
