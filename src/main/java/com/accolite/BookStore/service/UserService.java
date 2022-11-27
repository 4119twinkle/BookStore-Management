package com.accolite.BookStore.service;

import com.accolite.BookStore.model.User;

import java.util.List;

public interface UserService {
    User createUser(User u);
    User updateUser(User u);

    boolean isEmailValid(String email);

    List<User> getUser();
    User getUserById(long user_id);
    void deleteUser(long user_id);

    double getwallet(User u);

    User updateWallet(User u);
}
