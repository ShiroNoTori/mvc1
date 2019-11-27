package repository;

import model.Role;

public interface RoleDAO {

    void save(Role role);

    Role findByName(String name);

    Role findById(int id);
}
