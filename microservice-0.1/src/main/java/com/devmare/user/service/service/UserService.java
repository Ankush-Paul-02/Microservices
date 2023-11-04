package com.devmare.user.service.service;

import com.devmare.user.service.entity.User;

import java.util.List;

public interface UserService {

    //! Create User
    User createUser(User user);

    //! Get all User
    List<User> getAllUser();

    //! Get User by Id
    User getUser(String userId);

    //! Update User
    User updateUser(User user, String userId);

    //! Delete User
    void deleteUser(String userId);
}
