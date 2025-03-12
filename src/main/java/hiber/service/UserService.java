package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(Long id);

}
