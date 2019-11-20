package repository;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOJDBCImpl implements UserDAO {

    private DriverManagerDataSource dataSource;

    @Autowired
    public UserDAOJDBCImpl(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User user) {
        try (PreparedStatement statement = dataSource.getConnection()
                .prepareStatement("insert INTO user (login, name, password) VALUES (?, ?, ?)")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement("select * from user")) {
            statement.execute();
            ResultSet res = statement.getResultSet();
            while (res.next()) {
                User user = new User(
                        res.getInt("id"),
                        res.getString("login"),
                        res.getString("name"),
                        res.getString("password")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public User findById(Integer id) {
        User user = null;

        try (PreparedStatement statement = dataSource.getConnection()
                .prepareStatement("select id, login, name, password from user where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet res = statement.getResultSet();

            if (res.next()) {
                user = new User(
                        res.getInt("id"),
                        res.getString("login"),
                        res.getString("name"),
                        res.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = dataSource.getConnection()
                .prepareStatement("UPDATE user SET name = ?, password = ? where id = ?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement statement = dataSource.getConnection()
                .prepareStatement("DELETE from user where id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
