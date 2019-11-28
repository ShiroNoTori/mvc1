package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserDAO;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserDAO dao;

    @Autowired
    private UserService userService;

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

    public User findByLogin(String login) {
        return dao.findByLogin(login);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Login " + login + " not found.");
        }

        return user;
    }
}
