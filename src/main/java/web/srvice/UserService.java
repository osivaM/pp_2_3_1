package web.srvice;

import web.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User user);
}
