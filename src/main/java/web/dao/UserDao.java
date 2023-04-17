package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    User getUser(Long id);

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User user);
}
