package repository;

import model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    void update(User user);

    List<User> findAll();

    User findById(Integer id);

    User findByLogin(String login);

    void deleteById(Integer id);
}