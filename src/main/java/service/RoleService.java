package service;

import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleDAO;

@Service
public class RoleService {

    private RoleDAO dao;

    @Autowired
    public void setDao(RoleDAO dao) {
        this.dao = dao;
    }

    public void save(Role role) {
        dao.save(role);
    }

    public Role findByName(String name) {
        return dao.findByName(name);
    }

    public Role findById(int id) {
        return dao.findById(id);
    }
}
