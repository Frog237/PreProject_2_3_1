package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);

}
